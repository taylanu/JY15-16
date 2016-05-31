   import javax.swing.JFrame;
   public class BattleShipMedleyDriver
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("SparseMatrix BattleShip");//Labels the screen
         frame.setSize(1250, 1000);//Size of frame
         frame.setLocation(0, 0);//position of upper left corner
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes program when i exit
         frame.setContentPane(new BattleShipMedley());//uses battleship medley
         frame.setVisible(true);//You can see it
      }
   }