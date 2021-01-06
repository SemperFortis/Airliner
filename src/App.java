import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        // We should prompt for name
        Airliner airline = new Airliner(10, 2);
        Passenger passenger = new Passenger("Jason");

        System.out.print(
                "Welcome to EXOTIC AIRLINES!\n\nTo continue, please enter (Q) to quit or (D) to display all available flights, (L) to display all your tickets: ");

        boolean exited = false;

        while (!exited) {
            String input = scanner.next().toLowerCase();

            if (input.equals("a")) {

            } else if (input.equals("d")) {
                // Display flights option
                airline.displayFlights(scanner, passenger);
            } else if (input.equals("l")) {
                // Display all the tickets the user has bought
                passenger.displayTickets();
            } else if (input.equals("q")) {
                // Exit
                scanner.close();
                exited = true;
                System.out.println("Thank you for flying with AIRLINE NAME, have a nice trip.");
                return;
            } else {
                // Handle unknown options
                System.out.println();
                System.out.print("\nUnknown option, enter (Q) to quit or (D) to display all available flights, (L) to display all your tickets: ");
            }
        }

        scanner.close();
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
