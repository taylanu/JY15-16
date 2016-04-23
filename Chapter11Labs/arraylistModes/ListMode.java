package arraylistModes;
import java.util.*;

public class ListMode{
	//ARRAYLIST VERSION OF THE MODES LAB.
public static void main(String arg[]){

		      Scanner input = new Scanner(System.in);
		      ArrayList<Integer> nums = new ArrayList<Integer>();
		      ArrayList<Integer> mode = new ArrayList<Integer>();
		      System.out.println("Welcome to ListMode v2.0.0! Now featuring efficient arrayLists!");
		      do{
		         System.out.println("Enter a number");
		         nums.add(0,input.nextInt());
		      }
		      while(input.hasNext());

		       mode = findMode(nums);

		      System.out.println("The number that occurred most often in your set was " + mode);
		   }
public static ArrayList<Integer> findMode(ArrayList <Integer> list){
      int max = list.get(0);
      int min = list.size();

      for(int i = 0; i <= 9; i++){
         if(list.get(i) < min)
            min = list.get(i);
         else if(list.get(i) > max)
            max = list.get(i);
      }

      ArrayList<Integer> range = new ArrayList<Integer>();
      ArrayList<Integer> occur = new ArrayList<Integer>();

      for(int i = max; i >= min; i--){//Go backwards, to go forwards. Protip from RevO
         range.add(0,i);
         occur.add(0,0);
      }

      for(int i = 0; i < (max - min + 1); i++){
         for(int j = 0; j < list.size(); j++){
            if(list.get(j) == range.get(i))
               occur.set(i, occur.get(i)+1);
         }
      }

     int mode = occur.get(0);
     for(int i = 0; i < max - min + 1; i++){
         if(occur.get(i) > mode)
            mode = occur.get(i);
      }
      ArrayList<Integer> modes = new ArrayList<Integer>();
      for(int i = 0; i < max - min + 1; i++){
         if(occur.get(i) == mode)
            modes.add(0, range.get(i));
      }
    return modes;
   }


}
