public class Purchase {
    private int id;
    private ICustomer customer;
    private int occupation;
    private int waiting;
    private String date;

    private int priority;

    public Purchase(int id, ICustomer customer, int occupation, int waiting, String date) {
        this.id = id;
        this.customer = customer;
        this.occupation = occupation;
        this.waiting = waiting;
        this.priority = customer.getPriority();
        this.date = date;
    }

    public String toString() {
        return null;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public String getDate() {
        return date;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }
}
