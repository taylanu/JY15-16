package proj112;

import java.util.Scanner;
import java.io.*;

public class intArraySort {
    static int[] unsort = new int[10];
    static int[] sort = new int[unsort.length];
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Number Sorter v0.01");
		System.out.println("Please enter 10 integers.");
		
		for(int i=0;i<unsort.length;i++){
			unsort[i]=input.nextInt();
		}
		
        	System.out.println("Your array before it was sorted:" + "\n");
        	System.out.println(unsort.list());
        	System.out.println("Your array after it was sorted:" + "\n");
	}

}
