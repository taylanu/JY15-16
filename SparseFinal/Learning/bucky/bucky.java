package bucky;

import javax.swing.*;
import java.awt.*;

/**
 * Created by taylanu on 5/28/2016.
 */
@Deprecated
public class bucky extends JFrame {
    public static void main( String[] args) {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        bucky b = new bucky();
        b.run(dm);
    }

    private void run(DisplayMode dm) {
        setBackground(Color.pink);
        setForeground(Color.white);
        setFont(new Font("Arial", Font.PLAIN, 24));

        buckyGUI b = new buckyGUI();
        try{
           // b.setfScreen(dm, this);
            try{
                Thread.sleep(5000);
            }catch(Exception ex){}

        }finally{
            b.restoreScreen();
        }
    }
    public void paint(Graphics g){
        g.drawString("This is going to be great",231,432);
    }
}