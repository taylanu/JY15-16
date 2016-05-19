import java.util.Scanner;

public class SeventhProgram            //assume import statements are added above
{
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        double x, y, ans;
        int again = 1;
        while (again == 1)            //while the user wants to run the program again...
        {
            System.out.println("Enter a number");
            x = input.nextDouble();
            System.out.println("Enter another number");
            y = input.nextDouble();
            ans = x * y;
            System.out.println(x + " times " + y + " is " + ans);
            System.out.println("Enter 1 to run again, or 0 to quit");
            again = input.nextInt();        //allow the user to quit the program
        }
    }
}
