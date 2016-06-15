   import javax.swing.JFrame;
   public class BattleShipDriver
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("SparseMatrix BattleShip");
         frame.setSize(1250, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BattleShip());
         frame.setVisible(true);
      }
   }