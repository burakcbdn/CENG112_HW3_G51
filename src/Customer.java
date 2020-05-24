public class Customer implements ICustomer {
    private String type;
    private String seatNo;

    public Customer(String type, String seatNo) {
        this.type = type;
        this.seatNo = seatNo;
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

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public String toString() {
        return null;
    }


}
