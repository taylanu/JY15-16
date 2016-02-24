package proj113;

import java.io.*;
import java.util.*;

public class wordSearch {

	public static void main(String[] args) throws FileNotFoundException{
System.out.println("Welcome to WordSearch v0.0.1");
FileReader read = new FileReader();
Scanner input = new Scanner(System.in);
System.out.println("Please enter the file that you would like to search through.");
    String fileName = input.nextLine();
    System.out.println("Enter the target word.");
    String target = input.nextLine();
	}
	
public static void findWord(String word, File file) throws FileNotFoundException{
	      Scanner search = new Scanner(file);
	      ArrayList<String> list = new ArrayList<String>();
	     
	      int count = 0;
	      int first = 0;
	      int num = 0;
	      
	      while(search.hasNext()){//makes sure file has another value to input
	         list.add(0, search.nextLine());
	         count++;
	      }
	      
	      for(int i = 0; i < count; i++){
	         if(word.equalsIgnoreCase(list.get(i))){
	            num++;
	            first = list.size() - i;
	         }  
	      }
	      
	      if(num == 0){
	         System.out.println("Your target word couldn't be found in the file.");
	      }
	      else{
	         System.out.println("Times Your Word Was Found: " + num + "\nIndex of First Instance of Your Word: " + first);
	      }
}
/* import java.util.*;
import java.io.*;
public class WordSearch
{
   public static void main(String[] arg) throws FileNotFoundException
   {
      Scanner input = new Scanner(System.in);
      String word;
      String fileName;
      File file;
      
      System.out.println("Enter the file you want to search in.");
      fileName = input.nextLine();
      System.out.println("Enter the target word.");
      word = input.nextLine();
      
      file = new File(fileName);
      findWord(word, file);
   }
   //pre: File should exist and be in the same folder as this class 
   //post:Finds the first instance of the target word and returns its index
   public static void findWord(String word, File file) throws FileNotFoundException
   {
   
      Scanner finder = new Scanner(file);
      ArrayList<String> list = new ArrayList<String>();
      int count = 0;
      int first = 0;
      int num = 0;
      while(finder.hasNext())
      {
         list.add(0, finder.nextLine());
         count++;
      }
      for(int i = 0; i < count; i++)
      {
         if(word.equalsIgnoreCase(list.get(i)))
         {
            num++;
            first = list.size() - i;
         }  
      }
      if(num == 0)
      {
         System.out.println("This word was not found in the file.");
      }
      else
      {
         System.out.println("Number of Times Word Found: " + num + "\nIndex of First Occurence: " + first);
      }
   }
}
*/


/* //Implemented from code created by http://www.roseindia.net/java/beginners/DirectoryListing.shtml 
//Just for style points if I can get it to work :)
	
private static void dirlist(String fname) {
		File dir = new File(fname);
	    String[] chld = dir.list();

	  if(chld == null){
		  System.out.println("Specified directory does not exist or is not a directory.");
		  System.exit(0);
	 }
	  else{
		  for(int i = 0; i < chld.length; i++){
			  String fileName = chld[i];
			  System.out.println(fileName);
	  }
	}
	
  }
}
*/

