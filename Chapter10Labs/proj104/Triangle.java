package proj104;

import java.awt.Graphics;

//Taylan Unal 1/15/16

public class Triangle extends AbstractShape implements Shapeable{

	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void draw(Graphics G) {
		// TODO Auto-generated method stub
		
	}

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
