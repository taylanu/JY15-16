//Rev. Dr. Douglas R Oberle, Sept 2013
//TO DO:
//			theme modes - QBASIC nibbles and tron light cycles
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.sound.midi.*;

public class SnakePanel extends JPanel
{
   private static ImageIcon [] orange = {new ImageIcon("images/orange0top.gif"), new ImageIcon("images/orange0side.gif"),
                         new ImageIcon("images/orange2.jpg"),    new ImageIcon("images/orange1.jpg")};
                                                                     //index 0 is the head facing North/South, index 1 is the head facing East/West,
                                                                     //index 2 is the lighter body segment, index 3 is the darker body segment
   private static ImageIcon [] purple = {new ImageIcon("images/purple0top.gif"), new ImageIcon("images/purple0side.gif"),
                         new ImageIcon("images/purple1.jpg"),    new ImageIcon("images/purple2.jpg")};

   private static ImageIcon wall = new ImageIcon("images/wall.jpg");           //impassable wall       - value 1 in the board array
   private static ImageIcon blank = new ImageIcon("images/blank.jpg");         //ground (empty tile)   - value 0 in the board array

   private static ImageIcon [] pellet = {new ImageIcon("images/pellet.GIF"),   //growth pellet
      						new ImageIcon("images/pellet2.GIF"),         //blue pellet - separate from tail
      						new ImageIcon("images/pellet3.GIF"),};	      //red pellet  - bust through wall

   private static int SIZE=19;						//size of cell being drawn
   private static final int numRows = 30;			//dimensions of the board
   private static final int numColumns = 40;		
														
   private static final String [] powerups = {"NONE", "RARE", "OFTEN"};			//powerup options
   private static final String [] maps = {"OPEN", "BOXED", "RANDOM"};			//map options
   private static final String [] speed = {"NONE", "BY ROUND", "8 FLOWERS"};	//speed change options

  //sound elements						
  //intervals of scales						Major							minor							Harmonic minor
   protected static int [][] intervals = {{0,2,4,5,7,9,11,12}, {0,2,3,5,7,9,11,12}, {0,2,3,5,7,8,11,12}};
   protected static MidiChannel[] channels=null;		//MIDI channels
   protected static Instrument[] instr;					//MIDI instrument bank
   protected static int [] instrumentList = {8,9,10,12,13,14,45,108,112,113,114,115};
   protected static int instrument;							//current instrument to be played
   protected static int [] scale;							//scale to be played


//This array will be represented graphically on the screen
   private static int[][] board;	      //0 - empty tile, 1 - wall

   private static int countDown;       //used to count down the start of each round 
   private static int deathPause;		//delay play after someone dies so we can see who it was
   private static boolean playNow;     //pause game until you press ENTER to play
   private static boolean aftermath;   //pause the game to show who won the game (by color of text)

   private static int pelletR, pelletC;//location of growth powerup
   private static int pelletNum;			//1-9, determines how much snake grows
   private static int powerupR, powerupC;		//location of special powerup
   private static int powerupNum;		//0-drop tail, 1-bust wall
   private static int powerupOption;	//0-NONE, 1-RARE, 2-OFTEN
   private static int mapType;			//0-OPEN, 1-BOXED, 2-RANDOM
   private static int startSize;			//how big are the snakes when they start?
   private static int speedChange;     //how the speed increases during play 0-NONE, 1-BY ROUND, 2-every 8 FLOWERS
   private static int numPlayers;		//1 player vs AI or 2 player?

   private static Timer t;					//used to set the speed of the enemy that moves around the screen
   private static int DELAY;		   	//#miliseconds delay between each time the enemy moves and screen refreshes for the timer

   private static Player p1,p2;			//our players, orange and purple

