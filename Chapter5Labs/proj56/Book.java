// Regional National International Library of Tay
public class Book
{
   private String title, author;
   //The Book
   public Book()
   {
      title = "no title";
      author = "no author";
   }
   public Book(String t, String a)
   {
      title = t;
      author = a;
   }

   // The Retrievers
   public String getTitle()
   {
      return title;
   }

   public String getAuthor()
   {
      return author;
   }
   //Returner
   @Override
public String toString()
   {
      return (title + " by " + author);
   }
}
