public class Car
{
     private String name;			//data fields
     private double price;

     public Car(String n, double p)		//METHOD: constructor
     {
          name = n;
          price = p;
     }

     public String toString()		//METHOD
     {
          return "MODEL:" + name + "     PRICE TAG: $" + price;
     }

     public String getName()		//METHOD: accessor
     {
          return name;
     }

     public double getPrice()		//METHOD: accessor
     {
          return price;
     }

     public void setPrice(double p)	//METHOD: mutator
     {
          price = p;
     }
}
