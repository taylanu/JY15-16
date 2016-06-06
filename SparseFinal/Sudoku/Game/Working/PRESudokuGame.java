package Game.Working;

import dataStructure.SparseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by taylanu on 5/17/2016.
 */
public class PRESudokuGame {
    static String path = "C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E1.txt";
    static File file = new File(path);
    static SparseMatrix<Byte> sudoku = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.
    static Scanner input = new Scanner(System.in);
    static byte userval,usercol,userrow;

    public static void readFile() throws IOException {
        //fc.showOpenDialog(comp);
        //char returnVal = fc.showDialog(FileChooserDemo2.this, "Attach");
        Scanner input = new Scanner(new FileReader(file));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81)//kills off process if file corrupted
                break;
            byte r = 0, c = 0;
                    for (byte i = 0; i < temp.length(); i++) {
                        char curr = temp.charAt(i);
                        if (curr <= '9') {
                            Byte num = Byte.parseByte("" + curr);
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
        frame.setSize(800, 800);                    //Size of game window
        frame.setLocation(100, 50);//location of game window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(sudoku);
        frame.setResizable(false);
        frame.setVisible(true);
        //frame.setContentPane(sudoku);
    }

    public static void modVal(byte r,byte c,byte x){
        boolean validRow = r >= 1 && r <= 9;
        boolean validColumn = c >= 1 && c <= 9;
        boolean validValue = x >= 1 && x <= 9;

        if (validRow && validColumn && validValue)
            sudoku.set(r, c, x);
    }

    public static void playGame() throws IOException {
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
        //System.out.println("\n\n\n\n\n\n");
        //System.out.println("Please press the Enter key to begin...                          ");
        readFile();//builds the grid for the first time
        userInput();
        System.out.println("Sudoku Board");//name of the grid
        System.out.println(sudoku);//prints the grid
        modVal(userrow,usercol,userval);
        System.out.println(sudoku);
    }
    public static void userInput(){
        System.out.println("What row would you like to add to?");
        userrow = input.nextByte();
        System.out.println("What column would you like to add to?");
        usercol = input.nextByte();
        System.out.println("What value would you like to enter?");
        userval = input.nextByte();
        if(isValid(userrow,usercol,sudoku));
    }

    public static boolean isValid(byte x, byte y, SparseMatrix s) {
        String temp="";
        for (byte i=0;i<9;i++) {
            //temp+=s.toString();//horizontal
            //temp+=s.toString();//vertical
            //temp+=s.toString((x/3)*3+i/3 + (y/3)*3+i%3);//square
        }
        byte count=0, index=0;
        //while ((index=temp.indexOf(Integer.toString(grid[x][y]), index))!=-1)
        {index++; count++;}
        return count==3;
    }

    public static void main(String[] arg) throws IOException {
        //GUI();
        //readFile();//builds the initial board
        playGame();

        //System.out.println(sudoku);              //finally, show the contents of the sparse matrix
    }

}
/*
        Scanner reader = new Scanner(new FileReader(file));
        //commented out temporarily to test file read in.
       boolean flip = true;
        int count = 0;
       while(count<=81) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if(flip==true)
                        sudoku.add(r, c, reader.nextLine());
                    count++;
                    flip=!flip;
                }
            }
       }
           @Deprecated
    public static int getLinesCount(String fileName) throws IOException {//confirmed that getfilesize is working properly to return line count
        Scanner input = new Scanner(new FileReader(fileName));
        int size = 0;
        while (input.hasNext()){
            size++;
            input.next();//add to the size
        }
        input.close();
        return size;
    }
    */
