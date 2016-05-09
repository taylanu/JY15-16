public class EleventhProgram	//assume this is in the same folder as Car.java
{
   public static void main(String [] arg)
   {	
   //create three instances of Car objects
      Car pickup = new Car("F150", 26000);	
      Car suv = new Car("CRV", 24000);
      Car coup = new Car("Civic", 18000);
   						//will output
      System.out.println("INVENTORY:");		//INVENTORY
      System.out.println(pickup);			//MODEL: F150    PRICE TAG: $26000
      System.out.println(suv);				//MODEL: CRV     PRICE TAG: $24000
      System.out.println(coup);			//MODEL: Civic    PRICE TAG: $18000
   
      System.out.println("All SUVs price drop 5%");	//All SUVs price drop 5%
      suv.setPrice(suv.getPrice() * 0.95);
      System.out.println(suv);				//MODEL: CRV     PRICE TAG: $22800
   }
}