   public SnakePanel()
   {
      try 										//sound elements
      {
         Synthesizer synth = MidiSystem.getSynthesizer();
         synth.open();
         channels = synth.getChannels();
         instr = synth.getDefaultSoundbank().getInstruments();
      }
      catch (Exception ignored) 
      {}
   
      DELAY=200;
      playNow = false;
      aftermath = false;
      numPlayers = 2;
      board = new int[numRows][numColumns];
      p1 = new Player(0, 0, 0, "Orange", startSize);	
      p2 = new Player(0, 0, 0, "Purple", startSize);	
   
      t = new Timer(DELAY, new Listener());				//the higher the value of the first argument, the slower the enemy will move
      t.start();
      initialize();
   }

//post:  initialize the game board, done in the constructor and if game is reset from the main menu options
   public void initialize()
   {
      clearMap();       
      powerupOption = (int)(Math.random()*powerups.length);
      startSize = 3;
      if(Math.random() < .5)
         startSize = 200;
      mapType = (int)(Math.random()*maps.length);	
      speedChange = (int)(Math.random()*speed.length);
      resetGame();
      pelletNum = 1;
      deathPause = 0;
      DELAY = 200;
      t.setDelay(DELAY); 
      //sound elements
      channels[0].allNotesOff();
      pickRandomScale();  
      channels[0].allNotesOff(); 				//turn sounds off
   }

