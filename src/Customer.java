public class Customer implements ICustomer {
    private String type;
    private int occupation_time;
    private  int purchase_id;
    private String seat_no;
    private String date;

    public Customer(String type, int occupation_time, int purchase_id, String seat_no, String date) {
        this.type = type;
        this.occupation_time = occupation_time;
        this.purchase_id = purchase_id;
        this.seat_no = seat_no;
        this.date = date;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPriority() {
        switch (type) {
            case "GOLD":
                return 1;
            case  "SILVER":
                return  2;
            case "BRONZE":
                return  3;
            case  "FREE":
                return 4;
        }
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
