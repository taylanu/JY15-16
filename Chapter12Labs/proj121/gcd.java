package proj121;

import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first integer");
		int firstInt = input.nextInt();
		System.out.println("Enter your first integer");
		int secondInt = input.nextInt();
		int ans = gcd(firstInt,secondInt);
		System.out.println("The GCD of your two values is " + ans);
	}

	public static int gcd(int a, int b){
		if(b==0)
			return a;
		return gcd(b, (a % b));
	}

}