   public void pickRandomScale()
   {
      int instrIndex = (int)(Math.random()*instrumentList.length);
      instrument = instrumentList[instrIndex];							//pick random instrument	
      int scaleIndex = (int)(Math.random()*intervals.length);		
      scale = (intervals[scaleIndex]).clone();										//pick random scale
      int key = (int)(Math.random()*12) + 48;							//pick random key
      for(int i=0; i<scale.length; i++)									//adjust scale to random key
         scale[i] += key;
      channels[0].programChange(instr[instrument].getPatch().getProgram());  
   }

//post:  reset the round :players (and maybe the map) when a player dies.
   public void resetGame()
   {
      channels[0].allNotesOff(); 				//turn sounds off
      countDown = 9;
      deathPause = 0;
      if(maps[mapType].equals("BOXED"))
      {
         clearMap();
         makeBoxedMap();
      }
      else if(maps[mapType].equals("RANDOM"))
      {
         clearMap();
         makeRandomMap();
      }
      spawnPellet();
      p2.resetPlayer((int)(board.length*.25), (int)(board.length*.25), KeyEvent.VK_DOWN, startSize);
      p1.resetPlayer(board.length - (int)(board.length*.25), board[0].length - (int)(board.length*.25), KeyEvent.VK_UP, startSize);
      clearWallsNearSpawns();
   }

//post:  clears the map of all walls
   public void clearMap()
   {
      for(int r=0;r<board.length;r++)					//initialize to blank
         for(int c=0;c<board[0].length;c++)
            board[r][c] = 0;      
   }

//post:  create a map with borders around the edges - maybe with portals to the other side
   public void makeBoxedMap()
   {
      for(int r = 0; r<board.length; r++)
      {
         board[r][0] = 1;
         board[r][board[0].length-1] = 1;
      }
      for(int c = 0; c<board[0].length; c++)
      {
         board[0][c] = 1;
         board[board.length-1][c] = 1;
      }
      if(Math.random() < .5)			//will we have portals to the other side?
      {										//we will have between 1 and 10 portals
         int numDoors = (int)(Math.random()*10)+1;
         for(int i=0; i<numDoors; i++)
         {
            if(Math.random() < .5)	//door on row
            {
               int r = (int)(Math.random()*(board.length-2))+1;      //don't put a portal in a corner
               board[r][0] = 0;
               board[r][board[0].length-1] = 0;
            }
            else							//door on col
            {
               int c = (int)(Math.random()*(board[0].length-2))+1;
               board[0][c] = 0;
               board[board.length-1][c] = 0;
            }
         }
      }
   }

//post:  create a map (maybe with borders) with random walls and obstacles
   public void makeRandomMap()
   {
      int numBlocks = (int)(Math.random() * ((board.length * board[0].length) / 20));
      int numWalls = (int)(Math.random() * 10);
      if(Math.random() < .5)			//50% a random map will also be boxed
         makeBoxedMap();
      int mapType = (int)(Math.random()*3);  //0-both blocks and walls, 1-just blocks, 2-just walls   
      if(mapType == 0 || mapType == 1)
      {
         for(int i=0; i<numBlocks; i++)
         {
            int row = (int)(Math.random() * (board.length - 4)) + 2;
            int col = (int)(Math.random() * (board[0].length - 4)) + 2;
            board[row][col] = (board[row][col]+1)%2;
         }
      }
      if(mapType == 0 || mapType == 2)
      {
         for(int i=0; i<numWalls; i++)
         {
            if(Math.random() < .5)     //vertical wall
            {
               int wallLength = (int)(Math.random()*board.length/2);
               int startRow = (int)(Math.random()*board.length);
               int startCol = (int)(Math.random()*board[0].length);
               for(int r=0; r<wallLength && (startRow+r)<board.length; r++)
                  board[startRow + r][startCol] = 1;
            }
            else                       //horizontal wall
            {
               int wallLength = (int)(Math.random()*board[0].length/2);
               int startRow = (int)(Math.random()*board.length);
               int startCol = (int)(Math.random()*board[0].length);
               for(int c=0; c<wallLength && (startCol+c)<board[0].length; c++)
                  board[startRow][startCol + c] = 1;
            }
         }
      }
   }

//post:  respawn a pellet in a clear location (called when a power pellet or split powerup is eaten, and restart/constructor)
   public void spawnPellet()
   {
      int numRows = board.length;
      int numColumns = board[0].length;
   	
      //********************************FIX 1a*************************************************/
   												//change the assignment of pelletR and pelletC a random location on the board
      pelletR = numRows/2;					//temporary assignment to keep things compiling
      pelletC = numColumns/2;				//temporary assignment to keep things compiling
      boolean wallIsThere = false;
      if(board[pelletR][pelletC] == 1)	//looks to see if there is a wall in the picked spawn location
         wallIsThere = true;
         
   	//insert code here so it picks another location if there is a wall there
   
      //********************************end FIX 1a**********************************************/
   
      powerupR = -1;
      powerupC = -1;
      powerupNum = (int)(Math.random()*2)+1;
      boolean powerupSpawn = false;
      double prob = 0;
      if(powerupOption == 1)	//rare powerup
         prob = .1;
      else if(powerupOption == 2)
         prob = .25;
      if(pelletNum < 5)
      {
         if(Math.random() < prob)
            powerupSpawn = true;
      }
      else
      {
         if(Math.random() < prob*2)
            powerupSpawn = true;
      }
      if(powerupSpawn)
      {
       //**********************************FIX 1b*****************************************************/
      													//change the assignment of powerupR and powerupC a random location on the board
         powerupR = numRows/2;					//temporary assignment to keep things compiling
         powerupC = numColumns/2;				//temporary assignment to keep things compiling
         wallIsThere = false;
         if(board[powerupR][powerupC] == 1)	//looks to see if there is a wall in the picked spawn location
            wallIsThere = true;
            
        //insert code here so it picks another location if there is a wall there
        
      //***********************************end FIX 1b************************************************/
      }
   }

//post:  if any walls were dropped near snake spawns, clear them so snakes can move initially
   public void clearWallsNearSpawns()
   {
      int bufferSize = 5;				//how much space to leave around spawn points
      int p1R = board.length - (int)(board.length*.25);		//initial spawn for p1
      int p1C = board[0].length - (int)(board.length*.25);
      int p2R = (int)(board.length*.25);							//initial spawn for p2
      int p2C = (int)(board.length*.25);
      for(int r = p1R-bufferSize; r < p1R+bufferSize && r >= 0 && r < board.length; r++)
         for(int c = p1C-bufferSize; c < p1C+bufferSize && c >=0 && c < board[0].length; c++)
            board[r][c] = 0;
      for(int r = p2R-bufferSize; r < p2R+bufferSize && r >= 0 && r < board.length; r++)
         for(int c = p2C-bufferSize; c < p2C+bufferSize && c >=0 && c < board[0].length; c++)
            board[r][c] = 0;      
   }

//pre:  g!=null, p!=null, parts!=null
//post: draw the snake p and its tail on the screen
   public void drawSnake(Graphics g, Player p, ImageIcon [] parts)
   {
      ArrayList<Point> snake = p.getTail();
      for(int i=snake.size()-1; i>=0; i--)
      {
         int row = (int)(snake.get(i).getX());
         int col = (int)(snake.get(i).getY());
         int y = row*SIZE;
         int x = col*SIZE;
         int shift = 0;
         double powerup = 1;
         if(p.isWallBuster())
            powerup = 1.5;
         if(p.getDir() == KeyEvent.VK_DOWN || p.getDir() == KeyEvent.VK_S || p.getDir() == KeyEvent.VK_RIGHT || p.getDir() == KeyEvent.VK_D)
            shift = SIZE/2;
         if(i==0) 				//draw the head
         {
            if(p.getDir() == KeyEvent.VK_UP || p.getDir() == KeyEvent.VK_W || p.getDir() == KeyEvent.VK_DOWN || p.getDir() == KeyEvent.VK_S)
               g.drawImage(parts[0].getImage(), x, y-shift, (int)(SIZE*powerup), (int)(SIZE*1.5), null);  
            else
               g.drawImage(parts[1].getImage(), x-shift, y, (int)(SIZE*1.5),(int)(SIZE*powerup), null);  
         }
         else if(p.dead() && deathPause > 0) //if dead, flash body parts randomly
            g.drawImage(parts[(int)(Math.random()*2)+2].getImage(), x, y, SIZE, SIZE, null);
         else if(i%2 != 0)		//odd index
            g.drawImage(parts[2].getImage(), x, y, SIZE, SIZE, null);  
         else
            g.drawImage(parts[3].getImage(), x, y, SIZE, SIZE, null);  
      }
   }

//pre:   g != null
//post:  shows different pictures on the screen in grid format depending on the values stored in the array board
//			0-blank, 1-wall and gives priority to drawing the player
//       also show player names, scores, keyboard commands, main menu commands
   public void showBoard(Graphics g)	
   {
      int x =0, y=0;		//upper left corner location of where image will be drawn
      for(int r=0;r<board.length;r++)
      {
         x = 0;			//reset the row distance
         for(int c=0;c<board[0].length;c++)
         {
            if(board[r][c]==0)				//blank space
               g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);  //scaled image
            else
               if(board[r][c]==1)			//wall
                  g.drawImage(wall.getImage(), x, y, SIZE, SIZE, null);  
                   
            if(r==pelletR && c==pelletC)	//draw the pellet on the board after the cell has been drawn
            {
               g.drawImage(pellet[0].getImage(), x, y, SIZE, SIZE, null);  
               g.setFont(new Font("Monospaced", Font.BOLD, SIZE));
               g.setColor(Color.red.darker());
               g.drawString(""+pelletNum, x+(SIZE/4), (int)(y+(SIZE/1.25)));
            }	
            if(r==powerupR && c==powerupC)	//draw the powerup on the board after the cell has been drawn
            {
               g.drawImage(pellet[powerupNum].getImage(), x, y, SIZE, SIZE, null);  
            }		 
            x+=SIZE;
         }
         y+=SIZE;
      }
      drawSnake(g, p1, orange);				//draw players
      drawSnake(g, p2, purple);
   
