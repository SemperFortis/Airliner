public class Utility {
    /**
     * @param array the ticket array
     * @param ticket the ticket to add to the array
     * @return the new array of tickets
     */
    public static Ticket[] addTicket(Ticket[] array, Ticket ticket) {
        Ticket[] newArray = new Ticket[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = ticket;

        return newArray;
    }

    /**
     * @param array  the ticket array
     * @param ticket the ticket to remove from the array
     * @return the new array of tickets
     */
    public static Ticket[] removeTicket(Ticket[] array, Ticket ticket) {
        Ticket[] newArray = new Ticket[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i].getId() != ticket.getId()) {
                newArray[0] = array[i];
            }
        }

        return newArray;
    }
}
