package proj123;

import java.util.Scanner;

public class commas {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a large number:");
		long num = input.nextLong();
		commas(num);
	}
	
public static void commas(long num){
	if(num%1000==0)
		System.out.println(num);
	//else
		//commas(num/1000);
	//how to separate the parts of number.
	}

}