      if(countDown > 1)
      {
         g.drawImage(pellet[0].getImage(), ((board[0].length*SIZE)/2) - (SIZE*2), ((board.length*SIZE)/2) - (SIZE*2), SIZE*4, SIZE*4, null);  
         g.setFont(new Font("Monospaced", Font.BOLD, SIZE*3));
         g.setColor(Color.red.darker());
         if(!playNow)
         {
            if(aftermath)
            {
               if(p1.getScore() > p2.getScore())
                  g.setColor(Color.orange);
               else  if(p2.getScore() > p1.getScore())
                  g.setColor(Color.pink.darker());
            }
            g.drawString("ENTER to play", (int)((((board[0].length*SIZE)/2))-(SIZE*12.5)), (int)((((board.length*SIZE)/2))+(SIZE*0.75)));
         }
         else
         {
            g.setColor(Color.red.darker());
            g.drawString(""+countDown, (((board[0].length*SIZE)/2) - (SIZE*2))+(SIZE), (int)((((board.length*SIZE)/2) - (SIZE*2))+(SIZE*3)));
         }
      }	
      x = SIZE;
      y += SIZE;
      g.setFont(new Font("Monospaced", Font.BOLD, SIZE));
      g.setColor(Color.pink.darker().darker());
      g.drawString(""+p2.getName()+":"+p2.getScore(), x, y);
      g.drawString("LIVES:"+p2.getLives(), x, y+=SIZE);
      if(numPlayers==2)
      {
         g.drawString("KEYS: W A S D", x, y+=SIZE);
      }
      else
         y+=(SIZE);
      x = (SIZE * board[0].length) - (SIZE * 8);
      y -= SIZE*2;
      g.setColor(Color.orange.darker());
      g.drawString(""+p1.getName()+":"+p1.getScore(), x, y);
      g.drawString("LIVES:"+p1.getLives(), x, y+=SIZE);
      g.drawString("KEYS: ARROWS", x, y+=SIZE);
   
