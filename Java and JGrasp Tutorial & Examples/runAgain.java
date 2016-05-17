import java.io.IOException;
import java.util.Scanner;

//examples of input with error checking, process and output with a run again option
public class runAgain {
    public static void main(String argv[]) throws IOException {
        //declare variables
        String word = "y";    //input read from the keyboard for run again
        double num;            //input from user will store a real number (decimals)
        double ans;           //output variable
        Scanner input = new Scanner(System.in);
        while (word.equals("y") || word.equals("Y"))    //loop to run again if requested
        {                                                //input with error checking
            System.out.println("Enter a real # between 0 and 1.0");
            num = input.nextDouble();
            while (num < 0 || num > 1.0) {
                System.out.println("That number is invalid");
                System.out.println("Enter a real # between 0 and 1.0");
                num = input.nextDouble();
            }
            ans = num * 100;                                        //process
            //output
            System.out.println(num + " is " + ans + "%");

            System.out.println("Run again? (y/n)");
            word = input.nextLine();
        }
    }
}