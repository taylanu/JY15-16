import java.util.*;
import java.io.*;
public class FifthProgram
{
   public static void main(String [] arg)
   {	//1 - define any needed variables
      Scanner input = new Scanner(System.in);	
      double temp;			
   
   //2 - ask for the input and read it in
      System.out.println("Enter the temperature in Fahrenheit");		
      temp = input.nextDouble();		
   
   //3 - find the answer (and in this case, that includes showing it at the same time)
      if(temp >= 90)		
         System.out.println("Dress light - it is hot");
      else
         if(temp >= 70)
            System.out.println("Dress light - it is warm");
         else    
            if(temp >= 50)			
               System.out.println("Dress regular");
            else
               System.out.println("Dress in layers - it is cold");
   }
}
