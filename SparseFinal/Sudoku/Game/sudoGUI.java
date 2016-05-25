package Game;

import javax.swing.*;
import java.awt.*;

public class sudoGUI extends JFrame{
    public sudoGUI(){
        super();
    }
    public void paint(Graphics g){
        g.drawLine(10,10,150,150);
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("JSudoku");    //window title
        frame.setSize(800, 800);                    //Size of game window
        frame.setLocation(100, 50);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