      g.setColor(Color.blue.darker().darker());
      x = ((SIZE * board[0].length) / 2) - (SIZE * 5);
      y -= SIZE * 2;
      g.drawString("(P)POWERUPS  :"+powerups[powerupOption], x, y);
      g.drawString("(Z)START SIZE:"+startSize, x, y+=SIZE);
      g.drawString("(M)MAP TYPE  :"+maps[mapType], x, y+=SIZE);
      g.drawString("(N)# PLAYERS :"+numPlayers, x, y+=SIZE);
      g.drawString("(T)SPEED-UP  :"+speed[speedChange], x, y+=SIZE);
      g.drawString("(< >)DELAY   :"+DELAY, x, y+=SIZE);
      g.setColor(Color.black);
      g.drawString("(ESC)QUIT     ", x, y+=SIZE);
      g.drawString("(R)RESET GAME ", x, y+=SIZE);
      g.drawString("(- +)SIZE     ", x, y+=SIZE);
   }

//pre:  k and dir are valid keycodes for controling a snake
//post: returns true if k and dir are opposite directions
   private boolean oppositeDirs(int k, int dir)
   {
      return  ((k==KeyEvent.VK_UP    && dir==KeyEvent.VK_DOWN) || 
         (k==KeyEvent.VK_DOWN  && dir==KeyEvent.VK_UP)   ||
         (k==KeyEvent.VK_RIGHT && dir==KeyEvent.VK_LEFT) ||
         (k==KeyEvent.VK_LEFT && dir==KeyEvent.VK_RIGHT) ||
         
         (k==KeyEvent.VK_W && dir==KeyEvent.VK_S) || 
         (k==KeyEvent.VK_S && dir==KeyEvent.VK_W) ||
         (k==KeyEvent.VK_A && dir==KeyEvent.VK_D) ||
         (k==KeyEvent.VK_D && dir==KeyEvent.VK_A));
   }

//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
//pre:   k is a valid keyCode
//post:  changes the players position depending on the key that was pressed (sent from the driver)
//			keeps the player in the bounds of the size of the array board, then the enemy moves
   public void processUserInput(int k)
   {
      if(k==KeyEvent.VK_Q || k==KeyEvent.VK_ESCAPE)//End the program	
         System.exit(1);
      if(k==KeyEvent.VK_R)									//reset game
      {	
         playNow = false;
         initialize();
         return;   
      }
      if(k==KeyEvent.VK_P)									//change powerup options
         powerupOption = (powerupOption + 1) % powerups.length;
      if(k==KeyEvent.VK_T)									//change how speed increases
         speedChange = (speedChange + 1) % speed.length;
      if(k==KeyEvent.VK_N)									//change number of players
      {    
         numPlayers = ((numPlayers) % 2)+1;
         if(numPlayers == 2)
            p2 = new Player(0, 0, 0, "Purple", startSize);	
         else 
            if(numPlayers == 1)
               p2 = new AIplayer(0, 0, 0, "Purple", startSize);	
      
         resetGame();
         return;
      }
      if(k==KeyEvent.VK_Z)									//change snake start size
      {
         if(startSize == 200)
            startSize = 3;
         else
            startSize = 200;
         resetGame();
         return;
      }
      if(k==KeyEvent.VK_M)									//change map type
      {
         mapType = (mapType + 1) % maps.length;
         clearMap();
         resetGame();
         return;
      }
      if((k==KeyEvent.VK_PERIOD) && DELAY >= 5)
      {
         DELAY -= 5;
         t.setDelay(DELAY);   
      }
      if((k==KeyEvent.VK_COMMA) && DELAY < 995)
      {
         DELAY += 5;
         t.setDelay(DELAY);   
      }
      if((k==KeyEvent.VK_MINUS || k==KeyEvent.VK_SUBTRACT || k==KeyEvent.VK_UNDERSCORE) && SIZE > 5)
         SIZE--;
      if(k==KeyEvent.VK_PLUS || k==KeyEvent.VK_ADD || k==KeyEvent.VK_EQUALS) 
         SIZE++;
      if(k==KeyEvent.VK_ENTER)
      {
         playNow = true;
         if(aftermath)
         {
            aftermath = false;
            p1 = new Player(0, 0, 0, "Orange", startSize);	
            if(numPlayers==2)
               p2 = new Player(0, 0, 0, "Purple", startSize);	
            else
               if(numPlayers == 1)
                  p2 = new AIplayer(0, 0, 0, "Purple", startSize);	
            resetGame();
            return;   
         }  
      }
      if((k==KeyEvent.VK_UP || k==KeyEvent.VK_RIGHT || k==KeyEvent.VK_DOWN || k==KeyEvent.VK_LEFT) && !oppositeDirs(k, p1.getDir())) 
         p1.setDir(k);  
      if(numPlayers==2 && (k==KeyEvent.VK_W || k==KeyEvent.VK_D || k==KeyEvent.VK_S || k==KeyEvent.VK_A) && !oppositeDirs(k, p2.getDir()))
         p2.setDir(k);
      repaint();			//refresh the screen
   }

