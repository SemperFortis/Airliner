public class Utility {
    /**
     * Adds a ticket to the array
     * 
     * Precondition - tickets does not contain a null value
     * Poscondition - the length of the new array is one greater than the previous length
     * 
     * @param tickets the ticket array
     * @param ticket  the ticket to add to the array
     * @return the new array of tickets
     */
    public static Ticket[] addTicket(Ticket[] tickets, Ticket ticket) {
        Ticket[] array = new Ticket[tickets.length + 1];

        for (int i = 0; i < tickets.length; i++) {
            array[i] = tickets[i];
        }

        array[array.length - 1] = ticket;

        return array;
    }

    /**
     * Removes a ticket from the array
     * 
     * Precondition - tickets does not contain a null value
     * Postcondition - array does not contain a ticket with the supplied ticket id to remove
     * 
     * @param tickets the ticket array
     * @param ticket  the ticket to remove from the array
     * @return the new array of tickets
     */
    public static Ticket[] removeTicket(Ticket[] tickets, Ticket ticket) {
        Ticket[] array = new Ticket[tickets.length - 1];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() != ticket.getId()) {
                array[0] = tickets[i];
            }
        }

        return array;
    }

    /**
     * Computes the mode, shifts elements to the right, and reverses elements of an array
     * 
     * @return void
     */
    public static void extra() {
        int[] array = { 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 8, 9, 10 };

        // Shift right
        int i, temp;
        int[] copy = array;

        temp = copy[0];

        for (i = 0; i < copy.length - 1; i++) {
            copy[i] = copy[i + 1];
        }

        copy[i] = temp;

        System.out.print("Shifted: ");

        for (int x : copy) {
            System.out.print(Integer.valueOf(x) + " ");
        }

        System.out.println();

        // Mode
        int[] sorted = Utility.sort(array);
        int high = -1;
        int max = 0;
        int seen = 0;
        int current = array[0];

        for (int j = 0; j < sorted.length; j++) {
            int element = sorted[j];

            if (current == element) {
                seen++;
            } else {
                if (seen > max) {
                    max = seen;
                    high = current;
                }

                seen = 0;
                current = element;
            }
        }

        System.out.println("Mode: " + high);

        // Reverse
        int[] reversed = new int[array.length];
        int l = 0;

        for (int k = array.length - 1; k >= 0; k--) {
            reversed[l] = array[k];
            l++;
        }

        System.out.print("Reversed: ");

        for (int x : reversed) {
            System.out.print(Integer.valueOf(x) + " ");
        }
    }

    /**
     * Sorts an array in ascending order
     * 
     * @param array the array to sort
     * @return the sorted array
     */

    private static int[] sort(int[] array) {
        int[] copy = array;

        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[i] > copy[j]) {
                    int shallow = copy[i];

                    copy[i] = copy[j];
                    copy[j] = shallow;
                }
            }
        }

        return copy;
    }

    /**
     * Prompts the user for an option
     * 
     * @return void
     */
    public static void prompt() {
        System.out.println();
        System.out.print(
                "To continue, please enter (Q) to quit, (S) to display your statistics, (D) to display all available flights, or (L) to display all your tickets: ");

    }

    /**
     * Clears the console
     * 
     * @return void
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
