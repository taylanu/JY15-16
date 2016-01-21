package proj103_4;

//Jered Tupik - 11/15/2012
//Taylan Unal - 1/13/16
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
      @Override
	public String toString(){
         String Info = "";
         Info = "(X, Y)Position: (" + xPos + ", " + yPos + ")" + "\nArea: " + area();
         return Info;
      }
   
      @Override
	public abstract double area();
   
      @Override
	public abstract void draw(Graphics G);
   
      @Override
	public abstract void stretchBy(double Factor);
   
      @Override
	public double getXPos(){
         return xPos;
      }
   
      public void setXPos(double xP){
         xPos = xP;
      }
   
      @Override
	public double getYPos(){
         return yPos;
      }
   
      public void setYPos(double yP){
         yPos = yP;
      }
   
      @Override
	public void move(double xLoc, double yLoc){
         xPos = xLoc;
         yPos = yLoc;
      }
   }