import java.util.Scanner;

public class SixthProgram {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.println("Enter the number of stars you want");
        num = input.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
    }
}
