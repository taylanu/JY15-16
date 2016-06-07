package Game.Final;

import dataStructure.SparseMatrix;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by taylanu on 5/17/2016.
 * 6/5/16 decided to replace all ints with bytes to stick to the ideals of a memory efficient game
 */
public class Sudoku<anyType> extends JComponent{

    //Global Variables
    private static final File EASY1 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E1.txt");
    private static final File EASY2 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E2.txt");
    private static final File EASY3 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E3.txt");
    private JPanel panel;
    private static final SparseMatrix<Byte> play = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.
    static SparseMatrix<Byte> orig = new SparseMatrix<>(9,9);
    private static final Scanner input = new Scanner(System.in);
    private static byte userval;
    private static byte usercol;
    private static byte userrow;
    private static File temp = null;
    //Global Variables

    private Sudoku(){//builds game visuals.
        setLayout(new BorderLayout());
        JPanel board = new JPanel();
        board.setLayout(new FlowLayout());
        JLabel label = new JLabel("Welcome to tSudo");
        board.add(label);
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(9,9));
        add(center, BorderLayout.CENTER);

        JButton[][] jboard = new JButton[9][9];
        for(byte r = 0; r < 9; r++)
            for(byte c = 0; c < 9; c++){
                jboard[r][c] = new JButton();
                jboard[r][c].setBackground(Color.lightGray);
               // board[r][c].addActionListener( new Handler1(r, c) );
                center.add(jboard[r][c]);//finally adds the built board of jbuttons to the panel.
            }
    }

    public static boolean isValid(byte x, byte y) {//No Byte.tostring methods availible, so Integers will be used here.
        String temp="";
        for (byte i=0;i<9;i++) {
            temp+=Byte.toString(play.get(i,y));//horizontal check
            temp+=Byte.toString(play.get(x,i));//vertical check
            temp+=Byte.toString(play.get((x/3)*3+i/3,(y/3)*3+i%3));//square check
        }
        int count=0, index=0;
        while ((index=temp.indexOf(Byte.toString(play.get(x,y)), index)) != -1){
            index++;
            count++;
        }
        return count==3;
    }

    public static void printGrid (int[][] grid) {
        System.out.println();
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private void copy(SparseMatrix<Byte> from, byte[][] to) {//method for SparseMatrix to smaller 2D array 'quadrants'
        for (byte r = 0; r < 2; r++) {
            for (byte c = 0; c < 2; c++) {
                to[r][c] = from.get(r,c);
            }
        }
    }

    private void copy(SparseMatrix<Byte> from, SparseMatrix<Byte> to) {//method for full SparseMatrix to SparseMatrix
        for (byte r = 0; r < 9; r++)
            for (byte c = 0; c < 9; c++) {
                byte x=from.get(r,c);
                to.set(r,c,x);
            }
    }

    private static void readFile(File d) throws IOException {
        Scanner input = new Scanner(new FileReader(d));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81){break;}//kills off process if file corrupted

            int r = 0, c = 0;
                    for (byte i = 0; i < temp.length(); i++) {
                        char curr = temp.charAt(i);
                        if (curr <= '9') {
                            byte num = Byte.parseByte("" + curr);
                            if (c > play.numColumns()) {
                                c = 1;
                                r++;
                            }
                            play.add(r, c, num);
                            c++;
                        }
                    }
                }
}

    private static boolean isComplete(){
        for(byte r = 0; r < 9; r++)
            for(byte c = 0; c < 9; c++)
                if(isValid(r,c))
                    return true;
        return false;
    }

    public static void GUI(){
      /*  for(int i =0; i < 9;i++)//puts values from sparsematrix into gui
            for(int j=0; j < 9;j++)
                jboard[i][j]==vals.get(i,j);*/
        //Sudoku sudo = new Sudoku();
        JFrame frame = new JFrame("tSudo");    //window title
       // frame.add(sudo);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Sudoku<>());
        frame.setSize(800, 800);                    //Size of game window
        frame.setLocation(200, 200);//location of game window on the screen
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private static void modVal(byte r, byte c, byte x){
        boolean validRow = r >= 0 && r <= 9;
        boolean validColumn = c >= 0 && c <= 9;
        boolean validValue = x >= 1 && x <= 9;

        if ((validRow && validColumn && validValue) && isValid(r,c))//checks if the inputs are valid in general
            //if()//checks if move is valid for the board in general
            play.set(r, c, x);
        else
            System.out.println("\nInvalid Move!\n");
    }

    private static void startMessage(){
    System.out.println("\n\n\n");
    System.out.println("                         tSUDO                                  ");
    System.out.println("                    ---------------                             ");
    System.out.println("                    By: Taylan Unal                             ");
    System.out.println("                    APCS A 2015-16                              ");
    System.out.println("                    ---------------                             ");
    System.out.println("     Instructions:                                              ");
    System.out.println("     Use the arrow keys to move around the grid and use the     ");
    System.out.println("     number keys to enter numbers in the game grid.             ");
    System.out.println("                        ---------------                         ");
    System.out.println("          What Board Would You Like To Play?                    ");
    System.out.println("                      (1,2,3)                                   ");
    }

    private static void userInput() {
        System.out.println("What row would you like to add to?");
        userrow = input.nextByte();
        System.out.println("What column would you like to add to?");
        usercol = input.nextByte();
        System.out.println("What value would you like to enter?");
        userval = input.nextByte();
        modVal(userrow,usercol,userval);
    }
    
    private static void selectGame(){
        int selected = input.nextInt();
        if(selected==1) {temp=EASY1;}if(selected==2) {temp=EASY2;}if(selected==3) {temp=EASY3;}
    }

    private static void gameLoop() throws IOException {
        int count = 2;
        System.out.println("Move: 1");
        System.out.println(play);
        while(count < 10){//to be modified later to act as a check if board is valid/complete
            userInput();
            if(!isComplete())
                System.out.println("Congratulations \n GAME OVER");
            System.out.println("Move: " + count);
            System.out.println(play);
            count++;
        }
    }

    public static void main(String[] arg) throws IOException {
        //GUI();
        startMessage();
        selectGame();
        readFile(temp);//builds the grid for the first time
        gameLoop();

    }
}