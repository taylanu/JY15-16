import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
      
public class BattleShipVS<anyType> extends JPanel
{
   public SparseMatrix<Integer> shipLocations1 = new SparseMatrix(10,10), shipLocations2 = new SparseMatrix(10,10);
   public int maxRows = 10, maxCols = 10;
   private JButton[][] board1, board2;
   private int hits1, hits2, turns = 1;
   private JLabel label;
   private JButton reset;
   private JFrame frame;
   public BattleShipVS()
   {
      setLayout(new BorderLayout());
      hits1 = 0;
      hits2 = 0;
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Battleship -- It's time to DU-DU-DU-DUEL!");
      north.add(label);
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,20));
      add(center, BorderLayout.CENTER);   
      board1 = new JButton[10][10];
      board2 = new JButton[10][10];
      for(int r = 0; r < 10; r++)
      {
         for(int c = 0; c < 10; c++)
         {
            board1[r][c] = new JButton();  
            board1[r][c].setBackground(Color.blue);
            board1[r][c].addActionListener( new Handler1(r, c) );
            center.add(board1[r][c]);         
         }
         for(int c = 0; c < 10; c++)
         {
            board2[r][c] = new JButton();  
            board2[r][c].setBackground(Color.cyan);
            board2[r][c].addActionListener( new Handler1(r, c) );
            center.add(board2[r][c]);   
         }
      }
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            board1[r][c].setEnabled(false);
         }
      placeShips1();
      placeShips2();
   }
   public void placeShips1()
   {
      JOptionPane.showMessageDialog(frame, "Player 1 is choosing their ship placements. Player 2 needs to look away.");
      placeShip1(5);
      placeShip1(4);
      placeShip1(3);
      placeShip1(3);
      placeShip1(2);
   }
   public void placeShips2()
   {
      JOptionPane.showMessageDialog(frame, "Player 2 is choosing their ship placements. Player 1 needs to look away.");
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
public void placeShip2(int size)//Method that allows you to place a ship of any size in
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
               if(shipLocations2.has(myX, myY + i))//If there is already another ship there, we must choose a different location
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
            shipLocations2.add(myX, myY + y, sub);//adds the ship to the sparsematrix
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
               if(shipLocations2.has(myX + i, myY))
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
            shipLocations2.add(myX + x, myY, sub);
         }
      }
   }

      private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         if(turns % 2 == 1)
         { 
            if(shipLocations2.has(myRow, myCol))
            {
               hits1++;
               board2[myRow][myCol].setBackground(Color.magenta);
               for(int r = 0; r < 10; r++)
               {
                  for(int c = 0; c < 10; c++)
                  {
                     board2[r][c].setEnabled(false);
                     if(board1[r][c].getBackground().equals(Color.blue))
                     {
                        board1[r][c].setEnabled(true);
                     }
                  }
               }
               shipLocations2.remove(myRow, myCol);
               label.setText("Hit! Player 2's turn");
               turns++;
            }
            else if(!shipLocations2.has(myRow, myCol))
            {
               board2[myRow][myCol].setBackground(Color.gray);
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board2[r][c].setEnabled(false);
                     if(board1[r][c].getBackground().equals(Color.blue))                     
                     {
                        board1[r][c].setEnabled(true);
                     }
                  }
               label.setText("Miss! Player 2's turn");
               turns++;
            }
            if(hits1 == 17)
            {
               label.setText("Player 1 wins!");
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     board2[r][c].setEnabled(false);
                     if(shipLocations1.has(r,c))
                     {
                        board1[r][c].setBackground(Color.black);
                     }
                  }
                  
               reset.setEnabled(true);
            }
         }
         else
         {
            if(shipLocations1.has(myRow, myCol))
            {
               hits2++;
               board1[myRow][myCol].setBackground(Color.red);
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     if(board2[r][c].getBackground().equals(Color.cyan))                     
                     {
                        board2[r][c].setEnabled(true);
                     }
                  }
               shipLocations1.remove(myRow, myCol);
               label.setText("Hit! Player 1's turn");
               turns++;
            }
            else if(!shipLocations1.has(myRow, myCol))
            {
               board1[myRow][myCol].setBackground(Color.white);
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     if(board2[r][c].getBackground().equals(Color.cyan))
                     {
                        board2[r][c].setEnabled(true);
                     }
                  }
               label.setText("Miss! Player 1's turn");
               turns++;
            }
            if(hits2 == 17)
            {
               label.setText("Player 2 wins!");
               for(int r = 0; r < 10; r++)
                  for(int c = 0; c < 10; c++)
                  {
                     board1[r][c].setEnabled(false);
                     board2[r][c].setEnabled(false);
                     if(shipLocations2.has(r,c))
                     {
                        board2[r][c].setBackground(Color.black);
                     }
                  }
               reset.setEnabled(true);
            }
         
         }         
      }
   }
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         label.setText("Let's play again!");
         hits1 = 0;
         hits2 = 0;
         turns = 1;
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board1[r][c].setBackground(Color.blue);
               board1[r][c].setEnabled(false);
               shipLocations1.remove(r,c);
               board2[r][c].setBackground(Color.cyan);
               board2[r][c].setEnabled(true);
               shipLocations2.remove(r,c);         
            }
         placeShips1();
         placeShips2();
         
      }
   }
}