import java.util.*;
public class BotDriver2			//in BotDriver2.java
{
   public static void main(String []  arg)	 	//in BotDriver2.java
   {
      Scanner input = new Scanner(System.in);
      Robot lisa = new Robot();		 
      String option = "";
      while(! option.equals("Q"))
      {
         System.out.println(lisa);
         System.out.println("M)ove, T)urn left, Q)uit");
         option = input.next();
         if(option.equals("M"))
            lisa.move();
         else if(option.equals("T"))
            lisa.turnLeft();
      }		 
   }
}