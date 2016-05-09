/*
Modify program of Proj. 4-8 so that it processes a file of inputs. Each line of the file contains a base and an exponent.
The program should read the data from each line, compute the result and display each set of inputs and their result on an
output line in the terminal window.
*/
import java.util.*;
import java.io.*;

public class proj49{
   public static void main(String[] arg) throws IOException{
   int exp, base, ans;
   Scanner input = new Scanner(new FileReader("49dat.txt"));
  while(input.hasNextInt()){
	  base = input.nextInt();
	  exp = input.nextInt();
	  ans = (int)Math.pow(base,exp);
	  System.out.println("For a base of " + base + " and an exponent of " + exp + " your answer will be " + ans);
	}
}
}
