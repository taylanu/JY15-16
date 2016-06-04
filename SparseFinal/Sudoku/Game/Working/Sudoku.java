package Game.Working;

import dataStructure.SparseMatrix;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * Created by taylanu on 5/17/2016.
 */
public class Sudoku<anyType> extends JPanel{

    //Global Variables
    static File EASY1 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E1.txt");
    static File EASY2 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E2.txt");
    static File EASY3 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E3.txt");
    private JLabel label;
    private JPanel panel;
    static SparseMatrix<Integer> vals = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.
    static Scanner input = new Scanner(System.in);
    static int userval,usercol,userrow;
    static File temp = null;
    private static JButton[][] jboard;//use buttons to change values.
    //Global Variables

    public Sudoku(){//builds game
        setLayout(new BorderLayout());
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        add(north, BorderLayout.NORTH);
        label = new JLabel("Welcome to tSudo");
        north.add(label);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(9,9));
        add(center, BorderLayout.CENTER);

        jboard = new JButton[9][9];
        for(int r = 0; r < 9; r++)
            for(int c = 0; c < 9; c++){
                jboard[r][c] = new JButton();
                //jboard[r][c].
                jboard[r][c].setBackground(Color.lightGray);
               // board[r][c].addActionListener( new Handler1(r, c) );
                center.add(jboard[r][c]);
            }
    }

    public static void readFile(File d) throws IOException {
        Scanner input = new Scanner(new FileReader(d));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81){break;}//kills off process if file corrupted

            int r = 0, c = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        char curr = temp.charAt(i);
                        if (curr <= '9') {
                            int num = Integer.parseInt("" + curr);
                            if (c > vals.numColumns()) {
                                c = 1;
                                r++;
                            }
                            vals.add(r, c, num);
                            c++;
                        }
                    }
                }
}

    public static void isComplete(){
        if(vals.isFull()) {
            System.out.println("GAME OVER!");
            vals.clear();
        }
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

    public static void modVal(int r,int c,int x){
        boolean validRow = r >= 1 && r <= 9;
        boolean validColumn = c >= 1 && c <= 9;
        boolean validValue = x >= 1 && x <= 9;

        if (validRow && validColumn && validValue)
            vals.set(r, c, x);
    }

    public static void startMessage(){
    System.out.println("\n\n\n");
    System.out.println("                            tSUDO                               ");
    System.out.println("                        ---------------                         ");
    System.out.println("                     By: Taylan Unal                            ");
    System.out.println("                       APCS A 2015-16                           ");
    System.out.println("                        ---------------                         ");
    System.out.println("     Instructions:                                              ");
    System.out.println("     Use the arrow keys to move around the grid and use the     ");
    System.out.println("     number keys to enter numbers in the game grid.             ");
    System.out.println("                        ---------------                         ");
    System.out.println("          What Board Would You Like To Play?                    ");
    System.out.println("                      (1,2,3)                                   ");
    }

    public static void userInput() throws IOException{
        System.out.println("What row would you like to add to?");
        userrow = input.nextInt();
        System.out.println("What column would you like to add to?");
        usercol = input.nextInt();
        System.out.println("What value would you like to enter?");
        userval = input.nextInt();
        modVal(userrow,usercol,userval);
    }
    
    public static void selectGame(){
        int selected = input.nextInt();
        if(selected==1) {temp=EASY1;}if(selected==2) {temp=EASY2;}if(selected==3) {temp=EASY3;}
    }

    public static void gameLoop() throws IOException {
        int count = 1;
        do {System.out.println("Move: " + count);System.out.println(vals);
            userInput();
            System.out.println("Move: " + count);
            System.out.println(vals);
            isComplete();
            count++;}
        while(count<10);//to be modified to checking if board is valid/complete
    }
    public static void main(String[] arg) throws IOException {
       // GUI();
        startMessage();
        selectGame();
        readFile(temp);//builds the grid for the first time
        gameLoop();
    }
}