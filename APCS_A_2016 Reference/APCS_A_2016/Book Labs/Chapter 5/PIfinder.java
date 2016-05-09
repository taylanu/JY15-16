public class PIfinder							//computes PI by picking random numbers - computes 5 million points a second
{
   public static void main(String[]arg)
   {
      double totalPoints = 0;					//total # points picked
      double inCircle = 0;						//# points that are in the quarter circle
      double pi;									//current approximation of PI
      while(true)									//an infinite loop
      {
         if(totalPoints < 0)					//stop if we get to overflow
            break;
         double x = Math.random();			//pick a random point between (0,0) and (1,1)
         double y = Math.random();
         if(((x*x) + (y*y)) <= 1)			//if the point is within the quarter circle, count it
            inCircle++;
         totalPoints++;							//count the total # of points
         pi = (inCircle/totalPoints)*4;	//the ratio of the points in the circle to the total points gives us PI
         if(totalPoints % 10000000 == 0)	//show the current approx of PI every 10 million computations
            System.out.println(totalPoints + " : " + pi);	//show total # computations and current approx of pi
         
      }
   }
}