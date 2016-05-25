package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by taylanu on 5/25/2016.
 */
public class DrawPanel extends JPanel{
    public DrawPanel(){                       // set up graphics window
        super();
        quit();
        setBackground(Color.BLUE);

    }
    public static void quit(){
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
