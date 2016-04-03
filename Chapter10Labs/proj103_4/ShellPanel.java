package proj103_4;

//Jered Tupik - 11/16/2012
   import java.awt.*;
   import javax.swing.*;

   public class ShellPanel extends JPanel{

      private Rectangle r;
      private Circle c;
      private Wheel w;
      private Triangle t;

   //DEFAULT CONSTRUCTOR
      public ShellPanel(){
         r = new Rectangle(350, 350, 100, 50);
         c = new Circle(300, 300, 50);
         w = new Wheel(150, 150, 100, 20);
         t = new Triangle(200,400,200, 200, 30, 25);
      }

      @Override
	public void paintComponent(Graphics g){
         r.draw(g);
         c.draw(g);
         w.draw(g);
         t.draw(g);
      }
   }