import java.util.*;
import java.io.*;

public class TableModeMedian{
	public static double findMed(int[] medList){
		Arrays.sort(medList);
		double median;
		
		if (medList.length % 2 == 0){
		 int upBound = medList.length / 2;
         int lowBound = upBound - 1;
         median = (medList[upBound] + medList[lowBound])/ 2;
		}
		else{
         int midVal = (medList.length/2);
         median = medList[midVal];
        }
		return median;
	}
	public static int findModes(int[] modeList){
      int max = modeList[0];
      int min = modeList[0];
      
      for(int i = 0; i <= 9; i++){
         if(modeList[i] < min)
            min = modeList[i];
         else if(modeList[i] > max)
            max = modeList[i];
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
         for(int j = 0; j < modeList.length; j++){
            if(modeList[j] == range[i])
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
      
      for(int i = 0; i < 10; i++){
         System.out.println("Enter a number");
         list[i] = input.nextInt();
      }
      
      int mode = findModes(modeList);
      double median = findMed(list);
		if(mode==0)
      System.out.println("Your dataset had no modes");
		else
	  System.out.println("The mode for your set was " + mode);
      
      System.out.println("The median for your dataset was " + median);
   }
}//END ALL
