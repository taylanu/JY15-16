import java.util.*;
import java.io.*;

public class GradeDriver{

   public static void main(String arg[]) throws IOException{

      int grade, sum = 0, num = 0, min = 100, max = 0;
      double avg;
      String letter, avgL;
      Scanner input;
      input = new Scanner(new File("gradelist.txt"));

      while(input.hasNext()){
         grade = input.nextInt();
         letter = LGrade(grade);
         num++;
         sum+= grade;
         if(grade > max){
            max = grade;
         }
         if(grade < min){
            min = grade;
         }
      }
      avg = (double)(sum)/num;
      avgL = LGrade((int)(avg + 0.5)); // teacher rounds up grades

      System.out.println("The Class Average was: " + avg + ", or an " + avgL + "\nThe Lowest Grade in Class was: " + min + "\nThe Highest Grade in Class was: " + max + "\nNumber of Students that took the Test: " + num);
   }

   public static String LGrade(int grade){
      String letter;
      if(grade >= 96 && grade <= 100)
         letter = "A+";
      else if(grade >= 92 && grade <= 95)
         letter = "A";
      else if(grade >= 90 && grade <= 91)
         letter = "A-";
      else if(grade >= 86 && grade <= 89)
         letter = "B+";
      else if(grade >= 82 && grade <= 85)
         letter = "B";
      else if(grade >= 80 && grade <= 81)
         letter = "B-";
      else if(grade >= 76 && grade <= 79)
         letter = "C+";
      else if(grade >= 72 && grade <= 75)
         letter = "C";
      else if(grade >= 70 && grade <= 71)
         letter = "C-";
      else if(grade >= 66 && grade <= 69)
         letter = "D+";
      else if(grade >= 62 && grade <= 65)
         letter = "D";
      else if(grade >= 60 && grade <= 61)
         letter = "D-";
      else
         letter = "F";

      return letter;
}

}
