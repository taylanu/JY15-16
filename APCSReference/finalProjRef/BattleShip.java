import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
      
public class BattleShip<anyType> extends JPanel
{
   public SparseMatrix<Integer> shipLocations = new SparseMatrix(10,10);
   public int maxRows = 10, maxCols = 10;
   private JButton[][] board;
   private int hits, torpedoes;
   private JLabel label;
   private JButton reset;

   public BattleShip()
   {
      setLayout(new BorderLayout());
      hits = 0;
      torpedoes = 50;
   
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Battleship -- You have 50 torpedoes.");
      north.add(label);
   
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
   
      board = new JButton[10][10];
      for(int r = 0; r < 10; r++)
         for(int c = 0; c < 10; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener( new Handler1(r, c) );
            center.add(board[r][c]);
         }
   
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
   
      placeShips();
   }

   public void placeShips()
   {
      placeShip(5);
      placeShip(4);
      placeShip(3);
      placeShip(3);
      placeShip(2);
   }
   
public void placeShip(int size)//computer adds all his ships in with different sizes
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
               if(shipLocations.has(myX, myY + i))//same as human
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
            shipLocations.add(myX, myY + y, sub);//adds the ship to the sparsematrix
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
               if(shipLocations.has(myX + i, myY))
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
            shipLocations.add(myX + x, myY, sub);
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
         torpedoes--;
         if(shipLocations.has(myRow, myCol))
         {
            hits++;
            board[myRow][myCol].setBackground(Color.red);
            board[myRow][myCol].setEnabled(false);
            shipLocations.remove(myRow, myCol);
            label.setText("Hit! " + torpedoes + " torpedoes remaining.");
         }
         else if(!shipLocations.has(myRow, myCol))
         {
            board[myRow][myCol].setBackground(Color.white);
            board[myRow][myCol].setEnabled(false);
            label.setText("Miss! " + torpedoes + " torpedoes remaining.");
         }
         if(hits == 17)
         {
            label.setText("You sunk my ships!");
            for(int r = 0; r < 10; r++)
               for(int c = 0; c < 10; c++)
               {
                  board[r][c].setEnabled(false);
               }
            reset.setEnabled(true);
         }
         else if(hits != 17 && torpedoes == 0)// if you run out of torpedos
         {
            label.setText("Woooooooooooooooow! You suck! How did you not win! N00b! Get Rekt!");
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(shipLocations.has(r,c))
                  {
                     board[r][c].setBackground(Color.black);//shows where the ships were
                  }
                  board[r][c].setEnabled(false);//disables them all
               }
            }
            reset.setEnabled(true);
         }
         
      }
   }
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         label.setText("Let's play again!");
      
         torpedoes = 50;//resets torpedos
         hits = 0;
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board[r][c].setBackground(Color.blue);
               board[r][c].setEnabled(true);
               shipLocations.remove(r,c);
            
            }
         placeShips();
         
      }
   }
}