import java.io.IOException;
import java.util.Scanner;

//here's an example of asking for input, error checking it, doing some math and asking
//the user if they want to run the program again.
//d.oberle
public class mathTempScanner {

    public static void main(String argv[]) throws IOException {
        //declare variables
        String word = "y";                        //input read from the keyboard for the run again option
        int num = 0;                                //input stored as an int (whole number)
        double ans;                                //the answer we will find can have a decimal
        Scanner input = new Scanner(System.in);

        while (word.equals("y") || word.equals("Y"))    //loop to run again if requested
        {                                                            //input with error checking
            System.out.println("Enter a positive number");
            num = input.nextInt();
            while (num < 0) {
                System.out.println("That number is invalid because it is negative");
                System.out.println("Enter a positive number");
                num = input.nextInt();
            }
            //process
            ans = Math.sqrt(num);
            //output
            System.out.println("The square root of " + num + " is " + ans);

            System.out.println("Run again? (y/n)");
            word = input.next();
        }

    }
}