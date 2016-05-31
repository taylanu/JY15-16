import javax.swing.JFrame;
public class BattleShipAIDriver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("SparseMatrix BattleShip VS Computer");//What will the frame say
      frame.setSize(1250, 1000);//how big will it be
      frame.setLocation(0,0);//Where will the top left corner be
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//allows you to close it
      frame.setContentPane(new BattleShipAI());//uses a BattleShipAI
      frame.setVisible(true);//You can see it
   }
}
