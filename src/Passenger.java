public class Passenger {
    private String name;
    private int funds = 500;
    private Ticket[] tickets = {};

    public Passenger(String name) {
        this.name = name;
    }

    public void buyTicket(Airliner airline, Ticket ticket) {
        if (this.funds < ticket.getPrice()) {
            System.out.println(this.name + ", you do not have enough funds to purchase ticket #" + ticket.getId()
                    + " to " + ticket.getDest() + "\n");
            System.out.print(
                    "To continue, please enter (Q) to quit, (D) to display all available flights, (L) to display all your tickets: ");

            return;
        }

        airline.sellTicket(ticket);

        this.pay(ticket.getPrice());
        this.addTicket(ticket);

        System.out.println(this.name + ", you have purchased ticket #" + ticket.getId() + " to " + ticket.getDest()
                + ". Your funds is now at $" + this.funds + ".\n");
        System.out.print(
                "To continue, please enter (Q) to quit, (D) to display all available flights, (L) to display all your tickets: ");

    }

    public void displayTickets() {
        if (this.tickets.length == 0) {
            System.out.println(this.name + ", you currently have no tickets purchased. \n");
        } else {
            System.out.println(this.name + ", all your tickets are displayed below: \n");

            String formatter = "| %-6s | %-24s | %-11s | %-14s | %-11s | %-24s |%n";

            System.out.format(
                    "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");
            System.out.format(
                    "| ID     | Destination              | Price       | Class          | Seat        | Departure Time           |%n");
            System.out.format(
                    "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");

            for (Ticket ticket : this.tickets) {
                System.out.format(formatter, ticket.getId(), ticket.getDest(), "$" + ticket.getPrice(),
                        ticket.getTicketClass(), ticket.getSeat(), ticket.getDeptTime());
                System.out.format(
                        "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");
            }
        }

        System.out.println();
        System.out.print(
                "To continue, please enter (Q) to quit, (D) to display all available flights, (L) to display all your tickets: ");

    }
    
    public String getName() {
        return this.name;
    }

    public void pay(int amount) {
        this.funds -= amount;
    }

    public void addFunds(int amount) {
        this.funds += amount;
    }

    public int getFunds() {
        return this.funds;
    }

    public void addTicket(Ticket ticket) {
        this.tickets = Utility.addTicket(this.tickets, ticket);
    }
}
