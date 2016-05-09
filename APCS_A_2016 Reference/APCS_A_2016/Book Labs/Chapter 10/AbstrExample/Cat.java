public class Cat extends Mammal
{
   private int numLives;

   public Cat(String hc)
   {
      super("Cat", hc);
      numLives = 9;
   }
   
   public String toString()
   {
      return super.toString() + " lives left:"+numLives;
   }
   
   public void move()
   {
      System.out.println("stalk, run, jump");
   }
}