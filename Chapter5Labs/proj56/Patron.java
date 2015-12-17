// Regional National International Library of Tay
public class Patron
{
   private Book b1, b2, b3;
   private String name;
   private int numBooks = 0;
   
   public Patron()
   {
      name = "John Doe";
      b1 = new Book();
      b2 = new Book();
      b3 = new Book();
   }
   public Patron(String n)
   {
      name = n;
      b1 = new Book();
      b2 = new Book();
      b3 = new Book();
   }
   public Patron(String n, Book bo)
   {
      name = n;
      b1 = bo;
      b2 = new Book();
      b3 = new Book();
      numBooks = 1;
   }

   public Patron(String n, Book bo, Book bt)
   {
      name = n;
      b1 = bo;
      b2 = bt;
      b3 = new Book();
      numBooks = 2;
   }

   
   public Patron(String n, Book bo, Book bt, Book bth)
   {
      name = n;
      b1 = bo;
      b2 = bt;
      b3 = bth;
      numBooks = 3;
   }
   
   
   public void borrow(Book b) 
   {
      numBooks++;
      if(numBooks == 1)
      {
         b1 = b;
      }
      else if(numBooks == 2)
      {
         b2 = b;
      }
      else if(numBooks == 3)
      {
         b3 = b;
      }
      else
      {
         System.out.println("This patron already has 3 books.");
         numBooks = 3;
      }
   }
   
   public Boolean isItBorrowed(String t)
   {
      if((b1!= null &&  b1.getTitle().equals(t)) || (b2 != null && b2.getTitle().equals(t)) || (b3 != null && b3.getTitle().equals(t)== true))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public void turnIn(String t)
   {
      if(this.isItBorrowed(t)== true)
      {
         if(b1.getTitle().equals(t)== true)
            b1 = null;
         else if(b2.getTitle().equals(t)== true)
            b2 = null;
         else if(b3.getTitle().equals(t)== true)
            b3 = null;
         numBooks--;
      }
      else
         System.out.println("This person doesn't own that book.");
            
      
   }
   public String toString()
   {
      return ("Name: " + name + "\nBook 1: " + b1 + "\nBook 2: " + b2 + "\nBook 3: " + b3);
   
   }





}
