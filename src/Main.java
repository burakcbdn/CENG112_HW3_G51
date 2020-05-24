import javax.print.attribute.standard.PrinterURI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        ListADT<PurchaseQueue> purchaseQueues = new ListADT<>();
        ListADT<Purchase> purchases = new ListADT<Purchase>();
        ListADT<String> dates = new ListADT<>();
        try {
            Path path = Paths.get("src/CENG112_HW3_TicketingPurchase.txt");
            String[] lines = Files.readAllLines(path).toArray(String[]::new);

            int totalTime = 0;
            for (String line : lines) {
                String[] parsedPurchase = line.split(",");
                String date = parsedPurchase[0];

                if (!dates.contains(date)) {
                    dates.add(date);

                }
                int purchaseID = Integer.parseInt(parsedPurchase[1]);
                String customerType = parsedPurchase[2];
                String seatNo = parsedPurchase[3];
                int occupationTime = Integer.parseInt(parsedPurchase[4]);
                totalTime += occupationTime;
                Customer customer = new Customer(customerType, seatNo);
                Purchase purchase = new Purchase(purchaseID, customer, occupationTime, totalTime, date);
                purchases.add(purchase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        String[][] deneme;

        ListADT<Object> datesCreated = new ListADT<Object>();
        for (int index = 0; index < dates.getLength(); index++) {
            //I used Object[] for handling casting errors.
                Object[] tempDates = dates.toArray();
                String date = (String) tempDates[index];
                if (!datesCreated.contains(date)) {
                    PurchaseQueue purchaseQueue = new PurchaseQueue(100, date);
                    Object[] tempPurchases = purchases.toArray();
                    for (Object tempPurchase : tempPurchases){
                        Purchase purchase = (Purchase) tempPurchase;
                        if (purchase.getDate().equals(date)) {
                            purchaseQueue.insert(purchase);
                        }
                    }
                    datesCreated.add(date);
                    purchaseQueues.add(purchaseQueue);
                }

        }

        for (int index = 0; index < purchaseQueues.getLength(); index++){
            //I used Object[] for handling casting errors.
            Object[] tempQueues = purchaseQueues.toArray();
            PurchaseQueue purchaseQueue = (PurchaseQueue) tempQueues[index];
            if (purchaseQueue.getHeap() != null){
                int total = 0;
                int goldCount =0;
                int goldWaitingTime = 0;

                int silverCount = 0;
                int silverWaitingTime = 0;
                int bronzeCount = 0;
                int bronzeWaitingTime = 0;
                int freeCount = 0;
                int freeWaitingTime = 0;

                for (Purchase purchase : purchaseQueue.getHeap()) {
                    if (purchase != null) {
                        switch (purchase.getCustomer().getType()) {
                            case "GOLD":
                                goldCount += 1;
                                total += 1;
                                goldWaitingTime += purchase.getOccupation();
                                break;
                            case  "SILVER":
                                silverCount += 1;
                                total += 1;
                                silverWaitingTime += purchase.getOccupation();
                                break;
                            case "BRONZE":
                               bronzeCount+=1;
                                total += 1;
                                bronzeWaitingTime += purchase.getOccupation();
                               break;
                            case  "FREE":
                                freeCount += 1;
                                total += 1;
                                freeWaitingTime += purchase.getOccupation();
                                break;
                        }
                    }
                }

                int goldAverage = goldCount != 0 ? goldWaitingTime / goldCount : 0;
                int silverAverage = silverCount != 0 ? silverWaitingTime / silverCount : 0;
                int bronzeAverage = bronzeCount != 0 ? bronzeWaitingTime / bronzeCount : 0;
                int freeAverage = freeCount != 0 ? freeWaitingTime / freeCount : 0;


                System.out.println("Day: " + purchaseQueue.getDate());
                System.out.println("Purchase Queue: " + purchaseQueue.getQueueString());
                System.out.println("Total number of tickets sold: " + total);
                System.out.println("Total waiting time: " + purchaseQueue.getTotalWaitingTime());
                System.out.println("Average waiting time: " + purchaseQueue.getTotalWaitingTime() / total );
                System.out.println("Total number of tickets sold for GOLD : " + goldCount);
                System.out.println("Total number of tickets sold for SILVER : " + silverCount);
                System.out.println("Total number of tickets sold for BRONZE : " + bronzeCount);
                System.out.println("Total number of tickets sold for FREE : " + freeCount);
                System.out.println("Total waiting time for GOLD: " + goldWaitingTime);
                System.out.println("Average waiting time for GOLD: " + goldAverage);
                System.out.println("Total waiting time for SILVER: " + silverWaitingTime);
                System.out.println("Average waiting time for SILVER: " + silverAverage);
                System.out.println("Total waiting time for BRONZE: " + bronzeWaitingTime);
                System.out.println("Average waiting time for BRONZE: " + bronzeAverage);
                System.out.println("Total waiting time for FREE: " + freeWaitingTime);
                System.out.println("Average waiting time for FREE: " + freeAverage);
                System.out.println("Recent avenue: ");

            }
        }
    }
}
