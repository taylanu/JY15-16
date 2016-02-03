package RaceHorseLab;

import java.util.*;

//GIDDY UP!
public class HorsesDriver{
	 public static void main(String arg[]){
			Scanner input = new Scanner(System.in);
		      int wIndex=-1;
		      System.out.println("The new Edition of Horse Race allows you to choose as MANY horses to race as you'd like.");
		      System.out.println("Remember:" + "\n" + "*Remember that your betting odd get worse with every additional horse :-D*");
		      System.out.println("How many horses would you like to race?");
		      int horseCount=input.nextInt();
		      Horse[] jockeys = new Horse[horseCount];
	
		for(int i = 0; i < jockeys.length; i++){
		   int run = (int)(Math.random() * 2);
		     if(run == 0)
		            jockeys[i] = new Horse(1, i);
		     else
		            jockeys[i] = new Philly(1, i);
		      }
		      
		      while(wIndex == -1)
		         wIndex = race(jockeys);
		      System.out.println("The Winner is Horse " + wIndex);
	}
	
	public static int race(Horse [] jockeys){
		System.out.println();
		int index= -1;
		for(int i = 0; i < jockeys.length; i++){
			   jockeys[i].raceStride();
		         System.out.println("\n" + jockeys[i]);
		         if(jockeys[i].getLocation() == 15)
		            index = i;
		}
		return index;
   }
}

/* 
h0 = new Horse(1,0);
h1 = new Horse(1, 1);
h2 = new Horse(1, 2);

str = race(h0, h1, h2);
System.out.println(str);*/ //Ineffective Code
/*
	System.out.println("\n\n\n" + h0 + "\n" + h1 + "\n" + h2);
 //Sets limit to horse's movement.
 while((h0.getLocation() != 15) && (h1.getLocation() != 15) && (h2.getLocation() != 15)){
    h0.raceStride();
    h1.raceStride();
    h2.raceStride();
    System.out.println("\n\n\n" + h0 + "\n" + h1 + "\n" + h2);
 }
 
 if((h0.getLocation()==15) && (h1.getLocation()==15) && (h2.getLocation()==15)){
    return "It's a threeway tie!";
 }
 
 else if((h0.getLocation()==15) && (h1.getLocation()==15) && (h2.getLocation()!=15)){
    return "Horse 0 and Horse 1 have tied!";
 }
 
 else if((h0.getLocation()==15) && (h1.getLocation()!=15) && (h2.getLocation()==15)){
    return "Horse 0 and Horse 2 have tied!";
 }
 
 else if((h0.getLocation()!=15) && (h1.getLocation()==15) && (h2.getLocation()==15)){
    return "Horse 1 and Horse 2 have tied!";
 }
 
 else if((h0.getLocation()==15) && (h1.getLocation()!=15) && (h2.getLocation()!=15)){
    return "Horse 0 has won!";
 }
 
 else if((h0.getLocation()!=15) && (h1.getLocation()==15) && (h2.getLocation()!=15)){
    return "Horse 1 has won!";
 }
 else{
    return "Horse 2 has won!";
 }
 */ //Ineffective Code