import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PurchaseQueue purchaseQueue = new PurchaseQueue(100);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            Path path = Paths.get("src/CENG112_HW3_TicketingPurchase.txt");
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parsedPurchase = line.split(",");
                String date = parsedPurchase[0];
                int purchaseID = Integer.parseInt(parsedPurchase[1]);
                String customerType = parsedPurchase[2];
                String seatNo = parsedPurchase[3];
                int occupationTime = Integer.parseInt(parsedPurchase[4]);

                Customer customer = new Customer(customerType,occupationTime, purchaseID, seatNo, date);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        for (Customer customer : customers) {
            Purchase purchase = new Purchase(customer.getPurchase_id(), customer, customer.getOccupation_time(), 5);
            purchaseQueue.insert(purchase);
        }

        int length = purchaseQueue.getQueueLength();
        int count = 0;
        for (Purchase purchase : purchaseQueue.getHeap()) {
            if (count > length) {
                break;
            }
            System.out.println(purchase.getId());
            count++;
        }




    }
}
