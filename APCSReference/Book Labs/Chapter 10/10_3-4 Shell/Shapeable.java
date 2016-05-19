//Jered Tupik - 11/15/2012

import java.awt.*;

public interface Shapeable {
    public double area();

    public void draw(Graphics G);

    public double getXPos();

    public double getYPos();

    public void move(double xLoc, double yLoc);

    public void stretchBy(double Factor);

    public String toString();
}