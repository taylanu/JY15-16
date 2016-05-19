import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyGridExample extends JPanel {
    public static final int BULLET_LIMIT = 10;    //total # bullets that can be fired on the screen at one time
    private static final int SIZE = 40;    //size of cell being drawn
    private static final int DELAY = 10;    //#miliseconds delay between each time the enemy moves and screen refreshes for the timer
    private static final int SPEED = 1;    //when the crosshair moves from one cell to the next, this is how many pixels they move in each frame (designated by the timer)
    private static final int ANIMATION_DELAY = 10;    //the speed at which the animations occur for the players
    private static final int bulletPower = 20;    //the power of the bullet (10 to kill enemies, 20 to destroy walls)
    private static final int UP = 0;        //movement directions to use as index for moveDir array
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final boolean CONSTANT_MOVEMENT = true;    //do we want our motion to be constant?
    //This array will be represented graphically on the screen
    private static int[][] board;            //we will fill with 0s, 1s, and 2s
    private static Player[] players;    //array of player objects
    private static ArrayList<Bullet> bullets;        //bullets fired by the user
    private static String[][] bulletImages;        //array of bullet images (direction X animation frames)
    private static ArrayList<Explosion> explosions;    //active explosions to show on the screen
    private static String[][] explosionImages;        //array of explosion images (direction X animation frames)
    private static int lastInput;        //the latest command retrieved from the user
    //images to use to represent array values
    private ImageIcon blank = new ImageIcon("images/blank.jpg");                //for array value 0
    private ImageIcon white = new ImageIcon("images/white.jpg");                //for array value 1
    private ImageIcon wall = new ImageIcon("images/brick.jpg");                    //for array value 2
    //toggle this to false if you want your player to stop at each change of cell location
    private Timer t;                            //used to set the speed of the enemy that moves around the screen

    public MyGridExample() {
        lastInput = -1;

        bullets = new ArrayList();
        bulletImages = new String[4][4];

        explosions = new ArrayList();
        explosionImages = new String[1][4];                //explosions only have one direction, but 4 animation frames

        int numRows = 15;
        int numColumns = 15;
        board = new int[numRows][numColumns];
        for (int r = 0; r < board.length; r++)                    //fill with random values (0,1 or 2)
            for (int c = 0; c < board[0].length; c++)
                board[r][c] = (int) (Math.random() * 3);

        players = new Player[5];
        String[][] playerImages = new String[1][1];  //there is only one image to use for player
        String[][] enemyImages = new String[4][4];    //there are 4 direction dependant images for the enemies
        //and	each direction has 4 animation frames
        loadImages(playerImages, enemyImages);

        for (int i = 0; i < players.length; i++) {
            if (i == 0)                    //start player position in the middle
                players[i] = new Player("US", board.length / 2, board[0].length / 2, playerImages, ANIMATION_DELAY);
            else                        //start enemy in the upper left corner
                players[i] = new Player("Enemy" + i, 0, 0, enemyImages, ANIMATION_DELAY);
        }

        t = new Timer(DELAY, new Listener());            //the higher the value of DELAY, the slower the enemy will move
        t.start();

    }

    //pre:  all arguments are valid pixel coordinates >= 1 && <= screen size
    //post: returns the distance between the two points to see if there is a collision between players
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    //pre:   the human player is at index 0 of the player array
    //post:  returns true if there is a collsion and resets the player back to the center
    public static boolean checkCollsions() {
        if (players.length == 0 || players[0] == null)
            return false;
        int x1 = players[0].findX(SIZE);    //these return the x and y coordinate in pixel space of the player
        int y1 = players[0].findY(SIZE);
        for (int i = 1; i < players.length; i++) {
            Player curr = players[i];
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
                //System.out.println("COLLISION");
                players[0].setRow(board.length / 2);
                players[0].setCol(board[0].length / 2);
                lastInput = -1;
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
            x = 0;                        //reset the row distance
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0)
                    g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                else if (board[r][c] == 1)
                    g.drawImage(white.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                else // if(board[r][c]==2)
                    g.drawImage(wall.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                x += SIZE;
            }
            y += SIZE;
        }
        //show where all the players are
        for (int i = 0; i < players.length; i++) {
            Player curr = players[i];
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.findX(SIZE), curr.findY(SIZE), SIZE, SIZE, null);
        }
        for (int i = 0; i < bullets.size(); i++)                                //draw any bullets on the screen
        {
            Bullet curr = bullets.get(i);
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.getX(), curr.getY(), SIZE, SIZE, null);  //scaled image
        }
        for (int i = 0; i < explosions.size(); i++)                                //draw any explosions on the screen
        {
            int picSize = SIZE;
            Explosion curr = explosions.get(i);
            if (curr.getName().equals("HIT"))                                    //draw a larger explosion if you hit an enemy
                picSize *= 2;
            g.drawImage(curr.getPictureAndAdvance().getImage(), curr.getX(), curr.getY(), picSize, picSize, null);  //scaled image
            if (curr.getAnimationIndex() >= explosionImages[0].length - 1)    //remove expired explosions
            {
                explosions.remove(i);
                i--;
            }
        }

    }

    //THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
    //pre:   k is a valid keyCode
    //post:  changes the players position depending on the key that was pressed (sent from the driver)
    //			keeps the player in the bounds of the size of the array board, then the enemy moves
    public void processUserInput(int k) {
        if (k == KeyEvent.VK_Q || k == KeyEvent.VK_ESCAPE)                    //End the program
            System.exit(1);
        if (players.length == 0 || players[0] == null)
            return;

        Player curr = players[0];        //players[0] is person playing the game
        //cancel move order if we are already moving from one space to the next

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

        lastInput = k;

        if (curr.isMoving())
            return;
        curr.clearDirections();
        if (k == KeyEvent.VK_SPACE)    //toggle the value of the array at that position
            board[curr.getRow()][curr.getCol()] = (board[curr.getRow()][curr.getCol()] + 1) % 3;
        else if (k == KeyEvent.VK_UP && curr.getRow() > 0 && board[curr.getRow() - 1][curr.getCol()] != 2)
            curr.setDirection(UP);
        else if (k == KeyEvent.VK_DOWN && curr.getRow() < board.length - 1 && board[curr.getRow() + 1][curr.getCol()] != 2)
            curr.setDirection(DOWN);
        else if (k == KeyEvent.VK_LEFT && curr.getCol() > 0 && board[curr.getRow()][curr.getCol() - 1] != 2)
            curr.setDirection(LEFT);
        else if (k == KeyEvent.VK_RIGHT && curr.getCol() < board[0].length - 1 && board[curr.getRow()][curr.getCol() + 1] != 2)
            curr.setDirection(RIGHT);
        repaint();            //refresh the screen
    }

    public void movePlayerSmoothly() {
        for (int i = 0; i < players.length; i++) {
            Player curr = players[i];
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
                if (CONSTANT_MOVEMENT) {
                    if (lastInput != -1) {
                        if (lastInput == KeyEvent.VK_UP && curr.getRow() > 0 && board[curr.getRow() - 1][curr.getCol()] != 2)
                            curr.setDirection(UP);
                        else if (lastInput == KeyEvent.VK_DOWN && curr.getRow() < board.length - 1 && board[curr.getRow() + 1][curr.getCol()] != 2)
                            curr.setDirection(DOWN);
                        else if (lastInput == KeyEvent.VK_LEFT && curr.getCol() > 0 && board[curr.getRow()][curr.getCol() - 1] != 2)
                            curr.setDirection(LEFT);
                        else if (lastInput == KeyEvent.VK_RIGHT && curr.getCol() < board[0].length - 1 && board[curr.getRow()][curr.getCol() + 1] != 2)
                            curr.setDirection(RIGHT);
                    }
                }
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

    //enemy moves to one of 4 adjacent places around it - returns false if it doesnt move
    public void makeEnemyMove() {    //all players after index 0 are enemies
        for (int i = 1; i < players.length; i++) {
            Player curr = players[i];
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

    //post:  returns if a bullet should be removed because it is out of bounds (or hit an obstacle)
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
        public void actionPerformed(ActionEvent e)    //this is called for each timer iteration - make the enemy move randomly
        {
            movePlayerSmoothly();
            makeEnemyMove();
            moveBullets();
            checkCollsions();
            repaint();
        }
    }

}
