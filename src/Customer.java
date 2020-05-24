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
                return 4;
            case  "SILVER":
                return  3;
            case "BRONZE":
                return  2;
            case  "FREE":
                return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOccupation_time() {
        return occupation_time;
    }

    public void setOccupation_time(int occupation_time) {
        this.occupation_time = occupation_time;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
