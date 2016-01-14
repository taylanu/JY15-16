package proj104;

 //Jered Tupik - 11/15/2012
// Taylan Unal - 1/13/16
   import java.awt.*;

   public class Wheel extends Circle{
   
   //Data Fields
      private int spokes;
   
   //DEFAULT CONSTRUCTOR
      public Wheel(){
      
         super();
         spokes = 2;
      }
   
   //CUSTOM CONSTRUCTOR
      public Wheel(double xP, double yP, double r, int s){
         super(xP, yP, r);
         if(s == 360){
            spokes = 360;
         }
         else{
            spokes = s % 360;
         }
      }
   
   //@Override
      public String toString(){
         String data = "";
         data = "Wheel" + "\nRadius: " + radius + "\nSpokes: " + spokes + "\n(X, Y)Position: ("
             + this.getXPos() + ", " + this.getYPos() + ")" + " " + "\nArea: " + this.area();
         return data;
      }
   
      public int getSpokes(){
         return spokes;
      }
   
      public void setSpokes(int s){
         if(s == 360){
            spokes = 360;
         }
         else{
            spokes = s % 360;
         }
      }
   
   //Pre: G != null, Spokes != null, xPos != null, yPos != null
   //Post: Draws the Wheel
      public void draw(Graphics g){
         super.draw(g);
         for(int i = 0; i <= 360; i = i + (360 / spokes)){
            if(i != 0){
               double angle = Math.toRadians(i);
               int currRadius = (int)this.getRadius() / 2;
               double endX = this.getXPos() + (currRadius) * Math.cos(angle);
               double endY = this.getYPos() + (currRadius) * Math.sin(angle);
               g.drawLine((int)(this.getXPos() + currRadius), (int)(this.getYPos() + currRadius), (int)(endX + currRadius), (int)(endY + currRadius));
            }
         }
      }
   }