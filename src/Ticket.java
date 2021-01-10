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

    /**
     * Gets the ticket id
     * 
     * @return the id of this ticket
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the ticket price
     * 
     * @return the cost of this ticket
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Gets the destination of the flight
     * 
     * @return the destination of the ticket
     */
    public String getDest() {
        return this.destination;
    }

    /**
     * Gets the departure time of the flight
     * 
     * @return the departure time
     */
    public String getDeptTime() {
        return this.deptTime;
    }

    /**
     * Gets the seat the passenger will sit in
     * 
     * @return the seat number
     */
    public String getSeat() {
        return this.seat;
    }

    /**
     * Gets the class that the passenger will be flying - either first, business, or
     * economy
     * 
     * @return the class of the ticket
     */
    public String getTicketClass() {
        return this.cls;
    }
}
