import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Main entry of application
        initialize();
    }

    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        // Construct new objects
        Airliner airline = new Airliner(10, 2);
        Passenger passenger = new Passenger();

        // Extra array standards
        Utility.extra();
        
        // Greet user
        System.out.println(airline.toString());
        // Prompt the user
        Utility.prompt();

        boolean exited = false;

        while (!exited) {
            String input = scanner.next().toLowerCase();

            if (input.equals("s")) {
                // Displays user's statistics
                passenger.getStats();
            } else if (input.equals("d")) {
                // Displays the flights available to purchase
                airline.displayFlights(scanner, passenger);
            } else if (input.equals("l")) {
                // List the user's purchased tickets
                passenger.displayTickets();
            } else if (input.equals("q")) {
                // Exit the application
                Utility.clear();

                scanner.close();
                exited = true;

                System.out.println("Thank you for flying with EXOTIC AIRLINES, have a nice trip.");
                return;
            } else {
                // User enters an unknown option, we prompt them again
                Utility.clear();
                Utility.prompt();
            }
        }

        scanner.close();
    }
}
