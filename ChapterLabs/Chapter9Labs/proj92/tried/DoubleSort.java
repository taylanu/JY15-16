import java.util.*;
import java.io.*;

public class DoubleSort{

   public static void main(String arg[]){
	         /*
      double[] avgList = new double[10];
      double[] greaterList = new double[10];

      Scanner input = new Scanner(System.in);
        int avgCount = 0, greaterCount = 0;
        double avg = 0, sum = 0, greaterVal=0;

      for(int i = 0; i < avgList.length; i++){
         System.out.println("Enter a double.");
         double num = input.nextDouble();
         if(num < 0){
            avgList[avgCount] = num;
            avgCount++;
		}
		for(int g = 0; g<greaterList.length;g++){
		 if(num>greaterVal){
			 greaterList[greaterCount]=num;
			 greaterCount++;
		}
	}
      	for(int j = 0; j<avgList.length;j++){
		sum = sum + avgList[avgCount];
		}
		avg = sum/avgList.length;

		System.out.println("Your average value = " + avg);
		arrayPrint(avgList, avgCount);
		System.out.println("Your values that were greater than average were= " + greaterVal);
		arrayPrint(greaterList, greaterCount);
	}
}
*/

   }
    public static void arrayPrint(double[] list, double size){
      if(size == 0){
         System.out.println("Your Array Is Empty");
      }
      else{
         String str = "[" + list[0];
         for(int l = 1; l < size; l++){
            str = str + ", " + list[l];
         }
         System.ou=t.println(str + "]");
      }
    }
}//CLOSER

        /*
      double[] avgList = new double[10];
      double[] greaterList = new double[10];

      Scanner input = new Scanner(System.in);
        int avgCount = 0, greaterCount = 0;
        double avg = 0, sum = 0, greaterVal=0;

      for(int i = 0; i < avgList.length; i++){
         System.out.println("Enter a double.");
         double num = input.nextDouble();
         if(num < 0){
            avgList[avgCount] = num;
            avgCount++;
		}
		for(int g = 0; g<greaterList.length;g++){
		 if(num>greaterVal){
			 greaterList[greaterCount]=num;
			 greaterCount++;
		}
	}
      	for(int j = 0; j<avgList.length;j++){
		sum = sum + avgList[avgCount];
		}
		avg = sum/avgList.length;

		System.out.println("Your average value = " + avg);
		arrayPrint(avgList, avgCount);
		System.out.println("Your values that were greater than average were= " + greaterVal);
		arrayPrint(greaterList, greaterCount);
	}
}
*/



