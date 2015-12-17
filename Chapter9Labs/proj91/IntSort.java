import java.util.*;
import java.io.*;

public class IntSort{
	
   public static void main(String arg[]){
      int[] evenList = new int[10];
      int[] oddList = new int[10];
      int[] negList = new int[10];
      Scanner input = new Scanner(System.in);
      int evenCount = 0, oddCount = 0, negCount = 0;
      for(int i = 0; i < 10; i++){
         System.out.println("Enter an integer.");
         int num = input.nextInt();
         if(num < 0){
            negList[negCount] = num;
            negCount++;
         }
         else if(num % 2 == 0){
            evenList[evenCount] = num;
            evenCount++;
         }
         else{
            oddList[oddCount] = num;
            oddCount++;
         }
      }
      
      System.out.println("Your Even Array:");
      arrayPrint(evenList, evenCount);
      System.out.println("Your Odd Array:");
      arrayPrint(oddList, oddCount);
      System.out.println("Your Negative Array:");
      arrayPrint(negList, negCount);
   }
   public static void arrayPrint(int[] list, int size){
      if(size == 0){
         System.out.println("Empty");
      }
      else{
         String str = "[" + list[0];
         for(int i = 1; i < size; i++){
            str = str + ", " + list[i];
         }
         System.out.println(str + "]"); 
      }
   }
}
