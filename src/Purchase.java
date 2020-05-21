public class Purchase {
    private int id;
    private ICustomer customer;
    private int occupation;
    private int waiting;
    private Purchase next;

    public Purchase(int id, ICustomer customer, int occupation, int waiting, Purchase next) {
        this.id = id;
        this.customer = customer;
        this.occupation = occupation;
        this.waiting = waiting;
        this.next = next;
    }

    public String toString() {
        return null;
    }

}
