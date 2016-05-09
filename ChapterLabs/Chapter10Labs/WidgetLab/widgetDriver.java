package WidgetLab;
import java.util.*;
import java.io.*;
//Taylan Unal 1/20/16
/*
 * ASSIGNMENT
 * Create a Widget class that implements Comparable.
 * Put in constructors, accessors, modifiers, and any needed instance methods.
 * In the main() method, create an array of Widgets. Read the data, pounds on one line and ounces on the
 * next line, from widget.txt. For this assignment, just ignore the name field.
 * Than call any of your sort(Comparable[]) methods, passing the Widget array.
*/

public class widgetDriver{
	public static void main(String[] args) throws FileNotFoundException{

		@SuppressWarnings("resource")
		Scanner input = new Scanner(new File ("widget.txt"));
	      Widget[] list = new Widget[250];

	      for(int i = 0; i < list.length; i++){
	         int pounds = input.nextInt();
	         int ounces = input.nextInt();
	         list[i] = new Widget(pounds, ounces);
	      }

	      selSort(list);
	      for(int i = 0; i < list.length; i++)
	      {
	         System.out.println(list[i]);
	      }
	}

	public static void selSort(Comparable[] array){//Basic Selsort method using comparable objects.
	      for(int i=0; i<array.length; i++){
	         int min = i;
	         for(int j=i; j<array.length; j++)
	            if(array[j].compareTo(array[min]) < 0)
	               min = j;
	         swap(array, i, min);
	      }
	   }

	   public static void swap(Comparable[] array, int i, int min){//Basic Swap method using comparable objects.
	      Comparable c = array[i];
	      array[i] = array[min];
	      array[min] = c;
	   }
}