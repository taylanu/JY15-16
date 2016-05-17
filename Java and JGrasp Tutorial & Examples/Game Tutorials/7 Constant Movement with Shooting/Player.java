public class Player extends Entity {
    private int row;            //start row for the player
    private int col;            //start col for the player

    private int moveIncrX;    //pixel increments for transitioning between array coordinates
    private int moveIncrY;

    private int tempX;        //save locations for graphic position of where the player is
    private int tempY;        //to be used to draw the player in motion when transitioning from one cell to another


    //pre: 	r and c must be valid indecies of the board in MyGridExample
    //			image must at least be of size 1 x 1 and contain String values of image file names
    //			ad >= 1
    public Player(String n, int r, int c, String[][] image, int ad) {
        super(n, 0, 0, image, ad);

        row = r;
        col = c;
        moveIncrX = 0;
        moveIncrY = 0;
        tempX = 0;
        tempY = 0;
    }

    public void clearDirections() {
        super.clearDirections();
        moveIncrX = 0;
        moveIncrY = 0;
    }

    //pre:  SIZE is the pixel size of the player
    //post: returns the actual x coordinate in pixel space
    public int findX(int SIZE) {
        setX((SIZE * this.getCol()) + this.getMoveIncrX());
        return getX();
    }

    //pre:  SIZE is the pixel size of the player
    //post: returns the actual y coordinate in pixel space
    public int findY(int SIZE) {
        setY((SIZE * this.getRow()) + this.getMoveIncrY());
        return getY();
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
}