package proj93;
import java.util.*;
import java.io.*;

public class ListMode{

	public static int findMode(int[] list){
      int max = list[0];
      int min = list[0];

      for(int i = 0; i <= 9; i++){
         if(list[i] < min)
            min = list[i];
         else if(list[i] > max)
            max = list[i];
      }

      int[] range = new int[max - min + 1];
      int[] occur = new int[max - min + 1];
      int mode = occur[0];
      int index = 0;

      for(int i = 0; i <= (max - min); i++){
         range[i] = min + i;
         occur[i] = 0;
      }

      for(int i = 0; i < (max - min + 1); i++){
         for(int j = 0; j < list.length; j++){
            if(list[j] == range[i])
               occur[i]++;
         }
      }

      for(int i = 0; i < max - min + 1; i++){
         if(occur[i] > mode){
            mode = occur[i];
            index = i;
         }
      }
    return range[index];
   }

   public static void main(String arg[]){

      int[] list = new int[10];
      int[] modeList = new int[list.length];
      Scanner input = new Scanner(System.in);

      for(int i = 0; i < list.length; i++){
         System.out.println("Enter a number");
         list[i] = input.nextInt();
      }

      int mode = findMode(list);

      System.out.println("The number that occurred most often in your set was " + mode);


   }
}
