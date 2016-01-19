package proj104;

//Jered Tupik - 11/16/2012
//Taylan Unal - 1/19/16
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
         t = new Triangle(1,1.5,4,5.2,3.4,5.1,7,6);
      }
   
      public void paintComponent(Graphics g){
         r.draw(g);
         c.draw(g);
         w.draw(g);
         t.draw(g);
      }
   }