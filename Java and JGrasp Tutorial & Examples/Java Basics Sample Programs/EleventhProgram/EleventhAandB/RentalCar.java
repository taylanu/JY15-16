public class RentalCar extends Car	//a RentalCar now has all features and abilities of a Car
{
   private double pricePerDay;		//a new data field in addition to the ones inherited

   public RentalCar(String n, double p, double ppd)
   {
      super(n, p);			//calls the constructor for Car and sets the name and price
      pricePerDay = ppd;	//initializes our extra data field
   }

   public String toString()		//override the toString that is inherited with a new version
   {
      return super.toString()+ "     RENTAL FEE: $" + pricePerDay;	
   }

   public double getPricePerDay()	//a new accessor method in addition to the ones inherited
   {
      return pricePerDay;
   }

   public void setPricePerDay(double ppd)
   {					//a new mutator method in addition to the ones inherited
      pricePerDay = ppd;
   }
}
