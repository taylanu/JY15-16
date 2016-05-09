import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class CheckerBoard extends JPanel
{
   private ImageIcon black = new ImageIcon("black.jpg");
   private ImageIcon red = new ImageIcon("red.jpg");
   private ImageIcon crossHair = new ImageIcon("crossHair.GIF");	//GIF immages can have transparency

   private static final int SIZE=40;	//size of cell being drawn
 
   //This array will be represented graphically on the screen
   private static int[][] board;	

   private static int playerR;			//start row for the player
   private static int playerC;			//start col for the player

   public CheckerBoard()
   {
      board = new int[8][8];
      //To do: fill with values (0 -black, or 1 -red), alternating in a checkerboard pattern
         
            
      playerR = board.length/2;							//start player position in the middle
      playerC = board[0].length/2;	
   
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
               g.drawImage(black.getImage(), x, y, SIZE, SIZE, null);  //scaled image
            else //if(board[r][c]==1)
               g.drawImage(red.getImage(), x, y, SIZE, SIZE, null);  //scaled image
           
            if(r==playerR && c==playerC)	//draw the crosshair on the board after the cell has been drawn
               g.drawImage(crossHair.getImage(), x, y, SIZE, SIZE, null);  //scaled image
         
            x+=SIZE;
         }
         y+=SIZE;
      }
   }
   
	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
	//pre:   k is a valid keyCode
	//post:  changes the players position depending on the key that was pressed (sent from the driver)
	//			keeps the player in the bounds of the size of the array board
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
                  {
                    
                  }
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
