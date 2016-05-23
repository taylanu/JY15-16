package Board;

import dataStructure.SparseMatrix;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by taylanu on 5/17/2016.
 */
public class easyBoard {

    static String path = "C:\\Users\\taylanu\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Board\\test";
    static File file = new File(path);
    static SparseMatrix<Integer> sudoku = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.

    public static void readFile() throws IOException {
        Scanner input = new Scanner(new FileReader(file));
        while(input.hasNextLine()) {
            String temp = input.nextLine();
            if (temp.length() != 81)//kills off process if file corrupted
                break;
            int r = 0, c = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        char curr = temp.charAt(i);
                        if (curr > '0' && curr <= '9') {
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

    public static int getFileSize(String fileName) throws IOException {//confirmed that getfilesize is working properly to return line count
        Scanner input = new Scanner(new FileReader(fileName));
        int size = 0;
        while (input.hasNext()){
            size++;
            input.next();//add to the size
        }
        input.close();
        return size;
    }


    public static void main(String[] arg) throws IOException {


        readFile();//builds the board
        System.out.println(sudoku);              //finally, show the contents of the sparse matrix

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
       }*/