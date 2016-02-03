package WidgetLab;
import java.util.*;
import java.io.*;

public class Widget implements Comparable{
	   private int pounds;
	   private int ounces;
	   
	   public Widget()
	   {
	      pounds = 0;
	      ounces = 0;
	   }
	   
	   public Widget(int p, int o)
	   {
	      pounds = p; 
	      ounces = o;
	   }
	   
	   public int getPounds()
	   {
	      return pounds;
	   }
	   public int getOunces(){
		      return ounces;
	   }
	   public void setPounds(int p)
	   {
	      pounds = p;
	   }
	   public void setOunces(int o){
		      ounces = o;
	   }


	   public String toString(){
	      return "It weighs " + pounds +" lbs., and " + ounces + " oz.";
	   }
	  
	   public boolean equals(Widget w){
	      if(pounds == w.getPounds() && ounces == w.getOunces())
	         return true;
	      else
	         return false;
	   }
	
	   @Override
	public int compareTo(Object arg) {
		      Widget w = (Widget)arg;
		      if(this.equals(w))
		         return 0;
		      else if(pounds < w.getPounds())
		         return -1;
		      else if(pounds == w.getPounds() && ounces < w.getOunces())
		         return -1;
		      else if(pounds > w.getPounds())
		         return 1;
		      else
		         return 1;
		   }
	   //Operations
		   public void add(Widget w){
		      ounces += w.getOunces();
		      pounds += w.getPounds();
		      simplify();
		   }
		   public void subtract(Widget w){
		      ounces -= w.getOunces();
		      pounds -= w.getPounds();
		      simplify();
		   }
		   public void simplify(){
		      if(ounces >= 16){
		         pounds += (ounces / 16);
		         ounces %= 16;
		      }
		   }
		   //Operations
	}

/* 
 * ASSIGNMENT
 * Create a Widget class that implements Comparable.  
 * Put in constructors, accessors, modifiers, and any needed instance methods.
 * In the main() method, create an array of Widgets. Read the data, pounds on one line and ounces on the
 * next line, from widget.txt. For this assignment, just ignore the name field.  
 * Than call any of your sort(Comparable[]) methods, passing the Widget array.  
*/