//Rev. Dr. Douglas R Oberle, March 2013
package pixoku;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PixokuDriver                        //Driver Program
{
    public static Pixoku screen;                //Game window

    public static void main(String[] args) {
        Pixoku screen = new Pixoku();
        JFrame frame = new JFrame("Pixoku");//window title
        frame.setSize(1000, 1000);                //Size of game window
        frame.setLocation(10, 10);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(screen);
        frame.setVisible(true);
        frame.addKeyListener(new listen());    //Get input from the keyboard
    }

    public static class listen implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            screen.userCommand(key);
        }
    }

}
