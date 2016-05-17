import java.io.PrintStream;
import java.util.Scanner;

public class Screen {
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    private int mySize;
    private int[][] myPixels;

    //constructor
    public Screen(int size) {
        myPixels = new int[size][size];
        mySize = size;
        clear();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Screen s = new Screen(8);
        s.print(System.out);
        input.nextLine();            //hit ENTER to continue

        System.out.println();
        s.drawRectangle(1, 2, 5, 4);
        s.print(System.out);
        s.clear();
        input.nextLine();

        System.out.println();
        s.drawRectangle(4, 3, 9, 5);
        s.print(System.out);
        s.clear();
        input.nextLine();

        System.out.println();
        s.drawRectangle(4, 4, 8, 9);
        s.print(System.out);
        s.clear();
        input.nextLine();

        System.out.println();
        s.drawRectangle(1, 2, 5, 4);
        s.fillRectangle(3, 4);
        s.print(System.out);
        s.clear();
        input.nextLine();

        System.out.println();
        s.drawRectangle(4, 3, 9, 5);
        s.fillRectangle(6, 6);
        s.print(System.out);
        s.clear();
        input.nextLine();

        System.out.println();
        s.drawRectangle(4, 4, 8, 9);
        s.fillRectangle(6, 8);
        s.print(System.out);
        s.clear();
    }

    //precondition: Screen is blank (all white).
    //					 0 <= row < size, 0 <= col < size, height > 0, width > 0
    //postcondition: Draws the border of a rectangle with the given height
    //					  and width starting from the given upper left corner.
    //					  The rectangle is drawn by setting the appropriate cells
    //					  of myPixels to BLACK.  The rectangle may not entirely
    //					  fit on the screen, in which case only those parts of
    //					  the rectangle that do fit on the screen are drawn.
    public void drawRectangle(int row, int col, int height, int width) {


    }

    //precondition: A rectangle has been draw on the screen.
    //					 (row, col) is inside the rectangle--not on its border
    //postcondition: If the position is on the screen, change all the cells
    //					  that are inside the rectangle and on the screen from
    //					  WHITE to BLACK.  One possible algorithm for filling a
    //					  rectangle is to change (row, col) to BLACK, then recurse
    //					  on the four points adjacent to (row, col)--N, S, E, W
    public void fillRectangle(int row, int col) {


    }

    public void clear() {
        int j, k;
        int size = getSize();
        for (j = 0; j < size; j++) {
            for (k = 0; k < size; k++) {
                myPixels[j][k] = WHITE;
            }
        }
    }

    public void print(PrintStream out) {
        out.print("  ");
        for (int j = 0; j < getSize(); j++)
            out.print(" " + j + " ");
        out.println();
        for (int j = 0; j < getSize(); j++) {
            out.print(j + " ");
            for (int k = 0; k < getSize(); k++)
                out.print(myPixels[j][k] == WHITE ? " - " : " * ");
            out.println("\n");
        }
        out.println();
    }

    public int getSize() {
        return mySize;
    }
}