package proj103_4;

import java.awt.Graphics;

//Taylan Unal 1/15/16

public class Triangle extends AbstractShape implements Shapeable{
	   //Data Fields
	private double base;
 	private double height;
	private double x1; private double x2; private double x3;
	private double y1; private double y2; private double y3;

	 //DEFAULT CONSTRUCTOR
    public Triangle(){
       super();
       x2 = 1;
       y2 = 0;
       x3 = 0;
       y3 = 1;
    }

 //CUSTOM CONSTRUCTOR
    public Triangle(double Px1, double Py1, double Px2, double Py2, double Px3, double Py3){
       super(Px1, Py1);
       x2 = Px2;
       y2 = Py2;
       x3 = Px3;
       y3 = Py3;
    }

	public double area() {
		return (Math.abs((xPos * y2) - (x2 * yPos) + (x2 * y3) - (x3 * y2) + (x3 * yPos) - (xPos * y3)))/2;
	}

	   public void draw(Graphics G){//drawLine is method called from java.awt.Graphics.
	      G.drawLine((int)xPos,(int)yPos,(int)x2,(int)y2);
	      G.drawLine((int)x2,(int)y2,(int)x3,(int)y3);
	      G.drawLine((int)x3,(int)y3,(int)xPos,(int)yPos);
	   }

	public void stretchBy(double Factor) {
	      x2 = xPos + (x2 - xPos) * Factor;
	      y2 = yPos + (y2 - yPos) * Factor;
	      x3 = xPos + (x3 - xPos) * Factor;
	      y3 = yPos + (y3 - yPos) * Factor;
	}

	public String toString(){
       String data ="Point 1 is at:" + super.toString() + "\nPoint 2 is at:\t(" + x2 + "," + y2 + ")\nPoint 3 is at\t (" + x3 + "," + y3 + ")\nThe Perimeter is:\t" + perimeter();
       return data;
    }

    private double perimeter() {
    	double d1 = distance(xPos, yPos, x2, y2);//Side 1
        double d2 = distance(x2, y2, x3, y3);//Side 2
        double d3 = distance(x3, y3, xPos, yPos);//Side 3
        return d1 + d2 + d3;
	}

	//Base and Height Methods//
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
    //DISTANCE FORMULA
    public double distance(double x1, double y1, double x2, double y2){
       return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