//post:  check for collisions between players and walls/other players, as well as powerups
   public void checkCollisions()
   {
      boolean p1Dies = false;
      boolean p2Dies = false;
      int p1index = snakeAt(p1, p1);
      int p2index = snakeAt(p1, p2);
      if(wallAt(p1.getRow(), p1.getCol()) || p1index >=0 || p2index>=0)				//p1 hits something
      {
         if(p1.isWallBuster())
         {
            channels[0].allNotesOff(); 				//turn sounds off
            channels[0].programChange(instr[47].getPatch().getProgram());
            channels[0].noteOn((int)(Math.random()*11)+50, 120);
            if(board[p1.getRow()][p1.getCol()]==1)		//we run into a wall, so bust through
               board[p1.getRow()][p1.getCol()] = 0;	//clear the wall there
            else													//we ran into a snake (ourselves:p1, or p2)	
            {
               if(p1index >= 0)
               {													//we hit ourself
                  ArrayList<Point> snake = p1.getTail();
                  for(int j=p1index+1; j<snake.size(); j++)
                  {
                     int row = (int)(snake.get(j).getX());
                     int col = (int)(snake.get(j).getY());
                     board[row][col] = 1;
                  }
                  p1.cutTail(p1index);
                  spawnPellet();
               }
               else if(p2index >= 0)
               {	//we hit p2
                  if(p1.getRow() == p2.getRow() && p1.getCol() == p2.getCol())	//heads collide
                  {
                     if(p2.isWallBuster())				//both are wall busters - mutual death
                     {
                        p1Dies = true;
                        p2Dies = true;
                     }
                     else
                        p2Dies = true;
                  }
                  else
                  {											
                     ArrayList<Point> snake = p2.getTail();
                     for(int j=p2index+1; j<snake.size(); j++)
                     {
                        int row = (int)(snake.get(j).getX());
                        int col = (int)(snake.get(j).getY());
                        board[row][col] = 1;
                     }
                     p2.cutTail(p2index);
                  }
                  spawnPellet();
               }
            }
            p1.toggleWallBuster();						//switch powerup off
         }
         else
         {
            p1Dies = true;
         }
      }  
      p2index = snakeAt(p2, p2);
      p1index = snakeAt(p2, p1);
      if(wallAt(p2.getRow(), p2.getCol()) || p1index >=0 || p2index>=0)				//p2 hits something
      {
         if(p2.isWallBuster())
         {
            channels[0].allNotesOff(); 				//turn sounds off
            channels[0].programChange(instr[47].getPatch().getProgram());
            channels[0].noteOn((int)(Math.random()*11)+50, 120);
            if(board[p2.getRow()][p2.getCol()]==1)		//we run into a wall, so bust through
               board[p2.getRow()][p2.getCol()] = 0;	//clear the wall there
            else													//we ran into a snake (ourselves:p2, or p1)	
            {
               if(p2index >= 0)
               {													//we hit ourself
                  ArrayList<Point> snake = p2.getTail();
                  for(int j=p2index+1; j<snake.size(); j++)
                  {
                     int row = (int)(snake.get(j).getX());
                     int col = (int)(snake.get(j).getY());
                     board[row][col] = 1;
                  }
                  p2.cutTail(p2index);
                  spawnPellet();
               }
               else if(p1index >= 0)
               {													//we hit p1
                  if(p1.getRow() == p2.getRow() && p1.getCol() == p2.getCol())	//heads collide
                  {
                     if(p1.isWallBuster())				//both are wall busters - mutual death
                     {
                        p1Dies = true;
                        p2Dies = true;
                     }
                     else
                        p1Dies = true;
                  }
                  else
                  {								
                     ArrayList<Point> snake = p1.getTail();
                     for(int j=p1index+1; j<snake.size(); j++)
                     {
                        int row = (int)(snake.get(j).getX());
                        int col = (int)(snake.get(j).getY());
                        board[row][col] = 1;
                     }
                     p1.cutTail(p1index);
                  }
                  spawnPellet();
               }
            }
            p2.toggleWallBuster();						//switch powerup off
         }
         else
         {
            p2Dies = true;
         }
      }  
      if(p1Dies)
      {
         channels[0].allNotesOff(); 				//turn sounds off
         channels[0].programChange(instr[47].getPatch().getProgram());
         channels[0].noteOn((int)(Math.random()*11)+30, 120);
      
         p1.changeLives(-1);
         if(!aftermath)
            p2.addScore(10);            //survival bonus
         if(speed[speedChange].equals("BY ROUND") && DELAY >= 20)
         {
            DELAY -= 20;
            t.setDelay(DELAY);   
         }
         deathPause = 10;
         p1.setDead(true);
      }
      if(p2Dies)
      {
         channels[0].allNotesOff(); 				//turn sounds off
         channels[0].programChange(instr[47].getPatch().getProgram());
         channels[0].noteOn((int)(Math.random()*11)+30, 120);
      
         p2.changeLives(-1);
         if(!aftermath)
            p1.addScore(10);            //survival bonus
         if(speed[speedChange].equals("BY ROUND") && DELAY >= 20)
         {
            DELAY -= 20;
            t.setDelay(DELAY);   
         }
         deathPause = 10;
         p2.setDead(true);
      }
      if(p1.getRow()==pelletR && p1.getCol() == pelletC)
      {//p1 gets powerup: grow
         int note = pelletNum - 1;
         if(note >= scale.length)
            note = scale.length-1;
         channels[0].programChange(instr[instrument].getPatch().getProgram());  
         channels[0].noteOn(scale[note], 80);
         spawnPellet();
         if(startSize==3)
            p1.grow(pelletNum);	
         p1.addScore(pelletNum);
         if(pelletNum < 8)
            pelletNum++;
         else if(speed[speedChange].equals("8 FLOWERS") && DELAY >= 15)
         {
            pelletNum = 1;
            DELAY -= 15;
            t.setDelay(DELAY);  
         }
      }
      if(p2.getRow()==pelletR && p2.getCol() == pelletC)
      {//p2 gets powerup: grow
         int note = pelletNum - 1;
         if(note >= scale.length)
            note = scale.length-1;
         channels[0].programChange(instr[instrument].getPatch().getProgram());  
         channels[0].noteOn(scale[note], 80);
         spawnPellet();
         if(startSize==3)
            p2.grow(pelletNum);
         p2.addScore(pelletNum);
         if(pelletNum < 8)
            pelletNum++;	
         else if(speed[speedChange].equals("8 FLOWERS") && DELAY >= 15)
         {
            pelletNum = 1;
            DELAY -= 15;
            t.setDelay(DELAY);  
         }
      }
      if(p1.getRow()==powerupR && p1.getCol()==powerupC)
      {
         pickRandomScale();
         powerupR = -1;
         powerupC = -1;
         p1.addScore(5);
         if(powerupNum == 1 && p1.getTail().size() > 3)
         {//drop tail
            channels[0].noteOn(scale[scale.length-1]+12, 80);
            ArrayList<Point> wall = p1.getTail();
            for(int i=3; i<wall.size(); i++)
            {
               int r = (int)(wall.get(i).getX());
               int c = (int)(wall.get(i).getY());
               board[r][c] = 1;
            }
            p1.cutTail(3);
            spawnPellet();
         }
         else if(powerupNum == 2)
         { //give wall buster     
            channels[0].noteOn(scale[0]-12, 80);       
            p1.toggleWallBuster();						//switch powerup on
         }
      }
      if(p2.getRow()==powerupR && p2.getCol()==powerupC)
      {
         pickRandomScale();
         powerupR = -1;
         powerupC = -1;
         p2.addScore(5);
         if(powerupNum == 1 && p2.getTail().size() > 3)
         {//drop tail
            channels[0].noteOn(scale[scale.length-1]+12, 80);
            ArrayList<Point> wall = p2.getTail();
            for(int i=3; i<wall.size(); i++)
            {
               int r = (int)(wall.get(i).getX());
               int c = (int)(wall.get(i).getY());
               board[r][c] = 1;
            }
            p2.cutTail(3);
            spawnPellet();
         }
         else if(powerupNum == 2)
         {//give wall buster
            channels[0].noteOn(scale[0]-12, 80);
            p2.toggleWallBuster();						//switch powerup on
         }
      }
   
   }

