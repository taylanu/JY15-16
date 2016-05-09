import java.util.*;
import java.io.*;
public class TenthProgramB			//assume needed import statements are included
{
    //pre:  name is formatted  <first-name last-name>
    //post: returns the name in the format <last-name, first-name>
   public static String formatName(String name)
   {
      int index = name.indexOf(" ");	          //search for position of the space within the name
      String first = name.substring(0, index);   //from the 1st character to the last one before the space
      String last = name.substring(index+1);    //from the character after the space all the way to the end
      return last + ", " + first;
   }

     //post:  fills array with user chosen names in the format <first-name last-name>
   public static void fillArray(String [] names)
   {
      Scanner input = new Scanner(System.in);
      for(int i=0; i<names.length; i++)		//note that this will work with an array of any size
      {
         System.out.println("Enter your first and last name separated by a space");		
         names[i] = input.nextLine();		
         while (names[i].indexOf(" ") == -1)	//can't find a space in the name, so error check
         {
            System.out.println("Invalid input - no space found:");
            System.out.println("Enter your first and last name separated by a space");		
            names[i] = input.nextLine();		
         }
      }
   }

     //post:  displays each element of array, one element per line
   public static void showArray(String [] array)
   {
      for(int i=0; i<array.length; i++)		//note that this method will work with an array of
         System.out.println(array[i]);		//any size, not just the one defined in the main function
   }

   public static void main(String [] arg)
   {		
      String [] names = new String[5];		//An array of five Strings.
      fillArray(names);			//Calls the method above to fill with user input.
      for(int i=0; i<names.length; i++)		//Traverse through each index of the names array and
         names[i] = formatName(names[i]);	//have each name change to its formatted version.
      showArray(names);			//Calls the method above to show all array elements.
   }
}
