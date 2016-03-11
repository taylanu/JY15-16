/*
the German mathematician Gottfried Leibniz developed the following method to approximate the value of PI
PI/4 = 1 - 1/3 + 1/5 - 1/7 + .....
Write a program that allows the user to specify the number of iterations used in this approximation
and displays the resulting value.
*/
// COMPLETE
import java.util.*;

public class proj45{
   public static void main(String[] arg){
   double iter, sum, denom, ans, i;
   sum = 0;
   denom = 1;

   Scanner input = new Scanner(System.in);
      System.out.println("Enter the number of iterations you would like to use.");
      iter = input.nextDouble();
      for (i = 1; i <= iter; i++){
      if (i % 2 == 1){
		sum = sum + 1/denom;
	  }
	  else {
		sum = sum - 1/denom;
	  }
	  denom = denom + 2;
  }
	  System.out.println("The calculated value of Pi is " + sum * 4);
   }
}
