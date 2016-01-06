/*
An employee's total weekly pay equals the hourly wage multiplies
by the total number of regular hours plus any overtime pay. Overtime
pay equals the total overtime hours multiplied by 1.5 times the hourly
wage. Write a program that takes as inputs the hourly wage, total regular
hours, and total overtime hours and displays an employee's total weekly pay.
*/

import java.util.*;

public class proj34 {
    public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    double hrly, rghrs, othrs, rgrate, otrate, wkpay;
        System.out.println("What is your hourly pay in $");
    hrly = reader.nextDouble();
        System.out.println("How many hours do you work a week?");
    rghrs = reader.nextDouble();
        System.out.println("How many overtime hours do you work a week?");
    othrs = reader.nextDouble();
    
    rgrate = (hrly * rghrs);
    otrate = (hrly * othrs * 1.5);
    wkpay = (rgrate + otrate);
        System.out.println("Your weekly pay is " + wkpay + " dollars");
    } 
}