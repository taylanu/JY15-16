import java.util.*;
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