public class Flight {
    private Ticket[] tickets;

    public Flight(int numberOfTickets) {
        this.tickets = new Ticket[numberOfTickets];

        for (int i = 0; i < this.tickets.length; i++) {
            String[] classes = { "First", "Business", "Economy" };
            int random = (int) (Math.random() * classes.length);
            int cost = (int) (Math.random() * 1000) + 1;

            this.tickets[i] = new Ticket(cost, "Some Great Destination", "12/15/2020 5:00 PM", "D2", classes[random]);
        }
    }

    /**
     * Sets the tickets available for the flight
     * 
     * @param tickets the tickets to add to the flight
     * @return void
     */
    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    /**
     * Gets all tickets for the flight
     * 
     * @return the amount of tickets this flight has
     */
    public Ticket[] getTickets() {
        return this.tickets;
    }
}
