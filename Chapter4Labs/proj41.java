/*
when you first learned to divide, you expressed answers using a quotient and a remainder rather than a fraction
or decimal quotient. For example, if you divided 9 and 2, you gave the answer as 4r. 1. Write a program that takes
two integers as inputs and displays their quotient and remainder as outputs. Do not assume that the integers are
entered in any order, but be sure to divide the larger integer by the smaller integer.
*/
import java.util.*;

public class proj41{
   public static void main(String[] arg){
   int one, two, divd, rem;
   Scanner input = new Scanner(System.in);
      System.out.println("Enter the larger of your two integers");
      one = input.nextInt();
      System.out.println("Enter the smaller of your two integers");
      two = input.nextInt();
   divd = (one / two);
   rem = (one % two);
   System.out.println("Your quotient is " + divd);
   System.out.println("Your remainder is " + rem);
   }
}