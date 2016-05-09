   import java.io.*;
   import java.util.*;
   import java.util.Random;
    public class randomTest
   {
   
   /*
   	class java.util.Random
   	int nextInt(int n) 	// returns an integer in the range from 0 to n-1 inclusive 
   	double nextDouble() 	// returns a double in the range [0.0, 1.0) 
   */
   
       public static void main(String argv[]) throws IOException
      {
         Scanner input = new Scanner(System.in);
         Random x = new Random();
         int min, max;
         System.out.println("Here is a random int from 0 and 9: " + x.nextInt(10));
         System.out.println("Here is a random int from 5 and 14: " + (x.nextInt(10) + 5));
         System.out.println("pick a minimum value:");
         min=input.nextInt();
         System.out.println("pick a maxmum value:");
         max=input.nextInt();
         System.out.print("Here is a random int from " + min + " and "+ max + ": ");
         System.out.println((x.nextInt(max-min+1) + min));
         System.out.println("Here is a random double in the range [0.0,1.0): " + x.nextDouble());
      }
   }
