package Game;

import dataStructure.SparseMatrix;
import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JComponent;

import static Game.PRESudokuGame.file;

/**
 * Created by taylanu on 5/17/2016.
 */
public class Sudoku extends JComponent{

    static File EASY1 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E1.txt");
    static File EASY2 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E2.txt");
    static File EASY3 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E3.txt");
    static SparseMatrix<Integer> sudoku = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.
    static Scanner input = new Scanner(System.in);
    static int userval,usercol,userrow;

    public static void readFile(File d) throws IOException {
        //fc.showOpenDialog(comp);
        //int returnVal = fc.showDialog(FileChooserDemo2.this, "Attach");

        Scanner input = new Scanner(new FileReader(d));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81){break;}//kills off process if file corrupted

            int r = 0, c = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        char curr = temp.charAt(i);
                        if (curr <= '9') {
                            int num = Integer.parseInt("" + curr);
                            if (c > sudoku.numColumns()) {
                                c = 1;
                                r++;
                            }
                            sudoku.add(r, c, num);
                            c++;
                        }
                    }
                }
}

    public static void GUI(){
        JFrame frame = new JFrame("tSudo");    //window title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sudoku);
        frame.pack();
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
            sudoku.set(r, c, x);
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
    @Deprecated
    public static void playGame() throws IOException {
    }
    public static void userInput(){
        System.out.println("What row would you like to add to?");
        userrow = input.nextInt();
        System.out.println("What column would you like to add to?");
        usercol = input.nextInt();
        System.out.println("What value would you like to enter?");
        userval = input.nextInt();
        modVal(userrow,usercol,userval);
    }
    public static boolean isComplete(){
//if(int i=i;i<)
        return false;

    }
    public static void main(String[] arg) throws IOException {
        //GUI();
        File temp = null;
        startMessage();
        int selected = input.nextInt();
        if(selected==1) {temp=EASY1;}if(selected==2) {temp=EASY2;}if(selected==3) {temp=EASY3;}
        System.out.println("Move: 1");
        readFile(temp);//builds the grid for the first time
        System.out.println(sudoku);


        //readFile();//builds the initial board

        int count = 2;
        while(count<10){
            userInput();
            System.out.println("Move: " + count);
            System.out.println(sudoku);
            count++;
        }

        //System.out.println(sudoku);              //finally, show the contents of the sparse matrix
    }
}