import java.util.*;

public class GCD{
	
   public static void main(String arg[]){
      int n1, n2;
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your first number.");
      n1 = input.nextInt();
      System.out.println("Enter your second number.");
      n2 = input.nextInt();
      
      EucAlg(n1, n2);
   }
   
   public static void EucAlg(int n1, int n2){
      int bignum = Math.max(n1, n2);
      int smallnum = Math.min(n1, n2);
      
      while(smallnum != 0){
         int remainder = bignum % smallnum;
         System.out.println("The remainder of " + bignum + " and " + smallnum + " is " + remainder);
         bignum = smallnum; //Big has now become small
         smallnum = remainder; //Small has changed to become remainder
         //The two values have now shifted places with big->small; small-> remainder (loop)
      }
      System.out.println("The GCD of " + n1 + " and " + n2 + " is " + bignum);
   }
}
