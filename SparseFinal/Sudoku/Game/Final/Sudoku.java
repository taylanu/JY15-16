package Game.Final;

import dataStructure.SparseMatrix;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by taylanu on 5/17/2016.
 * 6/5/16 decided to replace all ints with bytes to stick to the ideals of a memory efficient game
 * 6/7/16 This edition will have all functions that facilitate GUI removed.
 * 6/7/16 This edition will also have all nonessential methods and variables trimmed.
 * 6/9/16 Due Date. Final Edition.
 */
public class Sudoku<anyType> extends JComponent{

    //Global Variables
    private static final File EASY1 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E1.txt");
    private static final File EASY2 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E2.txt");
    private static final File EASY3 = new File("C:\\Users\\tayla\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Game\\EasyBoards\\E3.txt");
    private static final SparseMatrix<Byte> play = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.
    private static final Scanner input = new Scanner(System.in);
    private static File temp = null;
    private static boolean playing = false;
    //Global Variables

    //pre: Depends startMessage(), selectGame(), readFile(), and gameLoop() to be working
    //post: Runs methods and plays Sudoku
    public static void main(String[] arg) throws IOException {
        startMessage();
        selectGame();
        readFile(temp);//builds the grid for the first time
        gameLoop();
    }

    //pre: Requires valid row and column values
    //post: Returns boolean value if position at row,column is valid according to rules of Sudoku.
    private static boolean isValid(byte r, byte c) {
        String temp="";
        for (byte i=0;i<9;i++) {
            temp += Byte.toString(play.get(i, c));//horizontal check
            temp += Byte.toString(play.get(r, i));//vertical check
            temp += Byte.toString(play.get((r / 3) * 3 + i / 3, (c / 3) * 3 + i % 3));//3*3 square check
        }
        int count=0, index=0;
        while ((index = temp.indexOf(Byte.toString(play.get(r, c)), index)) != -1) {
            index++;
            count++;
        }
        return count==3;
    }

    //pre: Depends on user input through Scanner. Depends on selectGame() functioning properly
    //post: Reads given file line by line and fills SparseMatrix with values read in from file.
    private static void readFile(File d) throws IOException {
        Scanner input = new Scanner(new FileReader(d));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81) {
                break;
            }//kills off process if file corrupt

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

    //pre: Depends on functioning isValid() method
    //post: Scans through entire SparseMatrix using isValid and returns boolean value
    private static boolean isComplete(){
        for(byte r = 0; r < 9; r++)
            for(byte c = 0; c < 9; c++)
                if(isValid(r,c))
                    return true;
        return false;
    }

    //pre: accepts values for row, column, and value to be placed
    //post: In SparseMatrix, modifies value at row and column to value x
    private static void modVal(byte r, byte c, byte x){
        boolean validRow = r >= 0 && r <= 9;
        boolean validColumn = c >= 0 && c <= 9;
        boolean validValue = x >= 1 && x <= 9;

        if ((validRow && validColumn && validValue) /*&& isValid(r,c)*/)//checks if the inputs are valid in general
            play.set(r, c, x);
        else
            System.out.println("\nInvalid Move!\n");
    }

    //pre: No conditions required to run StartMessage
    //post: Is called in main method to introduce game to players
    private static void startMessage(){
    System.out.println("\n\n\n");
        System.out.println("     Please expand console to fullscreen for best experience    ");
    System.out.println("                         tSUDO                                  ");
    System.out.println("                    ---------------                             ");
    System.out.println("                    By: Taylan Unal                             ");
    System.out.println("                    APCS A 2015-16                              ");
    System.out.println("                    ---------------                             ");
    System.out.println("     Instructions:                                              ");
    System.out.println("     Use the arrow keys to move around the grid and use the     ");
    System.out.println("     number keys to enter numbers in the game grid.             ");
        System.out.println("     Please note that both rows and columns start at 0, in      ");
        System.out.println("     true Computer Scientist fashion.                           ");
    System.out.println("                        ---------------                         ");
    System.out.println("          What Board Would You Like To Play?                    ");
        System.out.println("                      (1,2,3)                                 \n");
    }

    //pre: Requires Scanner for user input. Requires modVal() to be functioning
    //post: Modifies value at row and column with value provided using modVal() method
    private static void userInput() {
        System.out.println("What row would you like to add to?");
        byte userrow = input.nextByte();
        System.out.println("What column would you like to add to?");
        byte usercol = input.nextByte();
        System.out.println("What value would you like to enter?");
        byte userval = input.nextByte();
        modVal(userrow, usercol, userval);
    }

    //pre: Requires user input through Scanner. File paths must be defined properly.
    //post: Sets temp File value to selected file path to be read into ReadFile
    private static void selectGame(){
        int selected = input.nextInt();
        if(selected==1) {temp=EASY1;}if(selected==2) {temp=EASY2;}if(selected==3) {temp=EASY3;}
    }

    //pre: Requires isComplete method and functioning Scanner method
    //post: Will run Sudoku game until completion.
    private static void gameLoop() {
        int count = 2;
        System.out.println("Move: 1");
        System.out.println(play);
        while (count < 243) {
            userInput();
            if (playing == false) {
                if(isComplete())
                    System.out.println("Congratulations \n GAME OVER");
                else{
                    System.out.println("Thanks for playing. Try Again!");
                }
                System.exit(-1);
            }
            System.out.println("Move: " + count);
            System.out.println(play);
            count++;
        }
    }

}