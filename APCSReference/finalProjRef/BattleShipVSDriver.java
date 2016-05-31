   import javax.swing.JFrame;
   public class BattleShipVSDriver
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("SparseMatrix BattleShip 2-Player");
         frame.setSize(1250, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BattleShipVS());
         frame.setVisible(true);
      }
   }