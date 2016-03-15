package proj123;

import java.util.Scanner;

public class commas {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a large number:");
		int num = input.nextInt();
		String formatted = commas(num);
		System.out.println("Your formatted number is " + formatted);
	}

public static String commas(long num){
	String formnum = new String("" + num);
	if(num/1000==0)
		return formnum;
	else{
		return commas(num/1000) + "," + formnum.substring(formnum.length() - 3);
	}
	//how to separate the parts of number??
	//solved.
	}
}
