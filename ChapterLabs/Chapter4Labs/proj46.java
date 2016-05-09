/*
read book. too long to type.
*/
//COMPLETED
import java.util.*;

public class proj46{
   public static void main(String[] arg){
   double rate, hrrate, hrsallot, start, diff, pop;
   Scanner input = new Scanner(System.in);
      System.out.println("Enter the number of organisms");
      start = input.nextDouble();
      System.out.println("Enter the rate of growth");
      rate = input.nextDouble();
      System.out.println("Enter hours to achieve rate of growth");
      hrrate = input.nextDouble();
      System.out.println("Enter allotted number of hours to allow population growth");
      hrsallot = input.nextDouble();
   pop = (start + ((start * rate) / hrrate) * hrsallot);
   diff = (pop - start);
   System.out.println("After " + hrsallot + " your population size will be about " + pop);
   System.out.println("That means your population grew by " + diff + " individuals");
   }
}
