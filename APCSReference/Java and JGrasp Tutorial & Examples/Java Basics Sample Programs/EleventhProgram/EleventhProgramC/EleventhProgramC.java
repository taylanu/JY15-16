public class EleventhProgramC        //assume in the same folder as the new Car and RentalCar
{
    public static void main(String[] arg) {
        Car sedan = new Car("Town Car", 45000);
        RentalCar minivan = new RentalCar("Caravan", 38000, 42);

        if (sedan.compareTo(minivan) > 0)            //if sedan is greater than minivan
            System.out.println(sedan.getName() + " is more expensive than " + minivan.getName());
        else if (sedan.compareTo(minivan) < 0)        //if sedan is less than minivan
            System.out.println(minivan.getName() + " is more expensive than " + sedan.getName());
        else
            System.out.println(sedan.getName() + " and " + minivan.getName() + " are the same price");
    }
}