/*
 * Teacher in most school districts are paid on a schedule that provides a salary based on their number of years of teaching experience.
 * For example, a beginning teacher in the Benningham School District might be paid $20,000 for the first year. For each year of experience 
 * after this up to 10 years a 2 percent increase over the preceding value is received. Write a program that displays a salary schedule for
 * teachers in a school district. The inputs are the starting salary, the percentage increase, and the number of years in the schedule. 
 * Each row in the schedule should contain the year, number, and salary for that year.
*/
//COMPLETE
import java.util.*;
import java.io.*;

public class proj410{
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
