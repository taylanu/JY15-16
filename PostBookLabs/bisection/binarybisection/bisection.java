package binarybisection;

import java.util.*;
import java.math.*;

public class bisection {
//take two non-linear functions, f(x) and g(x) and find point (x,y) where they intersect.
	public static void bisection(){
		Scanner input = new Scanner(System.in);
		//double x^2 = 23;
		
		double tolerance;
		int maxIter = 100;//temporary
		System.out.println("What is the highest degree of your polynomial?");
		int highest_Deg = input.nextInt();
		System.out.println("Are there any sequential monomials that are missing from your equation?");
		String ans = input.next();
		if(ans.compareTo("y") == 0){ System.out.println("What degree(s) are you missing from your equation");
		int missing_Deg = input.nextInt();
		}
	}
}

//Example taken from http://www.coderanch.com/t/622930/java/java/bisection-method-java
/*
import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Bisect
{
    public static void main (String[] args)
    {
		print_header();

	double x, xnew;   // value of iterates
	double delta;     // amount added to get next iterate
	double error;     // error estimate
	double tol;       // tolerance (max error)
	int n, maxIts;    // iteration count and maximum number of iterates
	Scanner scan = new Scanner (System.in);


	// Get input
	System.out.println ("Bisection Method");
	System.out.print ("Initial value for x: ");
	x = scan.nextDouble();
	System.out.println();
	System.out.print ("Maximum number of iterations: ");
	maxIts = scan.nextInt();
	System.out.println ();
	System.out.print ("Tolerance: ");
	tol = scan.nextDouble();
	System.out.println();

	// Instantiate an object to format output to 6 decimal places
	double factor = 1e6; // = 1 * 10^6 = 100000.
	double result = Math.round(x * factor) / factor;
     int a=1;
     int b=3;
     int c=2;
     int exp_a=2;
     int exp_b=1;
     System.out.println("f(x) = ("+a+"x)^"+exp_a+" + ("+b+"x)^"+exp_b+" + ("+c+")");


	// Perform bisection method
	double a = 0, b = 2;
	n = 1;
	error = 100;
	double dx = b - a;
	    System.out.format ("%10s%10s%10s%10s%10s","n","xn+1","h(xn)","[f(xn)-g(x)]","h'(x)\n");
	while (n <= maxIts && error > tol)
	    {
			x = ((a + b) / 2);
			if ((f(a)*f(x)) < 0)
			 {
				 b = x;
				 dx = b - a;
	          }
	        else
	         {
				 a = x;
				 dx = b-a;


		System.out.format ("%10s%10s%10s%10s%10s\n",n, Math.round(xnew * factor) / factor, Math.round(h(x) * factor) / factor, Math.round(dx * factor) / factor ,Math.round(f(x) * factor) / factor ,Math.round(hprime(x) * factor) / factor);
		n++;


		}

    }

    // ***********************************
    // g(x)=x^3 - x^2 -4x - 1
    // ***********************************
    public static double g(double x)
     {
       return (-1 + x * (-4 + x * (-1 +x)));
     }
      // ***********************************
         // f(x)=x^3 - x +1
    // ***********************************
    public static double f(double x)
    {
	return ( 1 + x * (-1 + x * (0 + x)) );
    }
     // ***********************************
        // h(x)= f(x) - g(x)=x^2 + 3x +1
    // ***********************************
    public static double h(double x)
      {
		  return (2 + x * (3 + x * (0 + 1));
	  }

    // ********************
    // The derivative of h
    // ********************
    public static double hprime(double x)
    {
	return (3 + x * (2 + 0 * x));
    }
*/