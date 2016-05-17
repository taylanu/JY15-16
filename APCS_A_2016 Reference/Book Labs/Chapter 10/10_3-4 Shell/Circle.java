//Jered Tupik - 11/15/2012

import java.awt.*;

public class Circle extends AbstractShape {

    //Data Fields
    protected double radius;

    //DEFAULT CONSTRUCTOR
    public Circle() {

        super();
        radius = 1;
    }

    //CUSTOM CONSTRUCTOR
    public Circle(double xP, double yP, double r) {

        super(xP, yP);
        radius = r;
    }

    //@Override
    public String toString() {
        String data = "";
        data = data + "Circle" + "\nRadius: " + radius + "\n" + super.toString();
        return data;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        radius = r;
    }

    //Pre: Radius != null
//Post: Returns the Area of the Circle
    public double area() {
        return Math.PI * (radius * radius);
    }

    //Pre: G != null, Radius != null
//Post: Draws the Circle
    public void draw(Graphics g) {
        g.drawOval((int) this.getXPos(), (int) this.getYPos(), (int) radius, (int) radius);
    }

    //Pre: Factor != null
//Post: 'Stretches' the Circle by Factor
    public void stretchBy(double factor) {
        radius *= factor;
    }
}