package proj103_4;

import java.awt.Graphics;

//Taylan Unal 1/15/16

public class Triangle extends AbstractShape implements Shapeable{
	   //Data Fields
	private double base;
 	private double height;
	/*private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double x3;
	private double y3;*/
	
	 //DEFAULT CONSTRUCTOR
    public Triangle(){
       super();
       
    }
 
 //CUSTOM CONSTRUCTOR
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
    
       super(x1, y1);
       
    }
	   
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 1/2*base*height;
	}
	

	@Override
	   public void draw(Graphics G)
	   {
	      G.drawLine((int)xPos,(int)yPos,(int)x2,(int)y2);
	      G.drawLine((int)x2,(int)y2,(int)x3,(int)y3);
	      G.drawLine((int)x3,(int)y3,(int)xPos,(int)yPos);
	   }

	@Override
	public void stretchBy(double Factor) {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	public String toString(){
       String data = "";
       data = data + "Triangle" + "\nWidth: " + base + "\nHeight: " + height + "\n" + super.toString();
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
}