//pre:   us != null, check != null
//post:  returns location of collision if there is a collision between us and check
   protected static int snakeAt(Player us, Player check)
   {
      ArrayList<Point> tail = check.getTail();
      int start = 0;
      if(us.equals(check))
         start = 1;
      for(int i=start; i<tail.size(); i++)
      {
         Point segment = tail.get(i);
         if(us.getRow()==segment.getX() && us.getCol()==segment.getY())
            return i;
      }
      return -1;
   }

//pre:   check != null, r and c >=0, r<board.length, c<board[0].length
//post:  returns true if there is a snake segment at row r, col c
//args:  check is the player whose tail segment we are looking for at location (r,c)
//			ignoreHead will not consider the snake head's location if it is true:
//			this is so that a snake doesn't try to check for a collision with its own head
   protected static boolean snakeAt(Player check, int r, int c, boolean ignoreHead)
   {
      ArrayList<Point> tail = check.getTail();
      int start = 0;
      if(ignoreHead)
         start = 1;
      for(int i=start; i<tail.size(); i++)
      {
         Point segment = tail.get(i);
         if(r==segment.getX() && c==segment.getY())
            return true;
      }
      return false;
   }

//pre:   r and c >=0, r<board.length, c<board[0].length
//post:  returns true if there is a wall at row r, col c
   protected static boolean wallAt(int r, int c)
   {
      return (board[r][c] == 1);
   }

