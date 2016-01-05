/*
computers use the binary system, which is based on powers of 2. Write a program that dispays the positive powers of 2.
When the user enters the exponent at a prompt, the program displays 2 to that power. The program halts when the user enters -1.
*/
//COMPLETE
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class proj47{
   public static void main(String[] arg){
   int exp;
   System.out.println("Give me an integer of your choosing");
   Scanner input = new Scanner(System.in);
   exp = input.nextInt();
   if (exp >= 0) {
	   System.out.println(int(Math.pow(2,exp)));
   }
   else {
	   System.out.println("Invalid Input");
}
}
}
