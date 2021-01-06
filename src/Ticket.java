public class Ticket {
    public static int _id = 0;
    private int id;
    private int price;
    private String destination;
    private String deptTime;
    private String seat;
    private String cls;

    public Ticket(int price, String destination, String deptTime, String seat, String cls) {
        this.id = Ticket._id;
        this.price = price;
        this.destination = destination;
        this.deptTime = deptTime;
        this.seat = seat;
        this.cls = cls;

        Ticket._id++;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public String getDest() {
        return this.destination;
    }

    public String getDeptTime() {
        return this.deptTime;
    }

    public String getSeat() {
        return this.seat;
    }

    public String getTicketClass() {
        return this.cls;
    }
}
