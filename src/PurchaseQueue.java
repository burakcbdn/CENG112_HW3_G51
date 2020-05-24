//Purchase queue

public class PurchaseQueue{
    private Purchase head;
    private int queueLength;
    private int totalWaitingTime;
    private String date;
    private PurchaseQueue next;
    private int capacity;

    private Purchase[] heap;

    public PurchaseQueue(int capacity, String date) {
        this.capacity = capacity + 1;
        heap = new Purchase[capacity];
        queueLength = 0;
        this.date = date;
    }

    public void insert(Purchase purchase) {
        heap[++queueLength] = purchase;
        int pos = queueLength;

        while (pos != 1 && purchase.getPriority() > heap[pos/2].getPriority()) {
            heap[pos] = heap[pos/2];
            pos /= 2;
        }

        heap[pos] = purchase;
    }

    public Purchase remove() {
        int parent, child;
        Purchase item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[1];
        temp = heap[queueLength--];

        parent = 1;
        child = 2;
        while (child <= queueLength)
        {
            if (child < queueLength && heap[child].getPriority() < heap[child + 1].getPriority())
                child++;
            if (temp.getPriority() >= heap[child].getPriority())
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }


    public boolean isEmpty() {
        return queueLength == 0;
    }

    public boolean isFull() {
        return queueLength == capacity -1;
    }

    public boolean clear() {
        if (isEmpty())  {
            return false;
        } else {
            heap = new Purchase[capacity];
            queueLength = 0;
            return true;
        }
    }

    public String toString() {
        String a = "";
        for (Purchase purchase : heap) {
           a += purchase.getCustomer().getType();
        }
        return a;
    }

    public Purchase getHead() {
        return head;
    }

    public void setHead(Purchase head) {
        this.head = head;
    }

    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    public int getTotalWaitingTime() {
        int totalTime = 0;

        for (Purchase purchase : heap) {
            if (purchase != null) {
                totalTime += purchase.getOccupation();
            }

        }
        totalWaitingTime = totalTime;
        return totalWaitingTime;
    }

    public void setTotalWaitingTime(int totalWaitingTime) {
        this.totalWaitingTime = totalWaitingTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PurchaseQueue getNext() {
        return next;
    }

    public void setNext(PurchaseQueue next) {
        this.next = next;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Purchase[] getHeap() {
        return heap;
    }

    public void setHeap(Purchase[] heap) {
        this.heap = heap;
    }

    public String getQueueString() {
        String output = "";
        for (Purchase purchase : heap) {
            String temp = "";
            if (purchase != null) {
                Purchase removed = remove();
                temp += String.valueOf(removed.getId()) + ",";
                temp += removed.getCustomer().getType() + ",";
                temp += removed.getCustomer().getSeatNo() + ",";
                temp += String.valueOf(removed.getOccupation());
                output += temp + " <= ";
            }

        }
        return output;
    }

}
