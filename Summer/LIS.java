
import java.util.*;
public class LIS {
   public static void main(String [] arg){
   /* 
   Taylan Unal
   AP CompSci Summer Project
   v0.1
   */
      System.out.println("How old are you?");
      Scanner input = new Scanner(System.in);
      int x, ans, compone;
      x = input.nextInt();
      ans = (x * 31556926);
      compone = Math.abs(ans / 60 / 130);
      System.out.println("You have lived for over " + ans + " seconds");
      System.out.println("That's enough time to watch " + compone + " Hollywood movies");
   }
}