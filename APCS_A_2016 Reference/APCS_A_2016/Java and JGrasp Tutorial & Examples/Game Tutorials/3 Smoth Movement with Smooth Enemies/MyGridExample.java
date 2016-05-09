   import javax.swing.JPanel;
   import javax.swing.ImageIcon;
   import javax.swing.Timer;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.event.KeyEvent;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
 	
    public class MyGridExample extends JPanel
   {	
   	//images to use to represent array values
      private ImageIcon blank = new ImageIcon("blank.jpg");				//for array value 0
      private ImageIcon white = new ImageIcon("white.jpg");				//for array value 1
      private ImageIcon wall = new ImageIcon("brick.jpg");				//for array value 2
   
      private static final int SIZE=40;	//size of cell being drawn
    
      private static final int DELAY=10;	//#miliseconds delay between each time the enemy moves and screen refreshes for the timer
      private static final int SPEED=1;	//when the crosshair moves from one cell to the next, this is how many pixels they move in each frame (designated by the timer)
      //This array will be represented graphically on the screen
      private static int[][] board;			//we will fill with 0s, 1s, and 2s
     
      Player [] players;						//array of player objects
   	
      private static final int UP = 0;		//movement directions to use as index for moveDir array
      private static final int RIGHT = 1;
      private static final int DOWN = 2;
      private static final int LEFT = 3;
      
      private Timer t;							//used to set the speed of the enemy that moves around the screen
   
       public MyGridExample()
      {
         int numRows = (int)(Math.random()*13)+3;		//array has a random size
         int numColumns = (int)(Math.random()*13)+3;
         board = new int[numRows][numColumns];
         for(int r=0;r<board.length;r++)					//fill with random values (0,1 or 2)
            for(int c=0;c<board[0].length;c++)
               board[r][c] = (int)(Math.random()*3);
               
         players = new Player[3];
         for(int i=0; i<players.length; i++)
         {
            if(i==0)					//start player position in the middle
               players[i] = new Player("US",  board.length/2, board[0].length/2, "player.GIF");
            else						//start enemy in the upper left corner
               players[i] = new Player("Enemy"+i, 0, 0, "enemy.GIF");
         }
      
         t = new Timer(DELAY, new Listener());			//the higher the value of DELAY, the slower the enemy will move
         t.start();
      
      }
   
   
   	//post:  shows different pictures on the screen in grid format depending on the values stored in the array board
   	//			0-blank, 1-white, 2-black and gives priority to drawing the player
       public void showBoard(Graphics g)	
      {
         int x =0, y=0;		//upper left corner location of where image will be drawn
         int tempX = 0, tempY = 0;			//save locations for graphic position of where the player is to be used to draw the player in motion when transitioning from one cell to another
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
                     g.drawImage(wall.getImage(), x, y, SIZE, SIZE, null);  //scaled image
               x+=SIZE;
            }
            y+=SIZE;
         }
         for(int i=0; i<players.length; i++)
         {
            Player curr = players[i];
            g.drawImage(curr.getPicture().getImage(), curr.findX(SIZE), curr.findY(SIZE), SIZE, SIZE, null);  //scaled image
         }
      }
   
   	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
   	//pre:   k is a valid keyCode
   	//post:  changes the players position depending on the key that was pressed (sent from the driver)
   	//			keeps the player in the bounds of the size of the array board, then the enemy moves
       public void processUserInput(int k)
      {
         if(k==KeyEvent.VK_Q || k==KeyEvent.VK_ESCAPE)					//End the program	
            System.exit(1);
         Player curr = players[0];		//players[0] is person playing the game
         //cancel move order if we are already moving from one space to the next
         if(curr.isMoving())
            return;
         curr.clearDirections();
         curr.setMoveIncrX(0);
         curr.setMoveIncrY(0);
         if(k==KeyEvent.VK_SPACE)	//toggle the value of the array at that position
            board[curr.getRow()][curr.getCol()] = (board[curr.getRow()][curr.getCol()]+1) % 3;
         else
            if(k==KeyEvent.VK_UP && curr.getRow()>0 && board[curr.getRow()-1][curr.getCol()]!=2)
               curr.setDirection(UP);
            else 
               if(k==KeyEvent.VK_DOWN && curr.getRow()<board.length-1 && board[curr.getRow()+1][curr.getCol()]!=2)
                  curr.setDirection(DOWN);
               else
                  if(k==KeyEvent.VK_LEFT && curr.getCol()>0 && board[curr.getRow()][curr.getCol()-1]!=2)
                     curr.setDirection(LEFT); 
                  else 
                     if(k==KeyEvent.VK_RIGHT && curr.getCol()<board[0].length-1 && board[curr.getRow()][curr.getCol()+1]!=2)
                        curr.setDirection(RIGHT);
         repaint();			//refresh the screen
      }
   
       public void movePlayerSmoothly()
      {
         for(int i=0; i < players.length; i++)
         {
            Player curr = players[i];
            if(Math.abs(curr.getMoveIncrX()) >= SIZE || Math.abs(curr.getMoveIncrY()) >= SIZE)
            {
               curr.setMoveIncrX(0);
               curr.setMoveIncrY(0);
               if(curr.isMovingUp() && curr.getRow()>0 && board[curr.getRow()-1][curr.getCol()]!=2)
                  curr.setRow(curr.getRow()-1);
               else 
                  if(curr.isMovingDown() && curr.getRow()<board.length-1 && board[curr.getRow()+1][curr.getCol()]!=2)
                     curr.setRow(curr.getRow()+1);
                  else
                     if(curr.isMovingLeft() && curr.getCol()>0 && board[curr.getRow()][curr.getCol()-1]!=2)
                        curr.setCol(curr.getCol()-1);
                     else 
                        if(curr.isMovingRight() && curr.getCol()<board[0].length-1 && board[curr.getRow()][curr.getCol()+1]!=2)
                           curr.setCol(curr.getCol()+1);
               curr.clearDirections();            
            }
            else
            {
               if(curr.isMovingUp() && curr.getRow()>0)
                  curr.addMoveIncrY(-1*SPEED);
               else 
                  if(curr.isMovingDown() && curr.getRow()<board.length-1)
                     curr.addMoveIncrY(SPEED);
                  else
                     if(curr.isMovingLeft() && curr.getCol()>0)
                        curr.addMoveIncrX(-1*SPEED);
                     else 
                        if(curr.isMovingRight() && curr.getCol()<board[0].length-1)
                           curr.addMoveIncrX(SPEED);
            }
         }
      }
   
   //enemy moves to one of 8 adjacent places around it - returns false if it doesnt move
       public void makeEnemyMove()
      {	//all players after index 0 are enemies
         for(int i=1; i<players.length; i++)
         {
            Player curr = players[i];
            if(curr.isMoving())
               continue;
            curr.clearDirections();
            curr.setMoveIncrX(0);
            curr.setMoveIncrY(0);
            
            int rand = (int)(Math.random()*4);
               
            if(rand==UP && curr.getRow()>0 && board[curr.getRow()-1][curr.getCol()]!=2)
               curr.setDirection(UP);
            else 
               if(rand==DOWN && curr.getRow()<board.length-1 && board[curr.getRow()+1][curr.getCol()]!=2)
                  curr.setDirection(DOWN);
               else
                  if(rand==LEFT && curr.getCol()>0 && board[curr.getRow()][curr.getCol()-1]!=2)
                     curr.setDirection(LEFT); 
                  else 
                     if(rand==RIGHT && curr.getCol()<board[0].length-1 && board[curr.getRow()][curr.getCol()+1]!=2)
                        curr.setDirection(RIGHT);
         }  
      }
   
       public void paintComponent(Graphics g)
      {
         super.paintComponent(g); 
         g.setColor(Color.blue);		//draw a blue boarder around the board
         g.fillRect(0, 0, (board[0].length*SIZE), (board.length*SIZE));
         showBoard(g);					//draw the contents of the array board on the screen
      }
      
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)	//this is called for each timer iteration - make the enemy move randomly
         {
            movePlayerSmoothly();
            makeEnemyMove();
            repaint();
         }
      }
   
   }
