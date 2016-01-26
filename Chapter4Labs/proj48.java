/*
Modify the program of Project 4-7 so that the user can specify the base (2+) as well. The first line of the output should display
which base was entered.
*/
import java.util.*;

public class proj48{
   public static void main(String[] arg){
   double exp, base;
   Scanner input = new Scanner(System.in);
   System.out.println("Give me a base of your choosing.");
   base = input.nextDouble();
   System.out.println("Give me an number of your choosing.");
   exp = input.nextDouble();
  
   if (exp >= 0) {
	   System.out.println("Your base was " + base);
	   System.out.println("Your answer is " + (int)Math.pow(base,exp));
   }
   else {
	   System.out.println("Invalid Input");
}
}
}


