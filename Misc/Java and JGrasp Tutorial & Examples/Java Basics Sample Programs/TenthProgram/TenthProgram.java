import java.util.Scanner;

public class TenthProgram {
    //pre:  name is in the format <first-name last-name>
    //post: returns the name in the format <last-name, first-name>
    public static String formatName(String name) {
        int index = name.indexOf(" ");        //search for position of the space within the name
        String first = name.substring(0, index);   //from the 1st character to the last one before the space
        String last = name.substring(index + 1);    //from the character after the space all the way to the end
        return last + ", " + first;
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        String name, ans;
        System.out.println("Enter your first and last name separated by a space");
        name = input.nextLine();
        while (name.indexOf(" ") == -1)    //can't find a space in the name, so error check
        {
            System.out.println("Invalid input - no space found:");
            System.out.println("Enter your first and last name separated by a space");
            name = input.nextLine();
        }
        ans = formatName(name);
        System.out.println(ans);        //shows the name in the format of <last-name, first-name>
    }
}
