public class Passenger {
    private int funds = 5000;
    private Ticket[] tickets = {};

    /**
     * Purchases a ticket from the airline, removing the ticket from the airline and
     * add it to the passenger
     * 
     * Precondition - Passenger has enough funds
     * Postcondition - Ticket is added to the passenger
     * 
     * @param airline the airline where to purchase the ticket from
     * @param ticket  the ticket to purchase
     * @return void
     */
    public void buyTicket(Airliner airline, Ticket ticket) {
        Utility.clear();

        Airliner.incrementView();

        if (this.funds < ticket.getPrice()) {
            System.out.println("You do not have enough funds to purchase ticket #" + ticket.getId() + " to "
                    + ticket.getDest() + "\n");

            Utility.prompt();
            return;
        }

        airline.sellTicket(ticket);

        this.pay(ticket.getPrice());
        this.addTicket(ticket);

        System.out.println("You have purchased ticket #" + ticket.getId() + " to " + ticket.getDest()
                + ". Your funds is now at $" + this.funds + ".\n");

        Utility.prompt();
    }

    /**
     * Displays a list of tickets the passenger has purchased
     * 
     * @return void
     */
    public void displayTickets() {
        Utility.clear();

        if (this.tickets.length == 0) {
            System.out.println("You currently have no tickets purchased. \n");
        } else {
            System.out.println("All your tickets are displayed below: \n");

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

            System.out.println();
        }

        Utility.prompt();
    }
 
    /**
     * Displays the average, median, least, and most expensive of the tickets
     * purchased
     * 
     * @return void
     */
    public void getStats() {
        Utility.clear();

        if (this.getTickets().length == 0) {
            System.out.println("No statistics to show, you currently have no tickets purchased.\n");
    
            Utility.prompt();

            return;
        }

        double total = 0;
        double average = 0;
        int lowest = this.getTickets()[0].getPrice();
        int highest = this.getTickets()[0].getPrice();

        for (Ticket ticket : tickets) {
            total += ticket.getPrice();
        }

        average = total / tickets.length;

        for (int i = 0; i < this.getTickets().length; i++) {
            if (this.getTickets()[i].getPrice() < lowest) {
                lowest = this.getTickets()[i].getPrice();
            }

            if (this.getTickets()[i].getPrice() > highest) {
                highest = this.getTickets()[i].getPrice();
            }
        }

        System.out.println("You have visited EXOTIC AIRLINES " + Airliner.getViews() + " time(s).");
        System.out.println("The total cost of the tickets you purchased is $" + total);
        System.out.println("The average cost of the tickets you purchased is $" + average);
        System.out.println("The lowest cost of the ticket you purchased is $" + lowest);
        System.out.println("The highest cost of the ticket you purchased is $" + highest);

        Utility.prompt();
    }

    /**
     * Subtracts the cost of the ticket from the passenger's funds
     * 
     * @param amount the amount to subtract
     * @return void
     */
    private void pay(int amount) {
        this.funds -= amount;
    }

    /**
     * Gets the amount of funds available
     * 
     * @return the amount of funds left
     */
    public int getFunds() {
        return this.funds;
    }

    /**
     * Gets all the tickets the passenger purchased
     * 
     * @return the tickets the passenger purchased
     */
    public Ticket[] getTickets() {
        return this.tickets;
    }

    /**
     * Adds a ticket to the passenger
     * 
     * @param ticket the ticket to add
     * @return void
     */
    public void addTicket(Ticket ticket) {
        this.tickets = Utility.addTicket(this.tickets, ticket);
    }
}
