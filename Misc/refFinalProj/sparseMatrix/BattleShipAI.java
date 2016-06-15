import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
      
public class BattleShipAI<anyType> extends JPanel
{
   public SparseMatrix<Integer> shipLocations1 = new SparseMatrix(10,10), shipLocations2 = new SparseMatrix(10,10);
   public int maxRows = 10, maxCols = 10;
   private JButton[][] board1, board2;
   private int[] guess;
   private int hits1, hits2, turns = 1;
   private JLabel label;
   private JButton reset;
   private brain computer;
   public BattleShipAI()
   {
      setLayout(new BorderLayout());//GUI
      hits1 = 0;//measures how many ship parts player 1 has hit
      hits2 = 0;//measurs how many ship parts computer has hit
      JPanel north = new JPanel();//upper part of GUI
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Battleship -- It's time to DU-DU-DU-DUEL!");
      north.add(label);//adds a label to the GUI
      JPanel center = new JPanel();// Middle part
      center.setLayout(new GridLayout(10,20));//One large grid layout to hold both boards
      add(center, BorderLayout.CENTER);   
      board1 = new JButton[10][10];//Player 1's board
      board2 = new JButton[10][10];//computer's board
      for(int r = 0; r < 10; r++)//Set-up like this so that the boards can appear next to each other
      {
         for(int c = 0; c < 10; c++)//Adds the rows of board1
         {
            board1[r][c] = new JButton();  
            board1[r][c].setBackground(Color.blue);
            board1[r][c].addActionListener( new Handler1(r, c) );//what will the buttons do?
            center.add(board1[r][c]);         
         }
         for(int c = 0; c < 10; c++)//adds the rows of board2
         {
            board2[r][c] = new JButton();  
            board2[r][c].setBackground(Color.cyan);
            board2[r][c].addActionListener( new Handler1(r, c) );//what will the buttons do?
            center.add(board2[r][c]);   
         }
      }
      reset = new JButton("Reset");// a reset button
      reset.addActionListener( new Handler2() );//what will it do?
      reset.setEnabled(false);//you can't activate it until later
      add(reset, BorderLayout.SOUTH);
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            board1[r][c].setEnabled(false);//Player 1 will go first so he can only click on computer's board. These will                                            
                                           //always be disabled because the computer can't click on them. 
         }
      computer = new brain();// Creates the AI
      guess = new int[2];//This will be the computer's shot
      placeShips1();//Player places his ships
      placeShips2();//computer places his ships
   }
   public void placeShips1()//We individually place each ship
   {
      placeShip1(5);
      placeShip1(4);
      placeShip1(3);
      placeShip1(3);
      placeShip1(2);
   }
   public void placeShips2()//computer individually places each
   {
      placeShip2(5);
      placeShip2(4);
      placeShip2(3);
      placeShip2(3);
      placeShip2(2);
   }
   public void placeShip1(int size)//Method that allows you to place a ship of any size in
   {
      int coin = -1; 
      int myX = -1;
      int myY = -1;
      int sub = 1;
      boolean valid = false;
      String msg = JOptionPane.showInputDialog("Do you want a horizontal or vertical ship? Type in h or v.");//which way does it face
      while(coin == -1)//Forces the user to pick horizontal or vertial
      {
         if(msg.equalsIgnoreCase("h"))
         {
            coin = 0;
         }
         else if(msg.equalsIgnoreCase("v"))
         {
            coin = 1;
         }
         else
         {
            msg = JOptionPane.showInputDialog("Quit being an idiot. Do you want a horizontal or vertical carrier? Type in h or v.");
         }
      }
      if(coin == 0) //Horizontal
      {
         while(myX < 0 || myY < 0 || myX > 9 || myY > (9 - size + 1) || !valid) //ensures that the ship is legally placed       
         {
            valid = true;
            if(myX > 9 || myY > (9 - size + 1) || myX < 0 || myY < 0)//If the ship is out of bounds we must choose a different location
            {
               valid = false;
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations1.has(myX, myY + i))//If there is already another ship there, we must choose a different location
               {
                  valid = false;
               }
            }
            if(valid == false)//Gets the x and y location from the player
            {
               myX = Integer.parseInt(JOptionPane.showInputDialog("Enter the X-coordinate where the ship will start. It must be 0 <= x <= 9"));
               myY = Integer.parseInt(JOptionPane.showInputDialog("Enter the Y-coordinate where the ship will start. It must be 0 <= y <= " + (9 - size + 1)));
            }
         }
         for(int y = 0; y < size; y++)
         {
            shipLocations1.add(myX, myY + y, sub);//adds the ship to the sparsematrix
         }
      }
      else if(coin == 1)//Vertical
      {
         while(myX < 0 || myY < 0 || myX > (9 - size + 1) || myY > 9 || !valid)
         {  valid = true;
            if(myX > (9 - size + 1) || myY > 9 || myX < 0 || myY < 0)
            {
               valid = false;
            }
            for(int i = 0; i < size; i++)
            {
               if(shipLocations1.has(myX + i, myY))
               {
                  valid = false;
               }
            }
            if(valid == false)
            {
               myX = Integer.parseInt(JOptionPane.showInputDialog("Enter the X-coordinate where the ship will start. It must be 0 <= x <= " + (9 - size + 1)));
               myY = Integer.parseInt(JOptionPane.showInputDialog("Enter the Y-coordinate where the ship will start. It must be 0 <= y <= 9"));
            }
         }
         for(int x = 0; x < size; x++)
         {
            shipLocations1.add(myX + x, myY, sub);
         }
      }
   }
   public void placeShip2(int size)//computer adds all his ships in with different sizes
   {
      int coin = (int)(Math.random() * 2);//Randomizes if horizontal or vertical
      int myX = -1;
      int myY = -1;
      int sub = 1;
      boolean valid = false;
      
      if(coin == 0) //horizontal
      {
         while(myX < 0 || myY < 0 || myX > 9 || myY > (9 - size + 1) || !valid)  //same as human      
         {
            valid = true;
            if(myX > 9 || myY > (9 - size + 1)|| myX < 0 || myY < 0)//same as human
            {
               valid = false;
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations2.has(myX, myY + i))//same as human
               {
                  valid = false;
               }
            }
            if(valid == false)//We randomize the x and y values
            {
               myX = (int)(Math.random() * 10);            
               myY = (int)(Math.random() * (9 - size + 2));
            }
         }
         for(int y = 0; y < size; y++)
         {
            shipLocations2.add(myX, myY + y, sub);//adds the ship to the sparsematrix
         }
      }
      else if(coin == 1)//vertical
      {
         while(myX < 0 || myY < 0 || myX > (9 - size + 1) || myY > 9 || !valid)
         {
            valid = true;
            if(myX > (9 - size + 1) || myY > 9 || myX < 0 || myY < 0)
            {
               valid = false;
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations2.has(myX + i, myY))
               {
                  valid = false;
               }
            }
            if(valid == false)
            {
               myX = (int)(Math.random() * (9 - size + 2));            
               myY = (int)(Math.random() * 10); 
            }
         }
         for(int x = 0; x < size; x++)
         {
            shipLocations2.add(myX + x, myY, sub);
         }
      }
   }
   private class Handler1 implements ActionListener//Tells what the regular button does
   {
      private int myRow, myCol;
      public Handler1(int r, int c)//gets the row and column of the button you clicked
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         if(shipLocations2.has(myRow, myCol))//If a ship is there
         {
            hits1++;//Increase the number of hits
            board2[myRow][myCol].setBackground(Color.magenta);//That button becomes magenta
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  board2[r][c].setEnabled(false);//disable the board until the computer makes his move
               }
            }
            shipLocations2.remove(myRow, myCol);//there's no longer a ship there so it is removed
            label.setText("Hit! Computer's turn");//the label tells what happened
            turns++;//keeps track of the # of turns
         }
         else if(!shipLocations2.has(myRow, myCol))//If there isn't a ship there
         {
            board2[myRow][myCol].setBackground(Color.gray);//That button becomes gray
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board2[r][c].setEnabled(false);//Disable the board until the computer moves
               }
            label.setText("Miss! Computer's turn");
            turns++;
         }
         if(hits1 == 17)//Have you hit every single ship? (It's 17 because 5+4+3+3+2 = 17)
         {
            label.setText("Player 1 wins!");//announces winner
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board1[r][c].setEnabled(false);//disables both boards
                  board2[r][c].setEnabled(false);
                  if(shipLocations1.has(r,c))
                  {
                     board1[r][c].setBackground(Color.black);//shows the computer where your undiscovered ships were
                  }
               }
            reset.setEnabled(true);//the reset button is the only thing you can click or you can leave
         }
         guess = computer.play(board1, shipLocations1);//uses the computer's AI to find it's guess
         while(!board1[guess[0]][guess[1]].getBackground().equals(Color.blue))//If the computer fires into a space that has already been guessed, it will try again
         {
            guess = computer.play(board1, shipLocations1);
         }
         if(shipLocations1.has(guess[0], guess[1]))//If you have a ship there
         {
            hits2++;//Computer's hits go up
            board1[guess[0]][guess[1]].setBackground(Color.red);//That button becomes red
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(board2[r][c].getBackground().equals(Color.cyan))
                  {
                     board2[r][c].setEnabled(true);//All of your buttons come back if they haven't been guessed yet
                  }
               }
            }
            shipLocations1.remove(guess[0], guess[1]);//No longer a ship there so it is removed
            label.setText("Hit! Player 1's turn");//Label tells what happened
            turns++;//Keeps track of turns
         }
         else if(!shipLocations1.has(guess[0], guess[1]))//If there is no ship there
         {
            board1[guess[0]][guess[1]].setBackground(Color.white);//That button becomes white
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  if(board2[r][c].getBackground().equals(Color.cyan))
                  {
                     board2[r][c].setEnabled(true);//Reenables all untouched buttons
                  }
               }
            label.setText("Miss! Player 1's turn");//Label tells what happened
            turns++;//Keeps track of turns
         }
         if(hits2 == 17)//Has the computer hit all your ships?
         {
            label.setText("Computer wins!");//Announces winner
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board1[r][c].setEnabled(false);
                  board2[r][c].setEnabled(false);//disables both boards
                  if(shipLocations2.has(r,c))
                  {
                     board2[r][c].setBackground(Color.black);//reveals the ships that you missed
                  }
               }
            reset.setEnabled(true);//hit the reset 
         }
      
      
      }         
   }
   private class Handler2 implements ActionListener//Tells what the reset button will do
   {
      public void actionPerformed(ActionEvent e)
      {
         label.setText("Let's play again!");//sets label
         hits1 = 0;
         hits2 = 0;//resets everyone's hits to 0
         turns = 1;//resets the turns to 0
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board1[r][c].setBackground(Color.blue);
               board1[r][c].setEnabled(false);//resets colors and disables 
               board2[r][c].setBackground(Color.cyan);
               board2[r][c].setEnabled(true);//resets colors and reenables       
            }
         shipLocations1.clear();
         shipLocations2.clear();//clears out all the ships
         placeShips1();
         placeShips2();//New locations for all the ships
         
      }
   }
}