package Game;

import javax.swing.*;

/**
 * Rather than a frame, put the game inside of an applet.
 */
public class SudokuApplet extends JApplet {

    private Sudoku tsudo;

    public final void init() {
        tSudo = new Sudoku();
        add(tSudo);
    }

    public final void start() {
        Sudoku.createSudoku(Sudoku.EASY);
    }
}
