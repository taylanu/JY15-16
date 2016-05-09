   import java.util.Arrays;

   public class Robot
   {
      private int[] hall;
      private int pos;
      private boolean facingRight;
   
      public Robot(int[] toys, int pos, boolean facingRight)
      {
         hall = new int[toys.length];
         for (int i = 0; i < toys.length; i++)
            hall[i] = toys[i];
         this.pos = pos;
         this.facingRight = facingRight;
      }
   
   // A-4, (a)
   
      public boolean forwardMoveBlocked()
      {
      
      }
   
   // A-4, (b)
   
      private void move()
      {
        
      }
   
   // A-4, (c)
   
      public int clearHall()
      {
       
      }
   
      private boolean hallIsClear()
      {
         int count = 0;
      
         for (int i = 0; i < hall.length; i++)
            count += hall[i];
      
         return count == 0;
      }
   
      public static void main(String[] args)
      {
         System.out.println("******* A-4 *******");
         Robot robot = new Robot(new int[] {1,1,2,2}, 1, true);
         System.out.println(robot.clearHall());
      }
   }


