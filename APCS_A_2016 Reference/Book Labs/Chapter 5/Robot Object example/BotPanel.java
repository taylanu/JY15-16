   import javax.swing.JPanel;
   import javax.swing.ImageIcon;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.event.KeyEvent;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;


   public class BotPanel extends JPanel
   {
      private ImageIcon playerN = new ImageIcon("playerN.jpg");
      private ImageIcon playerE = new ImageIcon("playerE.jpg");
      private ImageIcon playerS = new ImageIcon("playerS.jpg");
      private ImageIcon playerW = new ImageIcon("playerW.jpg");
      private ImageIcon blank = new ImageIcon("blank.jpg");
   
      private static final int SIZE=40;		//size of cell being drawn
    
      private static int numRows, numCols; 	//size of the board 
   	 
      private static Robot smiley;
   	 
      public BotPanel()
      {
         numRows = 10;
         numCols = 10;
         smiley = new Robot();
      }
   
   
   	//post:  shows different pictures on the screen in grid format depending on the values stored in the array board
   	//			0-blank, 1-white, 2-black and gives priority to drawing the player
      public void showBoard(Graphics g)	
      {
         int x =0, y=0;		//upper left corner location of where image will be drawn
         for(int r=0;r<numRows;r++)
         {
            x = 0;						//reset the row distance
            for(int c=0;c<numCols;c++)
            {
               g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                            
               if(r==smiley.getY() && c==smiley.getX())	//draw the Robot on the board after the cell has been drawn
               {
                  if(smiley.getDir().equals("NORTH"))
                     g.drawImage(playerS.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                  else if(smiley.getDir().equals("EAST"))
                     g.drawImage(playerE.getImage(), x, y, SIZE, SIZE, null);  
                  else if(smiley.getDir().equals("SOUTH"))
                     g.drawImage(playerN.getImage(), x, y, SIZE, SIZE, null); 
                  else
                     g.drawImage(playerW.getImage(), x, y, SIZE, SIZE, null); 
               }
               x+=SIZE;
            }
            y+=SIZE;
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
         if(k==KeyEvent.VK_M)
            smiley.move();
         else 
            if(k==KeyEvent.VK_T)
               smiley.turnLeft();
         repaint();			//refresh the screen
      }
   
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g); 
         g.setColor(Color.blue);		//draw a blue boarder around the board
         g.fillRect(0, 0, numCols, numRows);
         showBoard(g);					//draw the contents of the array board on the screen
      }
      
   
   }
