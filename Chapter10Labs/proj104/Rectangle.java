package proj104;

//Jered Tupik - 11/15/2012
//Taylan Unal - 1/13/16
   import java.awt.*;

   public class Rectangle extends AbstractShape{
   
   //Data Fields
      private double width;
      private double height;
   
   //DEFAULT CONSTRUCTOR
      public Rectangle(){
      
         super();
         width = 1;
         height = 1;
      }
   
   //CUSTOM CONSTRUCTOR
      public Rectangle(double xP, double yP, double W, double H){
      
         super(xP, yP);
         width = W;
         height = H;
      }
   
   //@Override
      public String toString(){
         String data = "";
         data = data + "Rectangle" + "\nWidth: " + width + "\nHeight: " + height + "\n" + super.toString();
         return data;
      }
   
      public double getWidth(){
         return width;
      }
   
      public void setWidth(double w){
         width = w;
      }
   
      public double getHeight(){
         return height;
      }
   
      public void setHeight(double h){
         height = h;
      }
   
   
   //Pre: Width != null, Height != null
   //Post: Returns the Area of a Rectangle
      public double area(){
         return width * height;
      }
      
   //Proj103 ADDED
   //Pre: Width != null, Height != null
   //Post: Returns the Perimeter of a Rectangle
      public double perimeter(){
    	  return 2*(width*height);
      }
   
   //Pre: G != null, Width != null, Height != null, xPos != null, yPos != null
   //Post: Draws the Rectangle
      public void draw(Graphics G){
         G.drawLine((int)this.getXPos(), (int)this.getYPos(), (int)(this.getXPos() + width), (int)this.getYPos());
         G.drawLine((int)this.getXPos(), (int)this.getYPos(), (int)this.getXPos(), (int)(this.getYPos() + height));
         G.drawLine((int)(this.getXPos() + width), (int)this.getYPos(), (int)(this.getXPos() + width), (int)(this.getYPos() + height));
         G.drawLine((int)this.getXPos(), (int)(this.getYPos() + height), (int)(this.getXPos() + width), (int)(this.getYPos() + height));
      }
   
   //Pre: Factor != null
   //Post: 'Stretches' the Rectangle by Factor
      public void stretchBy(double factor){
         height += factor;
         width += factor;
      }
   }