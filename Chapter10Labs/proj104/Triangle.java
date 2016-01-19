package proj104;

import java.awt.Graphics;

//Taylan Unal 1/15/16

public class Triangle extends AbstractShape{

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stretchBy(double Factor) {
		// TODO Auto-generated method stub
		
	}
	   //Data Fields
    private double base;
    private double height;
 
 //DEFAULT CONSTRUCTOR
    public Triangle(){
    
       super();
       base = 1;
       height = 1;
    }
 
 //CUSTOM CONSTRUCTOR
    public Triangle(double xP, double yP, double xP2, double yP2, double xP3, double yP3, double B, double H){
    
       super(xP, yP);
       base = B;
       height = H;
    }
 
 //@Override
    public String toString(){
       String data = "";
       data = data + "Rectangle" + "\nWidth: " + base + "\nHeight: " + height + "\n" + super.toString();
       return data;
    }
 
    public double getBase(){
       return base;
    }
 
    public void setBase(double b){
       base = b;
    }
 
    public double getHeight(){
       return height;
    }
 
    public void setHeight(double h){
       height = h;
    }
    //Proj103 ADDED
    //Pre: Width != null, Height != null
    //Post: Returns the Perimeter of a Rectangle
       public double perimeter(){
     	  return 2*(base*height);
       }
 
 /*//Pre: Width != null, Height != null
 //Post: Returns the Area of a Rectangle
    public double area(){
       return width * height;
    }
  */  

 /*
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
*/
}
