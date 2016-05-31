package Game;

import javax.swing.*;

/**
 * Created by taylanu on 5/23/2016.
 */
@Deprecated
public class fileChooser {
    public class NativeFileChooser {
//http://codereview.stackexchange.com/questions/4446/file-browser-gui
        public void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(
                                UIManager.getSystemLookAndFeelClassName());
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    JFileChooser jfc = new JFileChooser();
                    jfc.showOpenDialog(null);
                }
            });
        }
    }
}
