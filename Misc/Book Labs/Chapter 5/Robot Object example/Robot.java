public class Robot            //in Robot.java
{
    private int xPos, yPos;            //position
    private String dir;            //direction

    public Robot()                //default constructor
    {
        xPos = 1;
        yPos = 1;
        dir = "EAST";
    }

    public Robot(int x, int y, String d)    //constructor
    {
        xPos = x;
        yPos = y;
        dir = d;
    }

    public int getX()            //accessor methods
    {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public String getDir() {
        return dir;
    }

    public String toString() {
        return "(" + xPos + "," + yPos + "):" + dir;
    }

    public void turnLeft() {
        if (dir.equals("NORTH"))
            dir = "WEST";
        else if (dir.equals("WEST"))
            dir = "SOUTH";
        else if (dir.equals("SOUTH"))
            dir = "EAST";
        else
            dir = "NORTH";
    }

    public void move() {
        if (dir.equals("NORTH"))
            yPos++;
        else if (dir.equals("WEST") && xPos > 1)
            xPos--;
        else if (dir.equals("SOUTH") && yPos > 1)
            yPos--;
        else if (dir.equals("EAST"))
            xPos++;
    }
}