import java.util.Scanner;
import java.util.InputMismatchException;

public class Airliner {
    private Flight[] flights;
    private int ticketCount;
    private int earnings = 0;
    private Ticket[] soldTickets = {};

    public Airliner(int numberOfFlights, int ticketsPerFlight) {
        this.flights = new Flight[numberOfFlights];
        this.ticketCount = numberOfFlights * ticketsPerFlight;

        for (int i = 0; i < this.flights.length; i++) {
            this.flights[i] = new Flight(ticketsPerFlight);
        }
    }

    /**
     * Displays a list of flights for the passenger to choose from
     * 
     * @param scanner the scanner object for taking input options
     * @param passenger the current passenger purchasing a ticket
     * @return void
     */
    public void displayFlights(Scanner scanner, Passenger passenger) {
        String formatter = "| %-6s | %-24s | %-11s | %-14s | %-11s | %-24s |%n";

        System.out.format(
                "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");
        System.out.format(
                "| ID     | Destination              | Price       | Class          | Seat        | Departure Time           |%n");
        System.out.format(
                "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");

        for (Flight flight : this.flights) {
            for (Ticket ticket : flight.getTickets()) {
                System.out.format(formatter, ticket.getId(), ticket.getDest(), "$" + ticket.getPrice(),
                        ticket.getTicketClass(), ticket.getSeat(), ticket.getDeptTime());
                System.out.format(
                        "+--------+--------------------------+-------------+----------------+-------------+--------------------------+%n");
            }
        }

        System.out.print("\n\nWhich flight would you like to purchase a ticket for? (Enter ID): ");

        try {
            int selectedId = scanner.nextInt();

            Ticket selectedTicket = null;

            for (Ticket ticket : this.getTickets()) {
                if (ticket != null && ticket.getId() == selectedId) {
                    selectedTicket = ticket;
                }
            }

            this.sellTicket(selectedTicket);
            passenger.buyTicket(this, selectedTicket);
        } catch (NullPointerException e) {
            System.out.println(passenger.getName() + ", that is not a valid ticket!");
            System.out.print(
                    "\n\nTo continue, please enter (Q) to quit or (D) to display all available flights, (L) to display all your tickets: ");
        } catch (InputMismatchException e) {
            System.out.println(passenger.getName() + ", that is not a valid ID!");
            System.out.print(
                    "\n\nTo continue, please enter (Q) to quit or (D) to display all available flights, (L) to display all your tickets: ");
        }
    }

    /**
     * Removes a ticket from the airliner and adds it to the passenger bought tickets
     * 
     * @param ticket the ticket to sell
     * @return void
     */
    public void sellTicket(Ticket ticket) {
        this.earnings += ticket.getPrice();
        this.soldTickets = Utility.addTicket(this.soldTickets, ticket);

        for (int i = 0; i < this.flights.length; i++) {
            for (int j = 0; j < this.flights[i].getTickets().length; j++) {
                if (this.flights[i].getTickets()[j].getId() == ticket.getId()) {
                    this.flights[i].setTickets(Utility.removeTicket(this.flights[i].getTickets(), ticket));
                }
            }
        }
    }

    /**
     * Gets the amount of money made from selling tickets
     * 
     * @return amount of money
     */
    public int getEarnings() {
        return this.earnings;
    }

    /**
     * Gets all available tickets
     * 
     * @return array of tickets
     */
    public Ticket[] getTickets() {
        Ticket[] tickets = new Ticket[this.ticketCount];
        int counter = 0;

        for (int i = 0; i < this.flights.length; i++) {
            for (int j = 0; j < this.flights[i].getTickets().length; j++) {
                tickets[counter] = this.flights[i].getTickets()[j];
                counter++;
            }
        }

        return tickets;
    }
}
