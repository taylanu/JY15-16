public abstract class Ticket {
    private static int nextSerialNumber = 0;
    private int serialNumber;

    public Ticket() {
        serialNumber = getNextSerialNumber();
    }

    // returns a new unique serial number
    private static int getNextSerialNumber() {
        return nextSerialNumber++;
    }

    // returns the price for this ticket
    public abstract double getPrice();

    // returns a string with information about the ticket
    public String toString() {
        return "Number: " + serialNumber + "\nPrice: " + getPrice();
    }
}
