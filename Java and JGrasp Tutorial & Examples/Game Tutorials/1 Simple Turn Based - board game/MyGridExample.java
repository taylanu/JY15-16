   import javax.swing.JPanel;
   import javax.swing.ImageIcon;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.event.KeyEvent;

   public class MyGridExample extends JPanel
   {
      private ImageIcon white = new ImageIcon("white.jpg");
      private ImageIcon black = new ImageIcon("black.jpg");
      private ImageIcon blank = new ImageIcon("blank.jpg");
      private ImageIcon enemy = new ImageIcon("player.jpg");			//the enemy image
      private ImageIcon crossHair = new ImageIcon("crossHair.GIF");	//GIF immages can have transparency
   
      private static final int SIZE=40;	//size of cell being drawn
    
      //This array will be represented graphically on the screen
      private static int[][] board;	
    	//A moveable smiley face will start in the center of the field
      private static int playerR;			//start row for the player
      private static int playerC;			//start col for the player
      private static int enemyR;				//start row for the enemy
      private static int enemyC;				//start col for the enemy
   
      public MyGridExample()
      {
         int numRows = (int)(Math.random()*13)+3;		//array has a random size
         int numColumns = (int)(Math.random()*13)+3;
         board = new int[numRows][numColumns];
         for(int r=0;r<board.length;r++)					//fill with random values (0,1 or 2)
            for(int c=0;c<board[0].length;c++)
               board[r][c] = (int)(Math.random()*3);
         playerR = board.length/2;							//start player position in the middle
         playerC = board[0].length/2;	
         enemyR = 0;												//start enemy in the upper left corner
         enemyC = 0;
      
      }
   
   
   	//post:  shows different pictures on the screen in grid format depending on the values stored in the array board
   	//			0-blank, 1-white, 2-black and gives priority to drawing the player
      public void showBoard(Graphics g)	
      {
         int x =0, y=0;		//upper left corner location of where image will be drawn
         for(int r=0;r<board.length;r++)
         {
            x = 0;						//reset the row distance
            for(int c=0;c<board[0].length;c++)
            {
               if(board[r][c]==0)
                  g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);  //scaled image
               else
                  if(board[r][c]==1)
                     g.drawImage(white.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                  else // if(board[r][c]==2)
                     g.drawImage(black.getImage(), x, y, SIZE, SIZE, null);  //scaled image
              
               if(r==enemyR && c==enemyC)	//draw the enemy on the board after the cell has been drawn
                  g.drawImage(enemy.getImage(), x, y, SIZE, SIZE, null);  //scaled image
            
               if(r==playerR && c==playerC)	//draw the crosshair on the board after the cell has been drawn
                  g.drawImage(crossHair.getImage(), x, y, SIZE, SIZE, null);  //scaled image
            
               x+=SIZE;
            }
            y+=SIZE;
         }
      }
   
    //enemy moves to one of 8 adjacent places around it - returns false if it doesnt move
      public boolean makeEnemyMove()
      {
         int rand = (int)(Math.random()*8);
         if(rand==0 && enemyR>0 && enemyC>0)
         {
            enemyR--;
            enemyC--;
            return true;
         }
         if(rand==1 && enemyR>0)
         {
            enemyR--;
            return true;
         }
         if(rand==2 && enemyR>0 && enemyC<board[0].length-1)
         {
            enemyR--;
            enemyC++;
            return true;
         }
         if(rand==3 && enemyC<board[0].length-1)
         {
            enemyC++;
            return true;
         }
         if(rand==4 && enemyR<board.length-1 && enemyC<board[0].length-1)
         {
            enemyR++;
            enemyC++;
            return true;
         }
         if(rand==5 && enemyR<board.length-1)
         {
            enemyR++;
            return true;
         }
         if(rand==6 && enemyR<board.length-1 && enemyC>0)
         {
            enemyR++;
            enemyC--;
            return true;
         }
         if(rand==7 && enemyC>0)
         {
            enemyC--;
            return true;
         }
         return false;      
      }
   
   	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
   	//pre:   k is a valid keyCode
   	//post:  changes the players position depending on the key that was pressed (sent from the driver)
   	//			keeps the player in the bounds of the size of the array board, then the enemy moves
      public void processUserInput(int k)
      {
         if(k==KeyEvent.VK_Q || k==KeyEvent.VK_ESCAPE)					//End the program	
            System.exit(1);
         if(k==KeyEvent.VK_UP && playerR>0)
            playerR--;
         else 
            if(k==KeyEvent.VK_DOWN && playerR<board.length-1)
               playerR++;
            else
               if(k==KeyEvent.VK_LEFT && playerC>0)
                  playerC--;
               else 
                  if(k==KeyEvent.VK_RIGHT && playerC<board[0].length-1)
                     playerC++;
                  else 
                     if(k==KeyEvent.VK_SPACE)	//toggle the value of the array at that position
                        board[playerR][playerC] = (board[playerR][playerC]+1) % 3;
         makeEnemyMove();
         repaint();			//refresh the screen
      }
   
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g); 
         g.setColor(Color.blue);		//draw a blue boarder around the board
         g.fillRect(0, 0, (board[0].length*SIZE), (board.length*SIZE));
         showBoard(g);					//draw the contents of the array board on the screen
      }
   }
