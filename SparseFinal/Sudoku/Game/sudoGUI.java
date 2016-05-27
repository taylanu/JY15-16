package Game;

import javax.swing.*;
import java.awt.*;

import static sun.misc.PostVMInitHook.run;

public class sudoGUI extends JFrame{
    public sudoGUI(){
        super();
    }

    public void paint(Graphics g){
        g.drawLine(10,10,150,150);
    }
    public static void run() {
        sudoGUI frame = new sudoGUI();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("tSudo");    //window title
        frame.setSize(800, 800);                    //Size of game window
        frame.setMinimumSize(new Dimension(800,600));
        frame.setLocation(100, 50);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        run();
    }
}
