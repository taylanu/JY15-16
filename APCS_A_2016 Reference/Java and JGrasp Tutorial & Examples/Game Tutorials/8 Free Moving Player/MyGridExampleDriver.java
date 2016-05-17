import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyGridExampleDriver                        //Driver Program
{
    public static MyGridExample screen;                    //Game window


    public static void main(String[] args) {
        screen = new MyGridExample();
        JFrame frame = new JFrame("Arrays Represented in Graphics with Keyboard Input");    //window title
        frame.setSize(800, 800);                    //Size of game window
        frame.setLocation(100, 50);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(screen);
        frame.setVisible(true);
        frame.addKeyListener(new listen());        //Get input from the keyboard

    }

    public static class listen implements KeyListener {

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {

        }

        // public void keyReleased(KeyEvent e)
        // {
        // int k=e.getKeyCode();
        //
        // if(k==KeyEvent.VK_W)				//shoot up
        // screen.change("shoot up");
        // else
        // if(k==KeyEvent.VK_S)			//shoot down
        // screen.change("shoot down");
        // else
        // if(k==KeyEvent.VK_D)
        // screen.change("shoot right");
        // else
        // if(k==KeyEvent.VK_A)
        // screen.change("shoot left");
        // else
        //
        // if(k==KeyEvent.VK_UP)				//Move up
        // screen.change("up");
        // else
        // if(k==KeyEvent.VK_DOWN)			//Move down
        // screen.change("down");
        // else
        // if(k==KeyEvent.VK_RIGHT)
        // screen.change("right");
        // else
        // if(k==KeyEvent.VK_LEFT)
        // screen.change("left");
        // else
        // if(k==KeyEvent.VK_SPACE)
        // screen.change("space");
        // else
        // if(k==KeyEvent.VK_Q)	//End the program
        // System.exit(1);
        // }

        public void keyReleased(KeyEvent e) {
            screen.processUserInput(e.getKeyCode());
        }

    }

}
