package superPrime;

import java.util.Scanner;

public class superPrime {
	
static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a number");
		int usernum = input.nextInt(); 
		System.out.println(sPrime(usernum));
		
	}
	public static long sPrime(long num){
		if(num%num==0)
			return num;
		else
			return sPrime(num/10);
		//how to separate the parts of number??
		//solved.
		}
//div by 10, cuts off last digit
}
