package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class sudoGUI extends JPanel implements MouseListener, MouseMotionListener {

    protected static int mouseX;            //locations for the mouse pointer
    protected static int mouseY;

    public sudoGUI(){
        super();
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);        //draw a blue border around the board
        g.drawRect(x,y,9,9);
        showBoard(g);                    //draw the contents of the array board on the screeng.drawLine(10,10,150,150);
    }

    private void showBoard(Graphics g) {
        int x = 0, y = 0;        //upper left corner location of where image will be drawn
        for (int r = 0; r < sudoku.length; r++) {
            x = 0;                        //reset the row distance
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0)
                    g.drawImage(blank.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                else if (board[r][c] == 1)
                    g.drawImage(white.getImage(), x, y, SIZE, SIZE, null);  //scaled image
                else // if(board[r][c]==2)
                    g.drawImage(black.getImage(), x, y, SIZE, SIZE, null);  //scaled image

                if (r == playerR && c == playerC)    //draw the crosshair on the board after the cell has been drawn
                    g.drawImage(crossHair.getImage(), x, y, SIZE, SIZE, null);  //scaled image

                x += SIZE;
            }
            y += SIZE;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("tSudo");    //window title
        frame.setSize(800, 800);                    //Size of game window
        frame.setMinimumSize(new Dimension(800,600));
        frame.setLocation(100, 50);                //location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        int mouseR = (mouseY / SIZE);
        int mouseC = (mouseX / SIZE);
        // System.out.println(mouseR+":"+mouseC);
        if (mouseR >= 0 && mouseC >= 0 && mouseR < board.length && mouseC < board[0].length) {
            playerR = mouseR;
            playerC = mouseC;
        } else {
            playerR = board.length / 2;
            playerC = board[0].length / 2;

        }
        repaint();            //refresh the screen
    }
}
