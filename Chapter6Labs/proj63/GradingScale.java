import java.util.*;

public class GradingScale
{
   public static void main(String arg[])
   {
	  int grade;
      String letterG; // letter grade

	  Scanner input = new Scanner(System.in);

      System.out.println("What is your current grade in your class (from 0 to 100)");
      grade = input.nextInt();
      checkBounds(grade);
      letterG = findGrade(grade);
      System.out.println("You have an " + letterG + " in your class.");
   }
   public static void checkBounds(int num)
   {
      if(num < 0 || num > 100)
      {
         System.out.println("Please make sure that your grade is actually on the scale.");
         System.exit(-1);
      }
   }
   public static String findGrade(int grade)
   {
      if(grade >= 96 && grade <= 100)
         return "A+";
      if(grade >= 92 && grade <= 95)
         return "A";
      if(grade >= 90 && grade <= 91)
         return "A-";
      if(grade >= 86 && grade <= 89)
         return "B+";
      if(grade >= 82 && grade <= 85)
         return "B";
      if(grade >= 80 && grade <= 81)
         return "B-";
      if(grade >= 76 && grade <= 79)
         return "C+";
      if(grade >= 72 && grade <= 75)
         return "C";
      if(grade >= 70 && grade <= 71)
         return "C-";
      if(grade >= 66 && grade <= 69)
         return "D+";
      if(grade >= 62 && grade <= 65)
         return "D";
      if(grade >= 60 && grade <= 61)
         return "D-";
      else
         return "F";
   }


}
