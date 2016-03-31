import java.util.*;
import java.io.*;

public class TableModeMedian
{

   public static double findMed(int[] medList)
   {
      Arrays.sort(medList);
      double median;
      if (medList.length % 2 == 0)
      {
         int upBound = medList.length / 2;
         int lowBound = upBound - 1;
         median = (medList[upBound] + medList[lowBound])/ 2.0;
      }
      else
      {
         int midVal = (medList.length/2);
         median = medList[midVal];
      }
      return median;
   }

   public static int[] findModes(int[] modeList)
   {
      int [] data = new int[10];
      int [] answers= new int[modeList.length];
      int [] freq = findFrequencies(data);
      int max = findMax(freq);
      int [] modes = new int[modeList.length];
      int index = 0;
      for(int i=0; i<freq.length; i++){
         if(freq[i] == max){
            modes[index] = data[i];
            index++;
         }
      }
      return answers;
   }
   public static void fill(int [] nums)
   {
      Scanner input = new Scanner(System.in);
      for(int i=0; i < nums.length; i++)
      {
         System.out.println("Enter a number");
         nums[i] = input.nextInt();
      }
   }
   public static void show(int [] nums){
      for(int i=0; i < nums.length; i++)
         System.out.print(nums[i] + " ");
      System.out.println();
   }

   public static boolean search(int [] nums, int target)
   {
      for(int i=0; i < nums.length; i++)
         if(nums[i] == target)
            return true;
      return false;
   }
   public static int findMax(int[] list)
   {
      int max= list[0];
      for (int i=0;i<list.length;i++)
           if (list[i]>max)
               max = list[i];
      return max;
      }
   public static int countNum(int[] list,int val){
      int count = 0;
      for(int i=0;i<list.length;i++)
         if(list[i]==val)
            count++;
      return count;
   }
   public static int[] findFrequencies(int[] data){
      int[] ans = new int[data.length];
      for(int i=0;i<ans.length;i++)
         ans[i]=countNum(list,val]);
      return ans;
   }
   public static void main(String arg[]){

      int[] list = new int[10];
      int[] modeList = new int[list.length];

      fill(list);

      int[] modes = findModes(modeList);
      double median = findMed(list);
      System.out.println("The mode for your set was ");
      show(modes);
      System.out.println("The median for your dataset was " + median);
   }
}//END ALL
