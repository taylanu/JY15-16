import java.util.*;
import java.io.*;

public class MagicNumber
{
   public static void main(String arg[])
   {
      int mgn, guess, att=1;//mgn=magic number guess=user guess att= attempts
      Scanner input = new Scanner(System.in);

      mgn = (int)(Math.random() * 100) + 1; // randomizer
      System.out.println("The Magic Number is between 1 and 100! Take a Guess!");
      guess = input.nextInt();
      checkBounds(guess);

      while(guess != mgn){

         if(guess < mgn)
            System.out.println("Guess Higher. Take another shot at it!");
         else
            System.out.println("Guess Lower. Take another shot at it!");
         guess = input.nextInt();
         checkBounds(guess);
         att++;
      }

      System.out.println("It took you " + att + " attempts to find the magic number.");
   }

   public static void checkBounds(int mgn){

   if(mgn < 1 || mgn > 100){
      System.out.println("Make sure that your number is between 1 and 100.");
      System.exit(-1);
   }

   }
}
