//http://www.datagenetics.com/blog/december32011/index.html
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class brain//AI
{
   private SparseMatrix<Integer> potential;      
   public brain()      //constructor
   {
      potential = new SparseMatrix(10,10);//where there may be ships
   }
   
   public int[] play(JButton[][] board1, SparseMatrix<Integer> shipLocations1)
   {
      int[] shot = new int[2];
      shot[0] = -1;
      shot[1] = -1;
      if(potential.isEmpty())//If we have no clue where anything is...
      {
         while(shot[0] < 0 || shot[1] < 0 || !board1[shot[0]][shot[1]].getBackground().equals(Color.blue))//Fire randomly
         {
            shot[0] = (int)(Math.random() * 10);
            shot[1] = (int)(Math.random() * 10);
         }
         if(shipLocations1.has(shot[0], shot[1]))//If we hit something, then we add all bordering squares as potential ships
         {
            if(shot[0] == 0 && shot[1] == 0)
            {
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 0 && shot[1] == 9)
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 9 && shot[1] == 0)
            {
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[0] == 9 && shot[1] == 9)
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[0] == 0 && !(shot[1] == 0 || shot[1] == 9))
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 9 && !(shot[1] == 0 || shot[1] == 9))
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[1] == 0 && !(shot[0] == 0 || shot[0] == 9))
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] + 1, 1);
            }
            else if(shot[1] == 9 && !(shot[0] == 0 || shot[0] == 9))
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] - 1, 1);
            }
            else
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] - 1, 1);  
               potential.add(shot[0], shot[1] + 1, 1);
            }
         } 
      }
      else if(!potential.isEmpty())//If we have an idea of where a ship may be, fire at those places
      {
         shot[0] = potential.getFirstRow();
         shot[1] = potential.getFirstCol();
         potential.remove(shot[0], shot[1]);
         if(shipLocations1.has(shot[0], shot[1]))
         {
            if(shot[0] == 0 && shot[1] == 0)
            {
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 0 && shot[1] == 9)
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 9 && shot[1] == 0)
            {
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[0] == 9 && shot[1] == 9)
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[0] == 0 && !(shot[1] == 0 || shot[1] == 9))
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] + 1, shot[1], 1);
            }
            else if(shot[0] == 9 && !(shot[1] == 0 || shot[1] == 9))
            {
               potential.add(shot[0], shot[1] - 1, 1);
               potential.add(shot[0], shot[1] + 1, 1);
               potential.add(shot[0] - 1, shot[1], 1);
            }
            else if(shot[1] == 0 && !(shot[0] == 0 || shot[0] == 9))
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] + 1, 1);
            }
            else if(shot[1] == 9 && !(shot[0] == 0 || shot[0] == 9))
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] - 1, 1);
            }
            else
            {
               potential.add(shot[0] - 1, shot[1], 1);
               potential.add(shot[0] + 1, shot[1], 1);
               potential.add(shot[0], shot[1] - 1, 1);  
               potential.add(shot[0], shot[1] + 1, 1);
            }
         } 
      }
      for(int r = 0; r < 10; r++)//This helps remove potential spaces where we have already fired
      {
         for(int c = 0; c < 10; c++)
         {
            if(!board1[r][c].getBackground().equals(Color.blue))
            {
               potential.remove(r,c);
            }
         }
      }
      return shot;//sends to the BattleShipAI class
   }
   
   
}
