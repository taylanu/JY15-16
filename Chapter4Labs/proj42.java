/*
Write a program that takes the lengths of three sides of a triangle as inputs. the program should display
whether or not the triangle is a right triangle.
*/
import java.util.*;

public class proj42{
   public static void main(String[] arg){
   double s1, s2, s3, ans;
   Scanner input = new Scanner(System.in);
      System.out.println("Enter the length of the first side of your triangle");
      s1 = input.nextInt();
      System.out.println("Enter the length of the second side of your triangle");
      s2 = input.nextInt();
      System.out.println("Enter the length of the third side of your triangle");
      s3 = input.nextInt();     
   if ((s1 * s1) + (s2 * s2) >= (s3 * s3)){
   System.out.println("You have a right triangle");}
   else {
   System.out.println("You do not have a right triangle");}
   }
}