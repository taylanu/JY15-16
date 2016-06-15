public class EleventhProgramB    //assume this is in the same folder as Car.java and RentalCar.java
{
    public static void main(String[] arg) {
        Car suv = new Car("CRV", 24000);
        RentalCar coup = new RentalCar("Civic", 18000, 24.5);
        //will output
        System.out.println(suv);        //MODEL: F150    PRICE TAG: $26000
        System.out.println(coup);    //MODEL: Civic    PRICE TAG: $18000    RENTAL FEE: $24.5

        System.out.println(suv.getPrice());        //will output 24000
   /*	System.out.println(suv.getPricePerDay());             WILL NOT COMPILE:  suv is not a RentalCar */
        System.out.println(coup.getPrice());        //will output 18000
        System.out.println(coup.getPricePerDay());    //will output 24.5
    }
}
