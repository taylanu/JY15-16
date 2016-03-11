//Rev. Dr. Douglas R Oberle, Sept 2013
   import java.awt.event.KeyEvent;
   import java.util.ArrayList;
   import java.awt.Point;
   public class Player
   {
      private int dir;						//direction
      private ArrayList<Point> tail;	//position
      private String name;
      private int toGrow;					//count how many spaces we need to grow from eating a powerup
      private boolean wallBuster;		//do we have the wall buster powerup?
      private int score;
      private int numLives;
      private boolean dead;            //did we collide with something?

   //pre:   r and c >= 0, r < #board rows, c < #board columns, d is a keycode for a direction (arrow keys or WASD), name != null, startSize > 0
   //args:  start row, start col, start direction, player name, start size (# snake segments)
      public Player(int r, int c, int d, String n, int startSize)
      {
         name = n;
         resetPlayer(r, c, d, startSize);
         score = 0;
         numLives = 3;
         dead = false;
      }

   //pre:   r and c >= 0, r < #board rows, c < #board columns, d is a keycode for a direction (arrow keys or WASD), startSize > 0
   //args:  start row, start col, start direction, player name, start size (# snake segments)
      public void resetPlayer(int r, int c, int d, int startSize)
      {
         dir = d;
         tail = new ArrayList<Point>();
         tail.add(new Point(r,c));
         toGrow = startSize;
         wallBuster = false;
         dead = false;
      }

      @Override
	public boolean equals(Object other)
      {
         Player that = (Player)(other);
         return (this.getName().equals(that.getName()));
      }

      public boolean dead()
      {
         return dead;
      }

      public void setDead(boolean d)
      {
         dead = d;
      }

      public int getRow()
      {
         if(tail.size() > 0)
            return (int)(tail.get(0).getX());
         return -1;									//we have a problem if this is true
      }

      public int getCol()
      {
         if(tail.size() > 0)
            return (int)(tail.get(0).getY());
         return -1;									//we have a problem if this is true
      }

      public int getDir()
      {
         return dir;
      }

      public String getName()
      {
         return name;
      }

      public void setName(String n)
      {
         name = n;
      }

      public ArrayList<Point> getTail()
      {
         return tail;
      }

      public int getScore()
      {
         return score;
      }

      public int getLives()
      {
         return numLives;
      }

      public boolean isWallBuster()
      {
         return wallBuster;
      }

      @Override
	public String toString()
      {
         if(tail.size() > 0)
            return name + " is at " + (int)(tail.get(0).getX()) + ":" + (int)(tail.get(0).getY()) + " facing " + dir2direction(dir);
         return name + " is corupted and has no body";			//we have a problem if this is true

      }

   //pre:  k is either VK_UP, RIGHT, DOWN or LEFT or W, A, S, or D
      public void setDir(int k)
      {
         dir = k;
      }

      public void toggleWallBuster()
      {
         wallBuster = !wallBuster;
      }

      public void grow(int x)
      {
         toGrow = x;
      }

   //pre:   0 <= where < tail.size()
   //post:  after getting powerup, delete tail at index where
      public void cutTail(int where)
      {
         while(tail.size() > where && where>=0 && tail.size() > 0)
            tail.remove(tail.size()-1);
      }

      public void addScore(int s)
      {
         score += s;
      }

      public void changeLives(int x)
      {
         numLives += x;
         if(numLives < 0)
            numLives = 0;
      }

   //pre:  arguments are the number of rows/columns in the board array
   //      0 <= numRows, numCols < Integer.MAX_VALUE
   //post: moves the player's head depending on its direction, makes each tail segment follow the one in front of it
   //      grows the snake if it ate a growth pellet
      public void move(int numRows, int numCols)
      {
         int row = (int)(tail.get(0).getX());
         int col = (int)(tail.get(0).getY());
         if(toGrow > 0)										//grow the snake
         {
            toGrow--;
            if(tail.size() == 1)
               tail.add(new Point(row, col));
            else
               tail.add(1, new Point(row, col));
         }
         else
            for(int i=tail.size()-1; i >= 1; i--)	//make tail follow the segment in front of it
            {
               row = (int)(tail.get(i-1).getX());
               col = (int)(tail.get(i-1).getY());
               tail.set(i, new Point(row, col));
            }

      //************************FIX 2***********************************************/
      //this code changes the players position depending on the direction they picked on the keyboard
      //either row will change by 1 or col will change by 1 (up or down)
      //currently, a snake might travel off the board which will cause an exception (ArrayIndexOutOfBoundsException)
      //add code somewhere within this block to implement a wrap-around effect:
      //			a row of -1 (moving up from the top edge) needs to change to the last row (the bottom)
      //			a col of -1 (moving left from the left edge) needs to change to the last column (the right side)
      //			a row that is one larger than the last row (moving down from the bottom edge) needs to change to row 0 (the top)
      //			a col that is one larger than the last col (moving right from the right edge) needs to change to col 0 (the left)

      //**the first row is 0, the first col is 0**//
      //**the last row is (numRows-1), the last col is (numCols-1)**//
         if(dir==KeyEvent.VK_UP || dir==KeyEvent.VK_W)
         {
            row--;
            if (row == -1){
            row = numRows - 1;
            }
         }
         else
            if(dir==KeyEvent.VK_DOWN  || dir==KeyEvent.VK_S)
            {
               row++;
               if (row == numRows){
               row = 0;
            }
            }
            else
               if(dir==KeyEvent.VK_LEFT  || dir==KeyEvent.VK_A)
               {
                  col--;
                  if (col == -1){
                  col = numCols - 1;
            }
               }
               else
                  if(dir==KeyEvent.VK_RIGHT || dir==KeyEvent.VK_D)
                  {
                     col++;
                     if (col == numCols){
                     col = 0;
             }
                  }
       //***************************end FIX 2*******************************************/

         if(tail.size() > 0)
            tail.set(0, new Point(row, col));
      }

   //pre: k is a valid directional key code
   //post: returns the name of the direction given the key code (for debugging)
      private String dir2direction(int k)
      {
         if(k==KeyEvent.VK_UP || k==KeyEvent.VK_W)
            return "UP";
         if(k==KeyEvent.VK_DOWN  || k==KeyEvent.VK_S)
            return "DOWN";
         if(k==KeyEvent.VK_LEFT  || k==KeyEvent.VK_A)
            return "LEFT";
         if(k==KeyEvent.VK_RIGHT || k==KeyEvent.VK_D)
            return "DOWN";
         return "NONE";
      }
   }