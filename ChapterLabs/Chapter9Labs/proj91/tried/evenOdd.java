import java.util.Scanner;

public class evenOdd {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type in 10 integers of your choosing, and my machine will classify it for you");
        int[] evenList = new int[10];
        int[] oddList = new int[10];
        int[] negList = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println("Please type in your " + i + " integer.");
            if (input.nextInt() < 0) {
                negList[i] = input.nextInt();
            } else if ((input.nextInt() % 2) == 0) {
                evenList[i] = input.nextInt();
            } else if ((input.nextInt() % 2) != 0) {
                oddList[i] = input.nextInt();
            } else {
                System.out.println("Your number is neither even, nor odd, negative, or even NATURAL");
            }
        }
    }
}

