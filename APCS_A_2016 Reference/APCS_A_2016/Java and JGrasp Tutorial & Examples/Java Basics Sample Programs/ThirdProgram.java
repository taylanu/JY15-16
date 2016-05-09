import java.util.*;	//the import statement makes useful tools available for your program
import java.io.*;
public class ThirdProgram
{
   public static void main(String [] arg)
   {
      Scanner input = new Scanner(System.in);	//used to get input from the keyboard
      double x, y, ans;				//3 primitive variables of type double (real #)
      System.out.println("Enter a number");		
      x = input.nextDouble();				//waits for input and stores it in x
      System.out.println("Enter another number");		
      y = input.nextDouble();				//waits for input and stores it in y
      ans = x * y;
      System.out.println(x + " times " + y + " is " + ans);
   }
}