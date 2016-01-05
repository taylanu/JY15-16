//Rev. Dr. Douglas R Oberle, Sept 2013  
   import javax.swing.JFrame;
   import java.awt.event.KeyListener;
   import java.awt.event.KeyEvent;

   public class JavaSnakesDriver						//Driver Program
   {
      public static SnakePanel screen;					//Game window
   
      public static void main(String[]args)
      {
         screen = new SnakePanel();
         JFrame frame = new JFrame("Arrays Represented in Graphics with Keyboard Input");	//window title
         frame.setSize(800, 800);					//Size of game window
         frame.setLocation(100, 50);				//location of game window on the screen
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(screen);		
         frame.setVisible(true);
         frame.addKeyListener(new listen());		//Get input from the keyboard
      
      }
   
      public static class listen implements KeyListener 
      {
      
         public void keyTyped(KeyEvent e)
         {
         
         }
      
         public void keyPressed(KeyEvent e)
         {
            int k = e.getKeyCode();
         //allow changing the delay (< or >) to be held down to change it faster
            if(k==KeyEvent.VK_COMMA  || k==KeyEvent.VK_PERIOD)
               screen.processUserInput(k);
         }
      
         public void keyReleased(KeyEvent e)
         {
            int k = e.getKeyCode();
         //all keys other than changing the delay only register when pressed, so you can't keyboard-buffer-spam your opponent
            if(k==KeyEvent.VK_COMMA  || k==KeyEvent.VK_PERIOD)
            {}
            else
               screen.processUserInput(e.getKeyCode());
         }
      }
   
   }
