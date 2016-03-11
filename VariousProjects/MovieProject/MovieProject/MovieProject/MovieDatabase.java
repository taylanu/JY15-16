import java.util.*;
import java.io.*;

public class MovieDatabase
{

   public static void main(String[] arg)throws IOException
   {
      Movie [] theater = readFromFile("movies.txt");
      Scanner input = new Scanner(System.in);
      int opt = 1;
      while(opt != 0)
      {
         System.out.println();
         System.out.println("0)  quit");
         System.out.println("1)  show all movies");
         System.out.println("2)  search by title");
         System.out.println("3)  list by rating");
         System.out.println("4)  list by decade");
         opt = input.nextInt();
         input.nextLine();
         if(opt==1)
            show(theater);
         else
            if(opt==2)
            {
               System.out.println("Enter search field:");
               String title = input.nextLine();
               searchByTitle(theater, title);
            }
            else
               if(opt==3)
               {
                  System.out.println("Enter rating (i.e. PG-13):");
                  String rating = input.nextLine();
                  searchByRating(theater, rating);
               }
               else
                  if(opt==4)
                  {
                     System.out.println("Enter decade (i.e. 1980):");
                     int year = input.nextInt();
                     searchByDecade(theater, year);
                     input.nextLine();
                  }
      }
   }

   public static void searchByTitle(Movie [] list, String target)
   {
      for(Movie x: list)
      {
         String title = x.getTitle().toLowerCase();
         if(title.indexOf(target.toLowerCase()) >= 0)
            System.out.println(x);
      }
   }

   public static void searchByRating(Movie [] list, String target)
   {
      for(Movie x: list)
      {
         String rating = x.getRating().toLowerCase();
         if(rating.equals(target.toLowerCase()))
            System.out.println(x);
      }
   }

   public static void searchByDecade(Movie [] list, int target)
   {
      for(Movie x: list)
      {
         int year = x.getYear();
         if((year/10) == (target/10))
            System.out.println(x);
      }
   }

   public static void show(Movie [] list)//PRINTER
   {
      for(Movie x: list)
         System.out.println(x);
   }

   public static Movie[] readFromFile(String fileName)throws IOException
   {
      Scanner input = new Scanner(new FileReader("movies.txt"));
      ArrayList<Movie> temp = new ArrayList();
      while(input.hasNextLine())
      {
         String title = input.nextLine();
         if(!input.hasNextLine())
            break;
         String rating = input.nextLine();
         if(!input.hasNextLine())
            break;
         String year = input.nextLine();
         temp.add(new Movie(title, rating, Integer.parseInt(year)));
      }
      Movie[] ans = new Movie[temp.size()];
      for(int i=0; i<ans.length; i++)
         ans[i] = temp.get(i);
      input.close();
      return ans;
   }
}
