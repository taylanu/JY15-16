/*
Modify the program of Project 3-4 so that it prompts the user for the
regular and overtime hours of each of the five working days.
*/

import java.util.Scanner;

public class proj34 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double hrly, rghrs, othrs, rgrate, otrate, wkpay, mnrghrs, tsrghrs, wdrghrs, thrghrs, frrghrs, mnothrs, tsothrs, wdothrs, thothrs, frothrs;
        System.out.println("What is your hourly pay in $");
        hrly = reader.nextDouble();
        System.out.println("How many hours do you work a week?");
        rghrs = reader.nextDouble();
        System.out.println("How many hours did you work on Monday?");
        mnrghrs = reader.nextDouble();
        System.out.println("How many hours did you work on Tuesday?");
        tsrghrs = reader.nextDouble();
        System.out.println("How many hours did you work on Wednesday?");
        wdrghrs = reader.nextDouble();
        System.out.println("How many hours did you work on Thursday?");
        thrghrs = reader.nextDouble();
        System.out.println("How many hours did you work on Friday?");
        frrghrs = reader.nextDouble();

        System.out.println("How many overtime hours do you work a week?");
        othrs = reader.nextDouble();
        System.out.println("How many overtime hours did you work on Monday?");
        mnothrs = reader.nextDouble();
        System.out.println("How many overtime hours did you work on Tuesday?");
        tsothrs = reader.nextDouble();
        System.out.println("How many overtime hours did you work on Wednesday?");
        wdothrs = reader.nextDouble();
        System.out.println("How many overtime hours did you work on Thursday?");
        thothrs = reader.nextDouble();
        System.out.println("How many overtime hours did you work on Friday?");
        frothrs = reader.nextDouble();

        rgrate = (hrly * rghrs);
        otrate = (hrly * othrs * 1.5);
        wkpay = (rgrate + otrate);
        System.out.println("Your weekly pay is " + wkpay + " dollars");
    }
}