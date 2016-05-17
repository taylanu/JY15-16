import java.util.Scanner;
//Exercise: complete this as a working program with all methods and error checking defined, and test it.

public class NinthProgram            //assume import statements are added above
{
    public static void showMenu()        //this method only shows options on the screen
    {                        //so it does not need arguments or return a value
        System.out.println("type 1 to find the area of a right triangle");
      /*   //TO BE COMPLETED LATER
      System.out.println("type 2 to find the perimeter of a right triangle");
      System.out.println("type 3 to find the area of a rectangle");
      System.out.println("type 4 to find the perimeter of a rectangle");
      */
    }

    public static double findTriangleArea(double base, double height) {                        //this method finds the area of a right triangle
        return 0.5 * base * height;            //so it needs information to do its job (parameters)
    }                        //and returns a value as a number with a decimal

    //assume similar methods called findTrianlgePerim, findRectangleArea and others are defined here
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        double base, height, ans = 0;
        int option;
        System.out.println("Enter the base:");
        base = input.nextDouble();            //assume error checking is done for the base here
        System.out.println("Enter the height:");
        height = input.nextDouble();        //assume similar error checking is done for the height
        showMenu();                //calls the showMenu method defined above
        option = input.nextInt();            //assume error checking is done for the option here
        if (option == 1)
            ans = findTriangleArea(base, height);    //calls the methods defined above, and the returned
      /*   //TO BE COMPLETED LATER   
      else if(option == 2)			//value is stored in the variable ans.
         ans = findTrianglePerim(base, height);
      else if(option == 3)
         ans = findRectangleArea(base, height);
      else if(option == 4)
         ans = findRectanglePerim(base, height);
      */
        System.out.println("The solution you seek is: " + ans);
    }
}
