package superPrime;

import java.util.Scanner;

public class superPrime {
	
static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a positive number");
		int usernum = input.nextInt(); 
		if(sPrime(usernum)==false)
			System.out.print(usernum + " is not a SuperPrime");
		else
			System.out.print(usernum + " is a SuperPrime");
	}
	public static boolean sPrime(long num){
		if((num<10) && (isPrime(num)))
			return true;
		else if(isPrime(num))
			return sPrime(num/10);//div by 10, cuts off last digit
		else
			return false;
		}
	public static boolean isPrime(long n){
	    if(n==1)
	    	return false;//1 isnt technically a prime number
		for(int i=2;i<n/2;i++) {
	        if(n%i==0)
	             return false;
	    }
	    return true;
	}
}