//pre:   r and c >=0, r<board.length, c<board[0].length
//post:  returns true if the spot at row r, col c is blocked by a snake or wall
   protected static boolean blocked(int r, int c)
   {
      return snakeAt(p1, r, c, false) || snakeAt(p2, r, c, false) || wallAt(r, c);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      g.setColor(Color.blue);		//draw a blue boarder around the board
      g.fillRect(0, 0, (board[0].length*SIZE), (board.length*SIZE));
      showBoard(g);					//draw the contents of the array board on the screen
   }


   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)	//this is called for each timer iteration
      {
         if(p1.getLives() < 1 || p2.getLives() < 1)
         {
            if(!aftermath)
            {
               if(p1.getLives() < 1 || p2.getLives() >= 1)
                  p2.addScore(10*p2.getLives());  //survival bonus
               if(p2.getLives() < 1 || p1.getLives() >= 1)
                  p1.addScore(10*p1.getLives());  //survival bonus
               pelletNum = 1;   
               DELAY = 200;
               t.setDelay(DELAY);     
            }
            playNow = false;
            aftermath = true;
         }
         if(countDown == 0 && deathPause == 0)
         {
            p1.move(board.length, board[0].length);
            if(numPlayers==1 && p2 instanceof AIplayer)
               ((AIplayer)(p2)).AImove(p1, board, pelletR, pelletC, powerupR, powerupC);
            p2.move(board.length, board[0].length);
            checkCollisions();
         }
         else
            if(deathPause > 0)
            {
               deathPause--;
               if(deathPause == 0)
                  resetGame();
            }
            else
               if(playNow)
               {
                  if(countDown > 0)
                     countDown--;
               }
         repaint();
      }
   }

}
