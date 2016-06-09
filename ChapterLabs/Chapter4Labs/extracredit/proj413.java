/*
An interesting optical illusion is caused by a phenomenon known as induced contrast. This illusion occurs when two images of the same
shade are placed on backgrounds of sharply contrasting shades, as shown in Figure 4-7. One image appears darker than the other, even
though they are exactly the same shade. Write a graphics program that generates such an illusion. (Use two panels that draw the same shape.)
*/
//EXTRA CREDIT TO DO

import java.util.Scanner;

public class proj413 {
    public static void main(String[] arg) {
        double yrexper, startsal, perinc;
        int yr = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("What is your salary for your position?");
        startsal = input.nextInt();
        System.out.println("");
        System.out.println("What is your annual salary increase (in %)");
        perinc = input.nextInt();
        System.out.println("");
        perinc = perinc / 100;
        System.out.println("How many years have you taught?");
        yrexper = input.nextInt();
        System.out.println("");
        System.out.println("Loading Salary Schedule..");
        System.out.println("");
        for (yr = 1; yr <= yrexper; yr++) {
            double yrraise = (startsal * perinc);
            if (yr <= 10)
                startsal += yrraise;
            yrraise = (startsal * perinc);
            System.out.println("Your salary will be $" + startsal + " after " + yr + " years");
        }
    }
}
