import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyGridExample extends JPanel {
    public static final int BULLET_LIMIT = 10;    //total # bullets that can be fired on the screen at one time
    protected static final int UP = 0;        //movement directions to use as index for moveDir array
    protected static final int RIGHT = 1;
    protected static final int DOWN = 2;
    protected static final int LEFT = 3;
    private static final int SIZE = 40;    //size of cell being drawn
    private static final int DELAY = 10;    //#miliseconds delay between each time the enemy moves and screen refreshes for the timer
    private static final int SPEED = 1;    //when the crosshair moves from one cell to the next, this is how many pixels they move in each frame (designated by the timer)
    private static final int ANIMATION_DELAY = 10;    //the speed at which the animations occur for the enemies
    private static final int bulletPower = 20;    //the power of the bullet (10 to kill enemies, 20 to destroy walls)
    private static final boolean CONSTANT_MOVEMENT = true;    //do we want our motion to be constant?
    private static int screenWidth;        //size of the screen in pixels
    private static int screenHeight;
    //This array will be represented graphically on the screen
    private static int[][] board;            //we will fill with 0s, 1s, and 2s
    private static Player[] enemies;    //array of enemy objects
    private static Human player;            //player controlled crosshairs
    private static ArrayList<Bullet> bullets;        //bullets fired by the user
    private static String[][] bulletImages;        //array of bullet images (direction X animation frames)
    private static ArrayList<Explosion> explosions;    //active explosions to show on the screen
    private static String[][] explosionImages;        //array of explosion images (direction X animation frames)
    //images to use to represent array values
    private ImageIcon blank = new ImageIcon("images/blank.jpg");                //for array value 0
    private ImageIcon white = new ImageIcon("images/white.jpg");                //for array value 1
    private ImageIcon wall = new ImageIcon("images/brick.jpg");                    //for array value 2
    //toggle this to false if you want your player to stop at each change of cell location
    private Timer t;                            //used to set the speed of the enemy that moves around the screen

    public MyGridExample() {
        bullets = new ArrayList();
        bulletImages = new String[4][4];

        explosions = new ArrayList();
        explosionImages = new String[1][4];                //explosions only have one direction, but 4 animation frames

        int numRows = 15;//(int)(Math.random()*13)+3;		//array has a random size
        int numColumns = 15;//(int)(Math.random()*13)+3;
        screenWidth = numColumns * SIZE;
        screenHeight = numRows * SIZE;

        board = new int[numRows][numColumns];
        for (int r = 0; r < board.length; r++)                    //fill with random values (0,1 or 2)
            for (int c = 0; c < board[0].length; c++)
                board[r][c] = (int) (Math.random() * 3);

        enemies = new Player[4];
        String[][] playerImages = new String[1][1];  //there is only one image to use for player
        String[][] enemyImages = new String[4][4];    //there are 4 direction dependant images for the enemies
        //and	each direction has 4 animation frames
        loadImages(playerImages, enemyImages);

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Player("Enemy" + i, 0, 0, enemyImages, ANIMATION_DELAY);
        }
        player = new Human("US", (screenWidth / 2) - (SIZE / 2), (screenHeight / 2) - (SIZE / 2), playerImages, ANIMATION_DELAY);

        t = new Timer(DELAY, new Listener());            //the higher the value of DELAY, the slower the enemy will move
        t.start();

    }

    //pre:  all arguments are valid pixel coordinates >= 1 && <= screen size
    //post: returns the distance between the two points to see if there is a collision between enemies
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    //post:	resolves collisions between bullets and enemies, as well as collisions between enemies and the player
    //			returns true if there is a collsion and resets the player back to the center, enemies are sent back to the corner
    public static boolean checkCollsions() {
        if (player == null)
            return false;
        int x1 = player.getX();    //these return the x and y coordinate in pixel space of the player
        int y1 = player.getY();
        for (int i = 0; i < enemies.length; i++) {
            Player curr = enemies[i];
            int x2 = curr.findX(SIZE);        //these return the x and y coordinate in pixel space of the player
            int y2 = curr.findY(SIZE);

            for (int j = 0; j < bullets.size(); j++)        //see if bullets hit any enemies
            {
                Bullet shot = bullets.get(j);
                int sX = shot.getX();
                int sY = shot.getY();
                if (distance(sX, sY, x2, y2) <= (SIZE / 2)) {
                    explosions.add(new Explosion("HIT", x2 - (SIZE / 2), y2 - (SIZE / 2), explosionImages, ANIMATION_DELAY));
                    bullets.remove(j);                    //remove bullet that struck enemy
                    j--;
                    curr.setRow(0);                        //reset the enemy's position
                    curr.setCol(0);
                    curr.clearDirections();
                    if (bullets.size() == 0)
                        break;
                    else
                        continue;
                }
            }

            if (distance(x1, y1, x2, y2) <= (SIZE / 2)) {
                player.setX((screenWidth / 2) - (SIZE / 2));
                player.setY((screenHeight / 2) - (SIZE / 2));
                player.clearDirections();
            }
        }
        return false;
    }

    public void loadImages(String[][] playerImages, String[][] enemyImages) {
        playerImages[0][0] = "images/player.GIF";

        enemyImages[UP][0] = "images/enemy/enemyUp0.GIF";
        enemyImages[RIGHT][0] = "images/enemy/enemyRight0.GIF";
        enemyImages[DOWN][0] = "images/enemy/enemyDown0.GIF";
        enemyImages[LEFT][0] = "images/enemy/enemyLeft0.GIF";

        enemyImages[UP][1] = "images/enemy/enemyUp1.GIF";
        enemyImages[RIGHT][1] = "images/enemy/enemyRight1.GIF";
        enemyImages[DOWN][1] = "images/enemy/enemyDown1.GIF";
        enemyImages[LEFT][1] = "images/enemy/enemyLeft1.GIF";

        enemyImages[UP][2] = "images/enemy/enemyUp2.GIF";
        enemyImages[RIGHT][2] = "images/enemy/enemyRight2.GIF";
        enemyImages[DOWN][2] = "images/enemy/enemyDown2.GIF";
        enemyImages[LEFT][2] = "images/enemy/enemyLeft2.GIF";

        enemyImages[UP][3] = "images/enemy/enemyUp3.GIF";
        enemyImages[RIGHT][3] = "images/enemy/enemyRight3.GIF";
        enemyImages[DOWN][3] = "images/enemy/enemyDown3.GIF";
        enemyImages[LEFT][3] = "images/enemy/enemyLeft3.GIF";

        bulletImages[UP][0] = "images/bullet/bulletUp0.GIF";
        bulletImages[RIGHT][0] = "images/bullet/bulletRight0.GIF";
        bulletImages[DOWN][0] = "images/bullet/bulletDown0.GIF";
        bulletImages[LEFT][0] = "images/bullet/bulletLeft0.GIF";

        bulletImages[UP][1] = "images/bullet/bulletUp1.GIF";
        bulletImages[RIGHT][1] = "images/bullet/bulletRight1.GIF";
        bulletImages[DOWN][1] = "images/bullet/bulletDown1.GIF";
        bulletImages[LEFT][1] = "images/bullet/bulletLeft1.GIF";

        bulletImages[UP][2] = "images/bullet/bulletUp2.GIF";
        bulletImages[RIGHT][2] = "images/bullet/bulletRight2.GIF";
        bulletImages[DOWN][2] = "images/bullet/bulletDown2.GIF";
        bulletImages[LEFT][2] = "images/bullet/bulletLeft2.GIF";

        bulletImages[UP][3] = "images/bullet/bulletUp3.GIF";
        bulletImages[RIGHT][3] = "images/bullet/bulletRight3.GIF";
        bulletImages[DOWN][3] = "images/bullet/bulletDown3.GIF";
        bulletImages[LEFT][3] = "images/bullet/bulletLeft3.GIF";

        explosionImages[0][0] = "images/explosion/explosion0.GIF";
        explosionImages[0][1] = "images/explosion/explosion1.GIF";
        explosionImages[0][2] = "images/explosion/explosion2.GIF";
        explosionImages[0][3] = "images/explosion/explosion3.GIF";

    }

    //post:  shows different pictures on the screen in grid format depending on the values stored in the array board
    //			0-blank, 1-white, 2-black and gives priority to drawing the player
    public void showBoard(Graphics g) {
        int x = 0, y = 0;        //upper left corner location of where image will be drawn
        for (int r = 0; r < board.length; r++) {
            x = 0;            //reset the row distance
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0)
                    g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);
                else if (board[r][c] == 1)
                    g.drawImage(white.getImage(), x, y, SIZE, SIZE, null);
                else // if(board[r][c]==2)
                    g.drawImage(wall.getImage(), x, y, SIZE, SIZE, null);
                x += SIZE;
            }
            y += SIZE;
        }
        for (int i = 0; i < bullets.size(); i++)                    //draw any bullets on the screen
        {
            Bullet curr = bullets.get(i);
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.getX(), curr.getY(), SIZE, SIZE, null);  //scaled image
        }
        for (int i = 0; i < explosions.size(); i++)                //draw any explosions on the screen
        {
            int picSize = SIZE;
            Explosion curr = explosions.get(i);
            if (curr.getName().equals("HIT"))                    //draw a larger explosion if you hit an enemy
                picSize *= 2;
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.getX(), curr.getY(), picSize, picSize, null);  //scaled image
            if (curr.getAnimationIndex() >= explosionImages[0].length - 1)    //remove expired explosions
            {
                explosions.remove(i);
                i--;
            }
        }
        //show where all the enemies are
        for (int i = 0; i < enemies.length; i++) {
            Player curr = enemies[i];
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.findX(SIZE), curr.findY(SIZE), SIZE, SIZE, null);  //scaled image
        }
        g.drawImage(player.getPictureAndAdvance().getImage(), player.getX(), player.getY(), SIZE, SIZE, null);
    }

    //THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
    //pre:   k is a valid keyCode
    //post:  changes the enemies position depending on the key that was pressed (sent from the driver)
    //			keeps the player in the bounds of the size of the array board, then the enemy moves
    public void processUserInput(int k) {
        if (k == KeyEvent.VK_Q || k == KeyEvent.VK_ESCAPE)                    //End the program
            System.exit(1);
        if (player == null)
            return;

        Human curr = player;        //person playing the game

        if (k == KeyEvent.VK_W || k == KeyEvent.VK_A || k == KeyEvent.VK_S || k == KeyEvent.VK_D)    //we are shooting with W, A, S or D
        {
            Bullet temp = null;
            if (k == KeyEvent.VK_W) {
                temp = new Bullet("UP", curr.getX(), curr.getY(), bulletPower, bulletImages, SPEED);
                temp.setDirection(UP);
            } else if (k == KeyEvent.VK_D) {
                temp = new Bullet("RIGHT", curr.getX(), curr.getY(), bulletPower, bulletImages, SPEED);
                temp.setDirection(RIGHT);
            } else if (k == KeyEvent.VK_S) {
                temp = new Bullet("DONW", curr.getX(), curr.getY(), bulletPower, bulletImages, SPEED);
                temp.setDirection(DOWN);
            } else if (k == KeyEvent.VK_A) {
                temp = new Bullet("LEFT", curr.getX(), curr.getY(), bulletPower, bulletImages, SPEED);
                temp.setDirection(LEFT);
            }
            if (temp != null)
                bullets.add(temp);
            if (bullets.size() > BULLET_LIMIT)    //remove earliest fired bullet if we have more than the bullet limit
            {
                explosions.add(new Explosion("MISS", bullets.get(0).getX(), bullets.get(0).getY(), explosionImages, ANIMATION_DELAY));
                bullets.remove(0);
            }
            repaint();
            return;
        }

        curr.clearDirections();
        if (k == KeyEvent.VK_UP)
            curr.setDirection(UP);
        else if (k == KeyEvent.VK_DOWN)
            curr.setDirection(DOWN);
        else if (k == KeyEvent.VK_LEFT)
            curr.setDirection(LEFT);
        else if (k == KeyEvent.VK_RIGHT)
            curr.setDirection(RIGHT);
        repaint();            //refresh the screen
    }

    //post:  move player and enemies across the screen smoothly
    public void movePlayerSmoothly() {
        tryToMove(player);

        for (int i = 0; i < enemies.length; i++) {
            Player curr = enemies[i];
            if (Math.abs(curr.getMoveIncrX()) >= SIZE || Math.abs(curr.getMoveIncrY()) >= SIZE) {
                if (curr.isMovingUp() && curr.getRow() > 0 && board[curr.getRow() - 1][curr.getCol()] != 2)
                    curr.setRow(curr.getRow() - 1);
                else if (curr.isMovingDown() && curr.getRow() < board.length - 1 && board[curr.getRow() + 1][curr.getCol()] != 2)
                    curr.setRow(curr.getRow() + 1);
                else if (curr.isMovingLeft() && curr.getCol() > 0 && board[curr.getRow()][curr.getCol() - 1] != 2)
                    curr.setCol(curr.getCol() - 1);
                else if (curr.isMovingRight() && curr.getCol() < board[0].length - 1 && board[curr.getRow()][curr.getCol() + 1] != 2)
                    curr.setCol(curr.getCol() + 1);
                curr.clearDirections();
            } else {
                if (curr.isMovingUp() && curr.getRow() > 0)
                    curr.addMoveIncrY(-1 * SPEED);
                else if (curr.isMovingDown() && curr.getRow() < board.length - 1)
                    curr.addMoveIncrY(SPEED);
                else if (curr.isMovingLeft() && curr.getCol() > 0)
                    curr.addMoveIncrX(-1 * SPEED);
                else if (curr.isMovingRight() && curr.getCol() < board[0].length - 1)
                    curr.addMoveIncrX(SPEED);
            }
        }
    }

    //pre:  curr != null
    //post: see if there is an obstacle (or border) in the direciton the player is moving
    //		 if there is no obstacle or border, move them SPEED pixels in the direction they are moving
    public void tryToMove(Human curr) {
        int buffer = (int) (SIZE * .25);

        if ((curr.isMovingLeft() && curr.getX() - SPEED < 0) || (curr.isMovingUp() && curr.getY() - SPEED < 0)
                || (curr.isMovingRight() && curr.getX() + SPEED > ((board[0].length - 1) * SIZE))
                || (curr.isMovingDown() && curr.getY() + SPEED > ((board.length - 1) * SIZE))) {
            curr.clearDirections();
            return;
        }
        int currX = curr.getX();
        int currY = curr.getY();
        int width = (int) (SIZE);
        int height = (int) (SIZE);
        if (curr.isMovingDown())
            currY += (SPEED);
        else if (curr.isMovingRight())
            currX += (SPEED);
        else if (curr.isMovingUp())
            currY -= (SPEED);
        else if (curr.isMovingLeft())
            currX -= (SPEED);
        Rectangle currBox = new Rectangle(currX, currY, width, height);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 2) {
                    int bX = SIZE * c;
                    int bY = SIZE * r;
                    Rectangle obstacle = new Rectangle(bX + buffer, bY + buffer, SIZE - buffer * 2, SIZE - buffer * 2);
                    if (currBox.intersects(obstacle)) {
                        curr.clearDirections();
                        return;
                    }
                }
            }
        }
        if (curr.isMovingUp())
            curr.setY(curr.getY() - SPEED);
        else if (curr.isMovingDown())
            curr.setY(curr.getY() + SPEED);
        else if (curr.isMovingLeft())
            curr.setX(curr.getX() - SPEED);
        else if (curr.isMovingRight())
            curr.setX(curr.getX() + SPEED);

    }


    //post:  enemy moves to one of 4 adjacent places around it
    public void makeEnemyMove() {    //all enemies here are enemies
        for (int i = 0; i < enemies.length; i++) {
            Player curr = enemies[i];
            if (curr.isMoving())
                continue;
            curr.clearDirections();

            int rand = (int) (Math.random() * 4);

            if (rand == UP && curr.getRow() > 0 && board[curr.getRow() - 1][curr.getCol()] != 2)
                curr.setDirection(UP);
            else if (rand == DOWN && curr.getRow() < board.length - 1 && board[curr.getRow() + 1][curr.getCol()] != 2)
                curr.setDirection(DOWN);
            else if (rand == LEFT && curr.getCol() > 0 && board[curr.getRow()][curr.getCol() - 1] != 2)
                curr.setDirection(LEFT);
            else if (rand == RIGHT && curr.getCol() < board[0].length - 1 && board[curr.getRow()][curr.getCol() + 1] != 2)
                curr.setDirection(RIGHT);
        }
    }

    //post:  returns if a bullet should be removed because it is out of bounds (or hit an obstacle
    public boolean outOfBounds(Bullet curr) {
        if (curr.getX() < 0 || curr.getY() < 0 || curr.getX() >= (board[0].length * SIZE) || curr.getY() >= (board.length * SIZE))
            return true;
        int cX = curr.getX();
        int cY = curr.getY();
        for (int r = 0; r < board.length; r++)        //see if there is a wall that stops the bullet
        {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 2) {
                    int bX = (SIZE * c);
                    int bY = (SIZE * r);
                    if (distance(cX, cY, bX, bY) <= (SIZE / 2)) {
                        if (curr.getPower() == 20)        //destroy the wall if the bullet is powerful enough
                            board[r][c] = 0;
                        return true;
                    }

                }
            }
        }
        return false;
    }

    //post:  move active bullets across the screen, remove inactive(out of bouonds) bullets
    public void moveBullets() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet curr = bullets.get(i);
            if (outOfBounds(curr)) {    //remove any bullets that travel off the screen
                explosions.add(new Explosion("MISS", curr.getX(), curr.getY(), explosionImages, ANIMATION_DELAY));
                bullets.remove(i);
                i--;
                continue;
            }
            if (curr.isMovingUp())
                curr.setY(curr.getY() - (SPEED * 2));
            else if (curr.isMovingDown())
                curr.setY(curr.getY() + (SPEED * 2));
            else if (curr.isMovingLeft())
                curr.setX(curr.getX() - (SPEED * 2));
            else if (curr.isMovingRight())
                curr.setX(curr.getX() + (SPEED * 2));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);        //draw a blue boarder around the board
        g.fillRect(0, 0, (board[0].length * SIZE), (board.length * SIZE));
        showBoard(g);                    //draw the contents of the array board on the screen
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            movePlayerSmoothly();
            makeEnemyMove();
            moveBullets();
            checkCollsions();
            repaint();
        }
    }

}
