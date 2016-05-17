//Mash, Mangle & Munch - Rev Dr Douglas R Oberle, July 2012  doug.oberle@fcps.edu
//DRIVER PROGRAM  

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MMMDriver                        //Driver Program
{
    public static MMMPanel screen;        //Game window
    public static JFrame frame;
    public static int width;
    public static int height;

    public static void main(String[] args) throws IOException {
        screen = new MMMPanel();
        frame = new JFrame("Mash Mangle + Munch");//window title
        height = 714;
        width = (int) (height * 1.3);
        frame.setSize(width, height);                    //Size of game window
        frame.setLocation(100, 50);                    //location of game window on the screen
        frame.setExtendedState(Frame.NORMAL);    //MAXIMIZED_BOTH, MAXIMIZED_VERT, or ICONIFIED
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(screen);
        frame.setVisible(true);
        frame.addKeyListener(new listen());            //Get input from the keyboard
        //make the regular mouse cursor transparent so we can use a custom one in the MMMPanel that changes depending on direction
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "MMM cursor");
        frame.getContentPane().setCursor(blankCursor);
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
            int k = e.getKeyCode();

            if (k == KeyEvent.VK_MULTIPLY)            //larger screen
            {
                if (height < 732) {
                    screen.change(k);
                    height += 2;
                    frame.setExtendedState(Frame.MAXIMIZED_BOTH);  //MAXIMIZED_BOTH, MAXIMIZED_VERT, or ICONIFIED
                    frame.repaint();
                }
            } else if (k == KeyEvent.VK_DIVIDE)                //smaller screen
            {
                screen.change(k);
                height = 714;
                width = (int) (height * 1.3);
                frame.setSize(width, height);                //Size of game window
                frame.setExtendedState(Frame.NORMAL); //MAXIMIZED_BOTH, MAXIMIZED_VERT, ICONIFIED
                frame.repaint();
            } else
                screen.change(k);
        }
    }

}
