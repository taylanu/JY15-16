import java.util.*;
import java.io.*;
public class FourthProgram
{
   public static void main(String [] arg)
   {	//1 - define any needed variables
      Scanner input = new Scanner(System.in);	
      double x1, y1, x2, y2, dist;			
   
   //2 - ask for the input and read it in
      System.out.println("Enter the first point x-coordinate");		
      x1 = input.nextDouble();		
      System.out.println("Enter the first point y-coordinate");		
      y1 = input.nextDouble();
      System.out.println("Enter the second point x-coordinate");		
      x2 = input.nextDouble();		
      System.out.println("Enter the second point y-coordinate");		
      y2 = input.nextDouble();
   
   //3 - find the answer
      dist = Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
   
   //4 - show the answer
      System.out.println("the distance is " + dist);
   }
}
