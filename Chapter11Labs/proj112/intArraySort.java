package proj112;

import java.util.Scanner;
import java.io.*;

public class intArraySort {
    static int[] list = new int[10];
    
public static void swap(int[] list, int a, int b){
       int temp = list[a];
       list[a] = list[b];
       list[b] = temp;
}

public static void selSort(){
for(int i = 0; i < 10; i++){
    int min = i;
    for(int j = i; j < 10; j++){
       if(list[j] < list[min])
          min = j;
    }
    swap(list, i, min);
 }
}

public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Number Sorter v0.01");
		System.out.println("Please enter 10 integers.");
		
		for(int i=0;i<list.length;i++){
			list[i]=input.nextInt();
		}
        	System.out.println("Your array before it was sorted:");
        	
for(int i = 0; i < 10; i++){
               System.out.println(list[i]);
}

selSort();

        	System.out.println("Your array after it was sorted:");
for(int i = 0; i < 10; i++){
                System.out.println(list[i]);
}
        	
}

}
