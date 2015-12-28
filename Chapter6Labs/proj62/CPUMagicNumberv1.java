import java.util.*;
import java.io.*;
import java.lang.*;

public class CPUMagicNumberv1{
 
   public static void main(String arg[]){
	   
      int umgn, cguess, att=0, min=1, max=100;//umgn=user's magic number guess=computer guess att= attempts
      Scanner input = new Scanner(System.in);
      
      System.out.println("Computer: Think of a number, any number, between 1 and 100, and I bet I'll find it.");
      System.out.println("Computer: Type in your number, but I'll only use it to check my final answers.");
      umgn = input.nextInt();
      double startTime = System.currentTimeMillis();
      checkBounds(umgn);
      
      cguess = (int)(Math.random() * 100) + 1;
      
      while(cguess != umgn){
		  
         if(cguess < umgn){
			System.out.println("My guess appears to be low.");
			cguess++;
			att++;
		}
         else if (cguess > umgn){
            System.out.println("My guess appears to be too high.");
            cguess--;
            att++;
		}
         else{
			 System.out.println("Got your Number!");
		 }
      }
      System.out.println("Your number is " + cguess);
      System.out.println("I found your number on my " + att + "th attempt.");
      double endTime = (System.currentTimeMillis() - startTime)/1000;
	  System.out.println("Your 'challenging' number only took me " + endTime + " seconds to find.");
	}
	
	public static void checkBounds(int umgn){
	if(umgn < 1 || umgn > 100){
      System.out.println("Make sure that your number is between 1 and 100.");
      System.exit(-1);
   }
   } 
}

