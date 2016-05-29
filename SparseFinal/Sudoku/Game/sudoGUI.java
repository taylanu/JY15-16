package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class sudoGUI extends JPanel {

    protected static int mouseX;            //locations for the mouse pointer
    protected static int mouseY;

    public sudoGUI(){
        super();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("tSudo");    //window title
        frame.setSize(800, 800);                    //Size of game window
        frame.setMinimumSize(new Dimension(800,600));
        frame.setLocation(100, 50);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
