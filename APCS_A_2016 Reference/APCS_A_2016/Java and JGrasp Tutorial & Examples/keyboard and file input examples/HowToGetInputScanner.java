   import java.io.*;				//lets us prepare for an IOException from getting input
   import java.util.*;
    public class HowToGetInputScanner
   {
      //Scanner input = new Scanner(System.in);
   	//this object lets us read in input from the keyboard or a file
          
   	//any method that gets input from a file or keyboard must throw an IOException
       public static void main(String argv[]) throws IOException	
      {
         String word;			//a collection of characters
         int num;						//a whole number
         double real;				//a number with a decimal
         Scanner input = new Scanner(System.in);
      	
      	//TO ENTER SEVERAL WORDS SEPARATED BY SPACES
         System.out.println("Enter a sentence");
         word = input.nextLine();							
         //waits for input and returns the sentence that was typed as a String
      
      	//TO READ AN INTEGER	
         System.out.println("Enter a whole number");
         num = input.nextInt();						
         //waits for input and returns what was typed as an int
      	
      	//TO READ A DOUBLE
         System.out.println("Enter a real number");
         real = input.nextDouble();					
         //waits for input and returns what was typed as a double
      	
         System.out.println(word + " " + num + " " + real);
      	//separate writing variables and text with the + operator
      	//anything within quotes is just writing text
      	//anything not in quotes must be a variable or object name   
      }
   }
