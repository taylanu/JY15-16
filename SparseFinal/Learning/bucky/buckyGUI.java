package bucky;

import java.awt.*;

/**
 * Created by taylanu on 5/28/2016.
 */
@Deprecated
public class buckyGUI {
    private GraphicsDevice vc;//vc for video card
    public buckyGUI(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();
    }
    /*public void setfScreen(DisplayMode dm, bucky bucky){
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);

        if(dm != null && vc.isDisplayChangeSupported()){
            try{
                vc.setDisplayMode(dm);
            }catch(Exception ex){}
        }
    }*/
    public Window getfScreenWindow(){
        return vc.getFullScreenWindow();
    }
    public void restoreScreen(){
        Window w = vc.getFullScreenWindow();
        if(w != null)
            w.dispose();//closes the window.
        vc.setFullScreenWindow(null);//removes the fullscreen
    }

}
