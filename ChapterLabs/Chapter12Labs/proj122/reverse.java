package proj122;

import java.util.Scanner;

public class reverse {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a word:");
        String word = input.next();
        String ans = reverse(word);
        System.out.println("The reversed version of " + word + " is " + ans);
    }

    public static String reverse(String word) {
        if (word.length() == 1)
            return word;

        return word.charAt(word.length() - 1) + reverse(word.substring(0, word.length() - 1));
    }

}
