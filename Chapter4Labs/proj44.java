/*
* Run the Factorial program of Section 4.5 with inputs of 5, 10, and 20. Notice that the number for the last output is large but negative.
* Place an output statement in the loop so that you can view the value of count and number on each pass. Can you explain what the problem is?
* Now change they type of product from int to long, recompile the program, and run it again with the same inputs. Explain what happens. How
* large does the input have to be before you encounter the same problem again.
*/
//Should be done
import java.util.*;

public class proj44{
   public static void main(String[] arg){
   Scanner input = new Scanner(System.in); //Code below is from the book p.119
      System.out.println("Enter a number greater than 0; ");
      int num = input.nextInt();
      int product = 1;
      int count = 1;
      while (count <= num){
		  product = product * count;
		  System.out.println(product); //Program is fine, but can't find solution to explain what is going on.
		  count++;
		  System.out.println("Count: " + count + " Number: " + num);
		  System.out.println("--------------------------------------");
	  }
      System.out.println("The factorial of " + num + " is " + product); //use inputs 5, 10, 20 First
   }
}

