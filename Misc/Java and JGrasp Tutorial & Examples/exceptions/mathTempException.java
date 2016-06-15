import java.io.IOException;
import java.util.Scanner;

//here's an example of asking for input with exception handling, doing some math and asking
//the user if they want to run the program again.
//d.oberle
public class mathTempException {

    public static void main(String argv[]) throws IOException {
        //declare variables
        String word = "y";                //input read from the keyboard for run again
        int num;                    //input stored as an int
        double ans;                    //output
        Scanner input = new Scanner(System.in);
        while (word.equals("y") || word.equals("Y"))    //loop to run again if requested
        {                        //input with exception handling
            try                        //here's what you do if input is ok
            {
                System.out.println("Enter a positive number");
                num = input.nextInt();
                if (num < 0)                //if input is bad, go to the catch block below
                    throw new Exception("Exception: Can't Square-Root a Negative!");
                ans = Math.sqrt(num);            //process
                System.out.println("The square root of " + num + " is " + ans);
            }                        //output
            catch (Exception e)            //here's what is done if input is bad (num<0)
            {
                System.out.println(e.getMessage());
                System.out.println("That number is invalid because it is negative");
            } finally                    //the finally block is optional and will run
            {                    //regardless of whether an exception was thrown or not
                System.out.println("Thanks for using my program");
            }
            System.out.println("Run again? (y/n)");
            word = input.next();
        }

    }
}