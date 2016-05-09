import java.io.*;
import java.util.*;

public class EighthProgram			//assume import statements are added above
{
   public static void main(String [] arg)
   {
      Scanner input = new Scanner(System.in);	
      double x, ans;
      int  again = 1;
      while (again == 1)			//while the user wants to run the program again...
      {
         System.out.println("Enter a number to find the square root of:");		
         x = input.nextDouble();				
         while( x < 0)				//we will stay in the loop until the input is valid
         {
            System.out.println("Negative values are invalid.");
            System.out.println("Enter a number to find the square root of:");		
            x = input.nextDouble();
         }				
         ans = Math.sqrt(x);
         System.out.println("The square root of " + x + " is " + ans);
         System.out.println("Enter 1 to run again, or 0 to quit");
         again = input.nextInt();		//allow the user to quit the program
      }
   }
}
