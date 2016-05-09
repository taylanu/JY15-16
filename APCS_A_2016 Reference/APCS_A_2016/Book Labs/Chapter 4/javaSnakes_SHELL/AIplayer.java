//Rev. Dr. Douglas R Oberle, Sept 2013
   import java.awt.event.KeyEvent;
   import java.awt.Point;
   import java.util.ArrayList;

   public class AIplayer extends Player
   {  
   //info about the game world that we need to know to make decisions on how to move
      private int pelletR, pelletC, powerupR, powerupC;  //location of powerups
      private int[][] board;                             //location of walls
      private Player p1;                                 //location of player 1
      private boolean favorsPowerups;                    //when seeking a pellet, do we favor powerups over growth
      private double unpredictability;                   //how often will we make random turns?
   //bot names are indexed such that the lower their alphabetic name, the less random movements they will make
      private static String[] mNames = {"Arthur", "Borris", "Charles", "Douglas", "Edward", "Franklin"};
   //male names are used for bots that favor powerups over pellets
      private static String[] fNames = {"Antigone", "Beatrice", "Catherine", "Doris", "Eunice", "Francis"};
   //female names favor pellets over powerups
      private static int numLefts, numRights;				//make sure we don't do 4 lefts or rights in a row
   
   //pre:  0 <= r < #board rows, 0 < = c < #board columns, d is a vaild keycode direction, startSize > 0
   //args: start row, start col, start direction, name, start size
      public AIplayer(int r, int c, int d, String n, int startSize)
      {
         super(r, c, d, n, startSize);
         pelletR = -1;
         pelletC = -1;
         powerupR = -1;
         powerupC = -1;
         board = null;
         p1 = null;
         favorsPowerups = false;
         if(Math.random() < .5)
            favorsPowerups = true;
         int personality = (int)(Math.random()*mNames.length);    //0-5 (used as index for name array)
         unpredictability =  personality*2 / 100.0;               //0-0.1 (used for Math.random - % chance they will make a random turn as a last priority)        
         if(favorsPowerups)
            setName(mNames[personality]);
         else
            setName(fNames[personality]);
         numLefts = 0;
         numRights = 0;   
      }
   
   //post: returns true if there is a clear path to a pellet or powerup to the right
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletToRight(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r == pR && c < pC)
         {
            for(int i=c; i<=pC && i<board[0].length; i++)
            {
               if(board[r][i] == 1 || SnakePanel.snakeAt(p1, r, i, false) || SnakePanel.snakeAt(this, r, i, true))
                  return false;
            }
            return true;
         }
         return false;
      }
   
   //post: returns true if there is a clear path to a pellet or powerup to the left
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletToLeft(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r == pR && c > pC)
         {
            for(int i=c; i>=pC && i >= 0; i--)
            {
               if(board[r][i] == 1 || SnakePanel.snakeAt(p1, r, i, false) || SnakePanel.snakeAt(this, r, i, true))
                  return false;
            }
            return true;
         }
         return false;
      }
   
   //post: returns true if there is a clear path to a pellet or powerup above the player
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletAbove(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(c == pC && r > pR)
         {
            for(int i=r; i>=pR && i >=0; i--)
            {
               if(board[i][c] == 1 || SnakePanel.snakeAt(p1, i, c, false) || SnakePanel.snakeAt(this, i, c, true))
                  return false;
            }
            return true;
         }
         return false;
      }
   
   //post: returns true if there is a clear path to a pellet or powerup below the player
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletBelow(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(c == pC && r < pR)
         {
            for(int i=r; i<=pR && i<board.length; i++)
            {
               if(board[i][c] == 1 || SnakePanel.snakeAt(p1, i, c, false) || SnakePanel.snakeAt(this, i, c, true))
                  return false;
            }
            return true;
         }
         return false;
      }
   
   //post: returns true if there is a pellet or powerup above-right
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletAboveRight(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r > pR && c < pC)
            return true;
         return false;
      }
   
    //post: returns true if there is a pellet or powerup above-left
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletAboveLeft(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r > pR && c > pC)
            return true;
         return false;
      }
   
   //post: returns true if there is a pellet or powerup below-right
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletBelowRight(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r < pR && c < pC)
            return true;
         return false;
      }
   
   //post: returns true if there is a pellet or powerup below-left
   //args:  if powerup is false, we are looking for a growth pellet.  if powerup is true, we are looking at a special powerup
      private boolean pelletBelowLeft(boolean powerup)
      {
         int r = this.getRow();
         int c = this.getCol();
         int pR = pelletR;
         int pC = pelletC;
         if(powerup)
         {
            pR = powerupR;
            pC = powerupC;
         }  
         if(r < pR && c > pC)
            return true;
         return false;
      }
   
   //post:  change the player's dir in order to avoid walls (priority 1) 
   //                                           get powerups (priority 2)
   //                                           turn to get powerups (priority 3)
   //                                           seek powerups (priority 4)
   //                                           make random turns (priority 5)
   //args:  the enemy player, the board, pellet row, pellet column, powerup row, powerup column
      public void AImove(Player p, int[][] b, int pR, int pC, int pwR, int pwC)
      {
         board = b;        //copy game board info into AI brain
         pelletR = pR;
         pelletC = pC;
         powerupR = pwR;
         powerupC = pwC;
         p1 = p;
      
         ArrayList<Point> tail = this.getTail();
         int dir = this.getDir();
         int row = (int)(tail.get(0).getX());
         int col = (int)(tail.get(0).getY());
      //*************avoid walls (priority 1)************************ 
         if(dir==KeyEvent.VK_UP && ((row > 0 && SnakePanel.blocked(row-1, col)) || (row==0 && SnakePanel.blocked(board.length-1, col))))
         {//moving up and front is blocked, try to move left or right
            if(Math.random() < .5)
            {
               if((col < board[0].length-1 && !SnakePanel.blocked(row, col+1)) || (col==board[0].length-1 && !SnakePanel.blocked(row, 0)))
                  dir = KeyEvent.VK_RIGHT;
               else
                  dir = KeyEvent.VK_LEFT;   
            }
            else
            {
               if((col > 0 && !SnakePanel.blocked(row, col-1)) || (col==0 && !SnakePanel.blocked(row, board[0].length-1)))
                  dir = KeyEvent.VK_LEFT;
               else
                  dir = KeyEvent.VK_RIGHT; 
            }
         }
         else if(dir==KeyEvent.VK_DOWN && ((row < board.length-1 && SnakePanel.blocked(row+1, col)) || (row==board.length-1 && SnakePanel.blocked(0, col))))
         {//moving down and front is blocked, try to move left or right
            if(Math.random() < .5)
            {
               if((col < board[0].length-1 && !SnakePanel.blocked(row, col+1)) || (col==board[0].length-1 && !SnakePanel.blocked(row, 0)))
                  dir = KeyEvent.VK_RIGHT;
               else
                  dir = KeyEvent.VK_LEFT;   
            }
            else
            {
               if((col > 0 && !SnakePanel.blocked(row, col-1)) || (col==0 && !SnakePanel.blocked(row, board[0].length-1)))
                  dir = KeyEvent.VK_LEFT;
               else
                  dir = KeyEvent.VK_RIGHT; 
            }
         }
         else if(dir==KeyEvent.VK_RIGHT && ((col < board[0].length-1 && SnakePanel.blocked(row, col+1)) || (col==board[0].length-1 && SnakePanel.blocked(row, 0))))
         {//moving right and front is blocked, try to move up or down
            if(Math.random() < .5)
            {
               if((row < board.length-1 && !SnakePanel.blocked(row+1, col)) || (row==board.length-1 && !SnakePanel.blocked(0, col)))
                  dir = KeyEvent.VK_DOWN;
               else
                  dir = KeyEvent.VK_UP;   
            }
            else
            {
               if((row > 0 && !SnakePanel.blocked(row-1, col)) || (row==0 && !SnakePanel.blocked(board.length-1, col)))
                  dir = KeyEvent.VK_UP;
               else
                  dir = KeyEvent.VK_DOWN;   
            
            }
         }
         else if(dir==KeyEvent.VK_LEFT && ((col > 0 && SnakePanel.blocked(row, col-1)) || (col==0 && SnakePanel.blocked(row, board[0].length-1))))
         {//moving left and front is blocked, try to move up or down
            if(Math.random() < .5)
            {
               if((row < board.length-1 && !SnakePanel.blocked(row+1, col)) || (row==board.length-1 && !SnakePanel.blocked(0, col)))
                  dir = KeyEvent.VK_DOWN;
               else
                  dir = KeyEvent.VK_UP; 
            }
            else
            {
               if((row > 0 && !SnakePanel.blocked(row-1, col)) || (row==0 && !SnakePanel.blocked(board.length-1, col)))
                  dir = KeyEvent.VK_UP;
               else
                  dir = KeyEvent.VK_DOWN;   
            }
         }
         //*******************get powerups (priority 2)*************************
         else if(dir==KeyEvent.VK_UP && (pelletAbove(true) || pelletAbove(false)))
         {}	//if we are in line to capture a pellet or powerup, stay the course
         else if(dir==KeyEvent.VK_DOWN && (pelletBelow(true) || pelletBelow(false)))
         {}
         else if(dir==KeyEvent.VK_LEFT && (pelletToLeft(true) || pelletToLeft(false)))
         {}
         else if(dir==KeyEvent.VK_RIGHT && (pelletToRight(true) || pelletToRight(false)))
         {}
         //*******************turn to get powerups (priority 3)******************
         else if((dir==KeyEvent.VK_UP || dir==KeyEvent.VK_DOWN) && (pelletToRight(false) || pelletToLeft(false)))
         {//if there is a grow pellet to our right and left, get it
            if(pelletToRight(false))
               dir = KeyEvent.VK_RIGHT;
            else if(pelletToLeft(false))
               dir = KeyEvent.VK_LEFT;   
         }
         else if((dir==KeyEvent.VK_LEFT || dir==KeyEvent.VK_RIGHT) && (pelletAbove(false) || pelletBelow(false)))
         {//if there is a pellet above or below us, get it
            if(pelletAbove(false))
               dir = KeyEvent.VK_UP;
            else if(pelletBelow(false))
               dir = KeyEvent.VK_DOWN;  
         }
         else if((dir==KeyEvent.VK_UP || dir==KeyEvent.VK_DOWN) && (pelletToRight(true) || pelletToLeft(true)))
         {	//if there is a powerup to either side, get it
            if(pelletToRight(true))
               dir = KeyEvent.VK_RIGHT;
            else if(pelletToLeft(true))
               dir = KeyEvent.VK_LEFT;   
         }
         else if((dir==KeyEvent.VK_LEFT || dir==KeyEvent.VK_RIGHT)  && (pelletAbove(true) || pelletBelow(true)))
         {	//if there is a powerup above or below, get it
            if(pelletAbove(true))
               dir = KeyEvent.VK_UP;
            else if(pelletBelow(true))
               dir = KeyEvent.VK_DOWN;  
         }
         //************************seek powerups (priority 4)***********************
         else if(dir==KeyEvent.VK_LEFT && pelletAboveRight(true) && row > 0 && !SnakePanel.blocked(row-1, col) && !favorsPowerups)
            dir = KeyEvent.VK_UP;
         else if(dir==KeyEvent.VK_DOWN && pelletAboveRight(true) && col < board[0].length -1 && !SnakePanel.blocked(row, col+1) && !favorsPowerups)
            dir = KeyEvent.VK_RIGHT;
         else if(dir==KeyEvent.VK_LEFT && pelletBelowRight(true) && row < board.length -1 && !SnakePanel.blocked(row+1, col) && !favorsPowerups)
            dir = KeyEvent.VK_DOWN;
         else if(dir==KeyEvent.VK_UP && pelletBelowRight(true) && col < board[0].length -1 && !SnakePanel.blocked(row, col+1) && !favorsPowerups)
            dir = KeyEvent.VK_RIGHT;
         else if(dir==KeyEvent.VK_RIGHT && pelletAboveLeft(true) && row > 0 && !SnakePanel.blocked(row-1, col) && !favorsPowerups)
            dir = KeyEvent.VK_UP;
         else if(dir==KeyEvent.VK_DOWN && pelletAboveLeft(true) && col > 0 && !SnakePanel.blocked(row, col-1) && !favorsPowerups)
            dir = KeyEvent.VK_LEFT;
         else if(dir==KeyEvent.VK_RIGHT && pelletBelowLeft(true) && row < board.length -1 && !SnakePanel.blocked(row+1, col) && !favorsPowerups)
            dir = KeyEvent.VK_DOWN;
         else if(dir==KeyEvent.VK_UP && pelletBelowLeft(true) && col > 0 && !SnakePanel.blocked(row, col-1) && !favorsPowerups)
            dir = KeyEvent.VK_LEFT;
         
         else if(dir==KeyEvent.VK_LEFT && pelletAboveRight(false) && row > 0 && !SnakePanel.blocked(row-1, col) && favorsPowerups)
            dir = KeyEvent.VK_UP;
         else if(dir==KeyEvent.VK_DOWN && pelletAboveRight(false) && col < board[0].length -1 && !SnakePanel.blocked(row, col+1) && favorsPowerups)
            dir = KeyEvent.VK_RIGHT;
         else if(dir==KeyEvent.VK_LEFT && pelletBelowRight(false) && row < board.length -1 && !SnakePanel.blocked(row+1, col) && favorsPowerups)
            dir = KeyEvent.VK_DOWN;
         else if(dir==KeyEvent.VK_UP && pelletBelowRight(false) && col < board[0].length -1 && !SnakePanel.blocked(row, col+1) && favorsPowerups)
            dir = KeyEvent.VK_RIGHT;
         else if(dir==KeyEvent.VK_RIGHT && pelletAboveLeft(false) && row > 0 && !SnakePanel.blocked(row-1, col) && favorsPowerups)
            dir = KeyEvent.VK_UP;
         else if(dir==KeyEvent.VK_DOWN && pelletAboveLeft(false) && col > 0 && !SnakePanel.blocked(row, col-1) && favorsPowerups)
            dir = KeyEvent.VK_LEFT;
         else if(dir==KeyEvent.VK_RIGHT && pelletBelowLeft(false) && row < board.length -1 && !SnakePanel.blocked(row+1, col) && favorsPowerups)
            dir = KeyEvent.VK_DOWN;
         else if(dir==KeyEvent.VK_UP && pelletBelowLeft(false) && col > 0 && !SnakePanel.blocked(row, col-1) && favorsPowerups)
            dir = KeyEvent.VK_LEFT;
         //************************make random turns (priority 5)*********************
         else if(Math.random() < unpredictability)
         {	//make some random moves
            if(dir==KeyEvent.VK_UP || dir==KeyEvent.VK_DOWN)
            {
               if(Math.random() < .5 && col < board[0].length -1 && !SnakePanel.blocked(row, col+1))
               {//make sure we don't try to make 4 turns in the same direction in succession
                  if((dir==KeyEvent.VK_UP && numRights < 4) || (dir==KeyEvent.VK_DOWN && numLefts < 4))
                     dir = KeyEvent.VK_RIGHT;
               }   
               else if(col > 0 && !SnakePanel.blocked(row, col-1))
               {//make sure we don't try to make 4 turns in the same direction in succession
                  if((dir==KeyEvent.VK_DOWN && numRights < 4) || (dir==KeyEvent.VK_UP && numLefts < 4))
                     dir = KeyEvent.VK_LEFT;
               }
            }
            else
               if(dir==KeyEvent.VK_LEFT || dir==KeyEvent.VK_RIGHT)
               {
                  if(Math.random() < .5 && row > 0 && !SnakePanel.blocked(row-1, col))
                  {//make sure we don't try to make 4 turns in the same direction in succession
                     if((dir==KeyEvent.VK_LEFT && numRights < 4) || (dir==KeyEvent.VK_RIGHT && numLefts < 4))
                        dir = KeyEvent.VK_UP;
                  }
                  else if(row < board.length -1 && !SnakePanel.blocked(row+1, col))
                  {//make sure we don't try to make 4 turns in the same direction in succession
                     if((dir==KeyEvent.VK_RIGHT && numRights < 4) || (dir==KeyEvent.VK_LEFT && numLefts < 4))
                        dir = KeyEvent.VK_DOWN;
                  }
               }
         }
         int oldDir = this.getDir();
         boolean rightTurn = false;
         boolean leftTurn = false;
         if(oldDir ==  KeyEvent.VK_UP && dir == KeyEvent.VK_RIGHT)
            rightTurn = true;
         else if(oldDir ==  KeyEvent.VK_RIGHT && dir == KeyEvent.VK_DOWN)
            rightTurn = true;
         else if(oldDir ==  KeyEvent.VK_DOWN && dir == KeyEvent.VK_LEFT)
            rightTurn = true;
         else if(oldDir ==  KeyEvent.VK_LEFT && dir == KeyEvent.VK_UP)
            rightTurn = true;
         if(dir ==  KeyEvent.VK_UP && oldDir == KeyEvent.VK_RIGHT)
            leftTurn = true;
         else if(dir ==  KeyEvent.VK_RIGHT && oldDir == KeyEvent.VK_DOWN)
            leftTurn = true;
         else if(dir ==  KeyEvent.VK_DOWN && oldDir == KeyEvent.VK_LEFT)
            leftTurn = true;
         else if(dir ==  KeyEvent.VK_LEFT && oldDir == KeyEvent.VK_UP)
            leftTurn = true;
         if(numLefts == 0 && numRights == 0)
         {
            if(leftTurn)
               numLefts = 1;
            else if(rightTurn)
               numRights = 1;
         }
         else
         {
            if(numLefts > 0 && rightTurn)
            {
               numLefts = 0;
               numRights = 1;
            }
            else if(numRights > 0 && leftTurn)
            {
               numRights = 0;
               numLefts = 1;
            }
            else if(numLefts > 0 && leftTurn)
               numLefts++;
            else if(numRights > 0 && rightTurn)
               numRights++;
         }
         this.setDir(dir);
         //System.out.println("L:"+numLefts+" R:"+numRights);
      }
   
   }