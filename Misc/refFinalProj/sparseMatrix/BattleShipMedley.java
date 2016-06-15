import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BattleShipMedley<anyType> extends JPanel
{
   public SparseMatrix<Integer> shipLocations1 = new SparseMatrix(10,10), shipLocations2 = new SparseMatrix(10,10);
   public int maxRows = 10, maxCols = 10;
   private JButton[][] board1, board2;
   private int[] guess;
   private int hits1, hits2, turns = 1, torpedoes = 50, choice;
   private JLabel label;
   private JButton reset;
   private brain computer;
   private JFrame frame;
   private boolean single = false, vs = false, comp = false;
   public BattleShipMedley()
   {
      choice = Integer.parseInt(JOptionPane.showInputDialog("Pick what you want to do: \n1. Single Player\n2. 2-Player VS\n3. Player VS Computer"));
      if(choice == 1)//Single player
      {
         single = true;
      }
      else if(choice == 2)//2 player vs
      {
         vs = true;
      }
      else if(choice == 3)//player vs computer
      {
         comp = true;
      }
      else//exit if you push anything else
      {
         System.exit(-1);
      }
      if(single)//sets up single player board
      {
         setLayout(new BorderLayout());//GUI
         hits1 = 0;//counts how many ship parts you've hit
         torpedoes = 50;//tries to hit
      
         JPanel north = new JPanel();
         north.setLayout(new FlowLayout());
         add(north, BorderLayout.NORTH);
         label = new JLabel("Welcome to Battleship -- You have 50 torpedoes.");
         north.add(label);//adds label to upper part
      
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(10,10));//sets up grid to add all the buttons
         add(center, BorderLayout.CENTER);//adds grid to center
      
         board2 = new JButton[10][10];
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board2[r][c] = new JButton();
               board2[r][c].setBackground(Color.blue);
               board2[r][c].addActionListener( new Handler1(r, c) );
               center.add(board2[r][c]);
            }//adds each buttons into the grid
      
         reset = new JButton("Reset");
         reset.addActionListener( new Handler2() );
         reset.setEnabled(false);
         add(reset, BorderLayout.SOUTH);//adds a reset button to the bottom
      
         placeShipsComp();//computer sets up it's ships
      
      }
      else if(vs)//2 player vs
      {
         setLayout(new BorderLayout());
         hits1 = 0;
         hits2 = 0;//number of hits for each player
         JPanel north = new JPanel();
         north.setLayout(new FlowLayout());
         add(north, BorderLayout.NORTH);
         label = new JLabel("Welcome to Battleship -- It's time to DU-DU-DU-DUEL!");
         north.add(label);//label to the notrth
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(10,20));//adds a grid to include both people's buttons
         add(center, BorderLayout.CENTER);   
         board1 = new JButton[10][10];
         board2 = new JButton[10][10];
         for(int r = 0; r < 10; r++)
         {
            for(int c = 0; c < 10; c++)
            {
               board1[r][c] = new JButton();  
               board1[r][c].setBackground(Color.blue);
               board1[r][c].addActionListener( new Handler3(r, c) );
               center.add(board1[r][c]);  //adds player 1's buttons       
            }
            for(int c = 0; c < 10; c++)
            {
               board2[r][c] = new JButton();  
               board2[r][c].setBackground(Color.cyan);
               board2[r][c].addActionListener( new Handler3(r, c) );
               center.add(board2[r][c]);  //adds player 2's buttons 
            }
         }
         reset = new JButton("Reset");
         reset.addActionListener( new Handler2() );
         reset.setEnabled(false);
         add(reset, BorderLayout.SOUTH);//adds a reset button
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board1[r][c].setEnabled(false);//disables player 1's board so he can't click his own buttons
            }
         placeShipsPlayer1();//player 1's ships
         placeShipsPlayer2();//player 2's ships
      
      
      }
      else if(comp)
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
               board1[r][c].addActionListener( new Handler4(r, c) );//what will the buttons do?
               center.add(board1[r][c]);         
            }
            for(int c = 0; c < 10; c++)//adds the rows of board2
            {
               board2[r][c] = new JButton();  
               board2[r][c].setBackground(Color.cyan);
               board2[r][c].addActionListener( new Handler4(r, c) );//what will the buttons do?
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
         placeShipsPlayer1();//Player places his ships
         placeShipsComp();//computer places his ships
      
      
      }
   }
   public void placeShipsPlayer1()//Player 1 Chooses his ships
   {
      JOptionPane.showMessageDialog(frame, "Other players need to turn around for this player to place his ships");
      placeShip(5, shipLocations1);
      placeShip(4, shipLocations1);
      placeShip(3, shipLocations1);
      placeShip(3, shipLocations1);
      placeShip(2, shipLocations1);
   }
   public void placeShipsPlayer2()//Player 2 chooses his ships
   {
      JOptionPane.showMessageDialog(frame, "Other players need to turn around for this player to place his ships");
      placeShip(5, shipLocations2);
      placeShip(4, shipLocations2);
      placeShip(3, shipLocations2);
      placeShip(3, shipLocations2);
      placeShip(2, shipLocations2);
   }
   public void placeShipsComp()//computer individually places each ship
   {
      placeShipComp(5);
      placeShipComp(4);
      placeShipComp(3);
      placeShipComp(3);
      placeShipComp(2);
   }
   //pre:Ship size must be > 0
   //post:All parts of the ship will be within bounds and not overlap another ship
   public void placeShip(int size, SparseMatrix<Integer> shipLocations1)//Method that allows you to place a ship of any size in
   {
      int coin = -1; 
      int myX = -1;
      int myY = -1;
      int sub = 1;
      boolean valid = false;
      String msg = JOptionPane.showInputDialog("Do you want a horizontal or vertical ship? Type in h or v.");//which way does it face
      while(coin == -1)//Forces the user to pick horizontal or vertial
      {
         if(msg.equalsIgnoreCase("h"))//horizontal
         {
            coin = 0;
         }
         else if(msg.equalsIgnoreCase("v"))//vertical
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
               valid = false;//makes you choose different location
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations1.has(myX, myY + i))//If there is already another ship there, we must choose a different location
               {
                  valid = false;//makes you choose different location
               }
            }
            if(valid == false)//Gets the x and y location from the player
            {
               myX = Integer.parseInt(JOptionPane.showInputDialog("Enter the X-coordinate where the ship will start. It must be 0 <= x <= 9"));//starting x - coordinate
               myY = Integer.parseInt(JOptionPane.showInputDialog("Enter the Y-coordinate where the ship will start. It must be 0 <= y <= " + (9 - size + 1)));//starting y-coordinate
            }
         }
         for(int y = 0; y < size; y++)
         {
            shipLocations1.add(myX, myY + y, sub);//adds the ship to the sparsematrix
         }
      }
      else if(coin == 1)//Vertical
      {
         while(myX < 0 || myY < 0 || myX > (9 - size + 1) || myY > 9 || !valid)//ship must be legally placed
         {  valid = true;
            if(myX > (9 - size + 1) || myY > 9 || myX < 0 || myY < 0)//Sets boundaries
            {
               valid = false;//Choose different location
            }
            for(int i = 0; i < size; i++)//If there's another ship there
            {
               if(shipLocations1.has(myX + i, myY))
               {
                  valid = false;//Choose different location
               }
            }
            if(valid == false)
            {
               myX = Integer.parseInt(JOptionPane.showInputDialog("Enter the X-coordinate where the ship will start. It must be 0 <= x <= " + (9 - size + 1)));//starting x-coordinate
               myY = Integer.parseInt(JOptionPane.showInputDialog("Enter the Y-coordinate where the ship will start. It must be 0 <= y <= 9"));//starting y-coordinate
            }
         }
         for(int x = 0; x < size; x++)
         {
            shipLocations1.add(myX + x, myY, sub);//adds ships to shiplocations
         }
      }
   }
   //pre:Ship size must be > 0
   //post:All parts of the ship will be within bounds and not overlap another ship
   public void placeShipComp(int size)//computer adds all his ships in with different sizes
   {
      int coin = (int)(Math.random() * 2);//Randomizes if horizontal or vertical
      int myX = -1;
      int myY = -1;
      int sub = 1;
      boolean valid = false;
      
      if(coin == 0) //horizontal
      {
         while(myX < 0 || myY < 0 || myX > 9 || myY > (9 - size + 1) || !valid)  //must be legal position     
         {
            valid = true;
            if(myX > 9 || myY > (9 - size + 1)|| myX < 0 || myY < 0)//sets boundaries
            {
               valid = false;//choose different location
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations2.has(myX, myY + i))//if it overlaps
               {
                  valid = false;//new location
               }
            }
            if(valid == false)//We randomize the x and y values
            {
               myX = (int)(Math.random() * 10);   //initial x-coordinate         
               myY = (int)(Math.random() * (9 - size + 2));//initial y-coordinate
            }
         }
         for(int y = 0; y < size; y++)
         {
            shipLocations2.add(myX, myY + y, sub);//adds the ship to the sparsematrix
         }
      }
      else if(coin == 1)//vertical
      {
         while(myX < 0 || myY < 0 || myX > (9 - size + 1) || myY > 9 || !valid)//legal positioning
         {
            valid = true;
            if(myX > (9 - size + 1) || myY > 9 || myX < 0 || myY < 0)//sets boundaries
            {
               valid = false;//new location
            }        
            for(int i = 0; i < size; i++)
            {
               if(shipLocations2.has(myX + i, myY))//if it overlaps
               {
                  valid = false;//new location
               }
            }
            if(valid == false)//chooses new location
            {
               myX = (int)(Math.random() * (9 - size + 2));//starting x-coordinate            
               myY = (int)(Math.random() * 10); //starting y-coordinate
            }
         }
         for(int x = 0; x < size; x++)
         {
            shipLocations2.add(myX + x, myY, sub);//adds to sparse matrix
         }
      }
   }
   private class Handler1 implements ActionListener//single player parameters
   {
      private int myRow, myCol;
      public Handler1(int r, int c)//what button did you hit
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         torpedoes--;//takes away an attempt
         if(shipLocations2.has(myRow, myCol))//Hit
         {
            hits1++;//hits go up
            board2[myRow][myCol].setBackground(Color.red);//represents hit
            board2[myRow][myCol].setEnabled(false);//won't be able to click here again
            shipLocations2.remove(myRow, myCol);//no longer a ship there so you can't hit it again
            label.setText("Hit! " + torpedoes + " torpedoes remaining.");//label tells you how many attempts left
         }
         else if(!shipLocations2.has(myRow, myCol))//Miss
         {
            board2[myRow][myCol].setBackground(Color.white);//represents miss
            board2[myRow][myCol].setEnabled(false);//won't be able to click on again
            label.setText("Miss! " + torpedoes + " torpedoes remaining.");//label tells you how many attempts left
         }
         if(hits1 == 17)//sunk all the ships
         {
            label.setText("You sunk my ships!");
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board2[r][c].setEnabled(false);//disables all normal buttons
               }
            reset.setEnabled(true);//lets you play again
         }
         else if(hits1 != 17 && torpedoes == 0)// if you run out of torpedos
         {
            label.setText("Woooooooooooooooow! You suck! How did you not win! N00b! Get Rekt!");
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(shipLocations2.has(r,c))
                  {
                     board2[r][c].setBackground(Color.black);//shows where the ships were
                  }
                  board2[r][c].setEnabled(false);//disables them all
               }
            }
            reset.setEnabled(true);//try again
         }
         
      }
   }
   private class Handler2 implements ActionListener//Reset button
   {
      public void actionPerformed(ActionEvent e)
      {
         if(single)//Single player
         {
            label.setText("Let's play again!");
         
            torpedoes = 50;//resets torpedos
            hits1 = 0;//resets hits
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board2[r][c].setBackground(Color.blue);
                  board2[r][c].setEnabled(true);//reconstructs board
                  shipLocations2.remove(r,c);
               
               }
            placeShipsComp();//ships are placed back in
         }
         if(vs)//2-player vs
         {
            label.setText("Let's play again!");
            hits1 = 0;
            hits2 = 0;
            turns = 1;//resets all the basics
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board1[r][c].setBackground(Color.blue);
                  board1[r][c].setEnabled(false);
                  shipLocations1.remove(r,c);//resets first board
                  board2[r][c].setBackground(Color.cyan);
                  board2[r][c].setEnabled(true);
                  shipLocations2.remove(r,c); //resets second board     
               }
            placeShipsPlayer1();//Player 1 places ships
            placeShipsPlayer2();//Player 2 places ships
         
         }
         if(comp)//Player vs Computer
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
            placeShipsPlayer1();
            placeShipsComp();//New locations for all the ships
         
         }
      
         
      }
   }
   
   private class Handler3 implements ActionListener//2 - player versus parameters
   {
      private int myRow, myCol;
      public Handler3(int r, int c)//Button that you clicked
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         if(turns % 2 == 1)//Player 1's turn
         { 
            if(shipLocations2.has(myRow, myCol))//Hit
            {
               hits1++;//increase hits
               board2[myRow][myCol].setBackground(Color.magenta);//represents hit
               for(int r = 0; r < 10; r++)
               {
                  for(int c = 0; c < 10; c++)
                  {
                     board2[r][c].setEnabled(false);//disables all buttons for board 2
                     if(board1[r][c].getBackground().equals(Color.blue))
                     {
                        board1[r][c].setEnabled(true);//only enables the buttons that haven't been tried yet
                     }
                  }
               }
               shipLocations2.remove(myRow, myCol);//no longer a ship there so it's removed
               label.setText("Hit! Player 2's turn");
               turns++;//changes to player 2's turn
            }
            else if(!shipLocations2.has(myRow, myCol))//Miss
            {
               board2[myRow][myCol].setBackground(Color.gray);//represents miss
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board2[r][c].setEnabled(false);//disables all buttons from board 2
                     if(board1[r][c].getBackground().equals(Color.blue))                     
                     {
                        board1[r][c].setEnabled(true);//only enables buttons that haven't been tried yet
                     }
                  }
               label.setText("Miss! Player 2's turn");
               turns++;//Moves to Player 2's turn
            }
            if(hits1 == 17)//did player 1 get all of player 2's ships
            {
               label.setText("Player 1 wins!");
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     board2[r][c].setEnabled(false);//disables all of the buttons
                     if(shipLocations1.has(r,c))
                     {
                        board1[r][c].setBackground(Color.black);//allows player 2 to see where player 1's ships were
                     }
                  }
                  
               reset.setEnabled(true);//Play again
            }
         }
         else//Player 2's turn
         {
            if(shipLocations1.has(myRow, myCol))//Hit
            {
               hits2++;
               board1[myRow][myCol].setBackground(Color.red);//Represents hit
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);//disables all of board 1's buttons
                     if(board2[r][c].getBackground().equals(Color.cyan))                     
                     {
                        board2[r][c].setEnabled(true);//enables only the buttons that haven't been tried yet
                     }
                  }
               shipLocations1.remove(myRow, myCol);//no longer a ship there
               label.setText("Hit! Player 1's turn");
               turns++;//switches to player 1's turn
            }
            else if(!shipLocations1.has(myRow, myCol))//miss
            {
               board1[myRow][myCol].setBackground(Color.white);//represents miss
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);//disables all of board 1
                     if(board2[r][c].getBackground().equals(Color.cyan))
                     {
                        board2[r][c].setEnabled(true);//enables only the buttons that haven't been tried
                     }
                  }
               label.setText("Miss! Player 1's turn");
               turns++;//switches to player 1's turn
            }
            if(hits2 == 17)//player 2 sinks all of player 1's ships
            {
               label.setText("Player 2 wins!");
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     board2[r][c].setEnabled(false);//disables all buttons
                     if(shipLocations2.has(r,c))
                     {
                        board2[r][c].setBackground(Color.black);//reveals player 2's unsunk ships
                     }
                  }
               reset.setEnabled(true);//play again
            }
         
         }         
      }
   }
   private class Handler4 implements ActionListener//Player vs Computer parameters
   {
      private int myRow, myCol;
      public Handler4(int r, int c)//gets the row and column of the button you clicked
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



}
