import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        // We should prompt for name
        Airliner airline = new Airliner(10, 2);
        Passenger passenger = new Passenger();

        // Extra array standards
        // Utility.extra();
        
        System.out.println(airline);
        Utility.prompt();

        boolean exited = false;

        while (!exited) {
            String input = scanner.next().toLowerCase();

            if (input.equals("s")) {
                passenger.getStats();
            } else if (input.equals("d")) {
                airline.displayFlights(scanner, passenger);
            } else if (input.equals("l")) {
                passenger.displayTickets();
            } else if (input.equals("q")) {
                Utility.clear();

                scanner.close();
                exited = true;

                System.out.println("Thank you for flying with EXOTIC AIRLINES, have a nice trip.");
                return;
            } else {
                Utility.clear();
                Utility.prompt();
            }
        }

        scanner.close();
    }
}
