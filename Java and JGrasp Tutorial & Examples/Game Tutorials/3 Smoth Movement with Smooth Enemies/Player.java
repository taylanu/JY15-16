import javax.swing.*;

public class Player {
    private static final int UP = 0;        //movement directions to use as index for moveDir array
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private String name;
    private ImageIcon picture;
    private int row;            //start row for the player
    private int col;            //start col for the player
    private int moveIncrX;    //pixel increment for transitioning between array coordinates
    private int moveIncrY;    //pixel increment for transitioning between array coordinates
    private int tempX;    //save locations for graphic position of where the player is to be used to draw the player in motion when transitioning from one cell to another
    private int tempY;
    private boolean[] moveDir;    //flags to know which direction we want to move


    public Player(String n, int r, int c, String image) {
        name = n;
        picture = new ImageIcon(image);
        row = r;
        col = c;
        moveIncrX = 0;
        moveIncrY = 0;
        tempX = 0;
        tempY = 0;
        moveDir = new boolean[4];                            //reset movement flags and increments
        for (int i = 0; i < moveDir.length; i++)
            moveDir[i] = false;
    }

    public void clearDirections() {
        for (int i = 0; i < moveDir.length; i++)
            moveDir[i] = false;
    }

    //pre:  dir is 0,1,2,3 or 4
    public void setDirection(int dir) {
        for (int i = 0; i < moveDir.length; i++)
            moveDir[i] = false;
        if (dir >= 0 && dir < moveDir.length)
            moveDir[dir] = true;
    }

    //pre: dir is "up", "right", "down" or "left"
    public void setDirection(String dir) {
        for (int i = 0; i < moveDir.length; i++)
            moveDir[i] = false;
        if (dir.equals("up"))
            moveDir[UP] = true;
        else if (dir.equals("right"))
            moveDir[RIGHT] = true;
        else if (dir.equals("down"))
            moveDir[DOWN] = true;
        else if (dir.equals("left"))
            moveDir[LEFT] = true;
    }

    public boolean isMoving() {
        for (int i = 0; i < moveDir.length; i++)
            if (moveDir[i])
                return true;
        return false;
    }

    public boolean isMovingUp() {
        return moveDir[UP];
    }

    public boolean isMovingRight() {
        return moveDir[RIGHT];
    }

    public boolean isMovingDown() {
        return moveDir[DOWN];
    }

    public boolean isMovingLeft() {
        return moveDir[LEFT];
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public int getMoveIncrX() {
        return moveIncrX;
    }

    public void setMoveIncrX(int x) {
        moveIncrX = x;
    }

    public int getMoveIncrY() {
        return moveIncrY;
    }

    public void setMoveIncrY(int y) {
        moveIncrY = y;
    }

    public void addMoveIncrX(int x) {
        moveIncrX += x;
    }

    public void addMoveIncrY(int y) {
        moveIncrY += y;
    }

    public void setCoord(int r, int c) {
        row = r;
        col = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        col = c;
    }

    public int getTempX() {
        return tempX;
    }

    public void setTempX(int x) {
        tempX = x;
    }

    public int getTempY() {
        return tempY;
    }

    public void setTempY(int y) {
        tempY = y;
    }

    //pre:  SIZE is the pixel size of the player
    //post: returns the actual x coordinate in pixel space
    public int findX(int SIZE) {
        return (SIZE * this.getCol()) + this.getMoveIncrX();
    }

    //pre:  SIZE is the pixel size of the player
    //post: returns the actual y coordinate in pixel space
    public int findY(int SIZE) {
        return (SIZE * this.getRow()) + this.getMoveIncrY();
    }

}