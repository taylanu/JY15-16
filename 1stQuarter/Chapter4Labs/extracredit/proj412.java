/*
Modify the program of Project 4-11 so that it prompts the user for the number of rows and columns of
the board before displaying them. Use I/O dialog boxes to accept the inputs.
*/
//EXTRA CREDIT TO DO
import java.util.*;
import java.io.*;

public class proj412{
   public static void main(String[] arg){
   double yrexper,startsal,perinc;
   int yr = 1;
   Scanner input = new Scanner(System.in);
      System.out.println("What is your salary for your position?");
      startsal = input.nextInt();
      System.out.println("");
      System.out.println("What is your annual salary increase (in %)");
      perinc = input.nextInt();
      System.out.println("");
      perinc = perinc/100;
      System.out.println("How many years have you taught?");
      yrexper = input.nextInt();
      System.out.println("");
      System.out.println("Loading Salary Schedule..");
      System.out.println("");
			for(yr = 1;yr <= yrexper; yr++){
			double yrraise = (startsal * perinc);
			if (yr <= 10)
			     startsal += yrraise;
			yrraise = (startsal * perinc);
			System.out.println("Your salary will be $" + startsal + " after " + yr + " years");
		}
	}
   }
