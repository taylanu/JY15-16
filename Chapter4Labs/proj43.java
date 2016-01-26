/*
A 2 minute telephone call to Lexington, VA, costs $1.15. Each additional minute costs $0.50. Write a program that takes the total
length of a call in minutes as input and calculates and displays the cost.
*/
import java.util.*;

public class proj43{
   public static void main(String[] arg){
   double length, costtot;
   Scanner input = new Scanner(System.in);
      System.out.println("How many minutes was your phone call?");
      length = input.nextDouble();
      costtot = (1.15 + (0.5 * (length - 2)));
   System.out.println("Your call will cost " + costtot);
   }
}