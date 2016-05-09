   import java.util.*;
   import java.io.*;

    public class Areafill_shell   
   {
       public static void main(String[] args) throws Exception
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("Filename: ");
         String filename = sc.next();
      
         Scanner infile = new Scanner(new File(filename)); int row = infile.nextInt();
         int col = infile.nextInt();
         char[][] grid = new char[row][col];
      
      
      
      
      
         infile.close();
         Displaygrid(grid);
      
      }
   
   
       public static void Displaygrid(char[][] grid)              
      {
      
      }
   }