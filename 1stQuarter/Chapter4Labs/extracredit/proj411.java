/*
A checkerboard consists of an 8 by 8 grid of black and red squares in which no two squares of the same color are adjcent.
Write a graphics program that displays a checkerboard
*/
//EXTRA CREDIT TO DO
import java.util.*;
import java.io.*;

public class proj411{
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
