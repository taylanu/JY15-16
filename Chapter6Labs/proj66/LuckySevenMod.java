import java.io.*;
import java.util.*;

public class LuckySevenMod
{
   public static void main(String arg[])
   {
      int initial, max$, roll, maxRoll, current$;
      double avgroll;
      Dice d1, d2;
      Scanner input;

      d1 = new Dice();
      d2 = new Dice();

      input = new Scanner(System.in);

      System.out.println("Enter your initial $: ");
      initial = input.nextInt();

      max$ = initial;
      current$ = initial;
      roll = 0;
      maxRoll = 0;

      //Rolls for 100 rolls
      for(int i = 1; i <= 100; i++){
      while(current$ > 0){
         roll++;
         d1.roll();
         d2.roll();

         if(d1.getNum() + d2.getNum() == 7){
            current$ = current$ + 4;
         }
         else{
            current$ = current$ - 1;
         }

      }
      current$ = initial;
      }
      avgroll = roll / 100.0;
      System.out.println("The average for your 100 rolls was " + avgroll);
   }
}
