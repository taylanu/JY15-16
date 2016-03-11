// Regional National International Library of Tay
public class BookDriver
{
   public static void main(String arg[])

   {
      Patron dam, sam, ben;
      Book b1, b2, b3, b4, b5, b6, b7, b8, b9;

      b1 = new Book("Jane Eyre", "Charlotte Bronte");
      b2 = new Book("1984", "George Orwell");
      b3 = new Book("Blue Angels", "Harper Lee");
      b4 = new Book("Animal Farm", "George Orwell");
      b5 = new Book("Hamlet", "William Shakespeare");
      b6 = new Book("The Hobbit", "J.R.R. Tolkien");
      b7 = new Book("Fahrenheit 451", "Ray Bradbury");
      b8 = new Book("Les Miserables", "Victor Hugo");
      b9 = new Book("A Tale of Two Cities", "Charles Dickens");

      dam = new Patron("Damarius", b1);
      dam.borrow(b2);
      dam.turnIn("Blue Angels");
      dam.borrow(b3);

      sam = new Patron("Samuel", b4, b5, b7);
      sam.borrow(b6);
      sam.turnIn("Smooth Spark");
      sam.borrow(b6);

      ben = new Patron("Benny");
      ben.borrow(b7);
      ben.borrow(b8);
      ben.borrow(b9);

      System.out.println(dam + "\n\n" + sam + "\n\n" + ben);



   }
}
