//Jered Tupik - 11/15/2012
   import java.awt.*;

   public abstract class AbstractShape implements Shapeable
   {
   //Data Fields
      protected double xPos;
      protected double yPos;
   
   //DEFAULT CONSTRUCTOR
      public AbstractShape(){
      
         xPos = 0;
         yPos = 0;
      }
   
   //CUSTOM CONSTRUCTOR
      public AbstractShape(double xP, double yP){
      
         xPos = xP;
         yPos = yP;
      }
   
   //@Override
      public String toString(){
         String Info = "";
         Info = "(X, Y)Position: (" + xPos + ", " + yPos + ")" + "\nArea: " + area();
         return Info;
      }
   
      public abstract double area();
   
      public abstract void draw(Graphics G);
   
      public abstract void stretchBy(double Factor);
   
      public double getXPos(){
         return xPos;
      }
   
      public void setXPos(double xP){
         xPos = xP;
      }
   
      public double getYPos(){
         return yPos;
      }
   
      public void setYPos(double yP){
         yPos = yP;
      }
   
      public void move(double xLoc, double yLoc){
         xPos = xLoc;
         yPos = yLoc;
      }
   }