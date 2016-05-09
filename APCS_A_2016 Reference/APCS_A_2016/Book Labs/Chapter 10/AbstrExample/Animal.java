public abstract class Animal
{
   private String name;

   public abstract void move();
   public abstract void breed();

   public Animal(String n)
   {
      name = n;
   }

   public String toString()
   {
      return name;
   }
}