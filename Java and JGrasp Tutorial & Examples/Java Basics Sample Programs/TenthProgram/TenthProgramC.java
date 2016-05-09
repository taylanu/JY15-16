import java.util.*;
import java.io.*;
public class TenthProgramC			//assume needed import statements are included
{
    //pre:  name is formatted  <first-name last-name>
    //post: returns the name in the format <last-name, first-name>
   public static String formatName(String name)
   {
      int index = name.indexOf(" ");	          //search for position of the space within the name
      String first = name.substring(0, index);   //from the 1st character to the last one before the space
      String last = name.substring(index+1);    //from the character after the space all the way to the end
      return last + "," + first;
   }

     //post:  fills names with user chosen names in the format <first-name last-name>
   public static void fillArray(ArrayList <String> names)
   {     
      Scanner input = new Scanner(System.in);	
      String temp = "";				//will store user input
      while (!temp.equals("0"))			//end adding names when user inputs "0"
      {
         System.out.println("Enter your first and last name separated by a space, or 0 to stop");		
         temp = input.nextLine();
         if(!temp.equals("0"))			//only proceed if user did not just type "0" to stop
         {		
            while (temp.indexOf(" ") == -1)	//can't find a space in the name, so error check
            {
               System.out.println("Invalid input - no space found:");
               System.out.println("Enter your first and last name separated by a space");		
               temp = input.nextLine();		
            }
            names.add(temp);			//add the name to the end of the ArrayList
         }
      }
   }

   public static void main(String [] arg)
   {	
      ArrayList <String> names = new ArrayList();
      fillArray(names);			//Calls the method above to fill with user input.
      for(int i=0; i<names.size(); i++)		
         names.set(i, formatName(names.get(i)));	
      System.out.println(names);		//shows all the elements of the ArrayList
   }
}
