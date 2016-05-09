public abstract class Mammal extends Animal
{
   private String hairColor;

   public Mammal (String n, String hc)
   {
      super(n);
      hairColor = hc;
   }

   public String toString()
   {
      return super.toString() + " color:" + hairColor; 
   }
   
   public void breed()
   {
      System.out.println("Live birth");
   }
}