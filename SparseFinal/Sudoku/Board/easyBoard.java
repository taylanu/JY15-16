package Board;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import dataStructure.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.io.*;

/**
 * Created by taylanu on 5/17/2016.
 */
public class easyBoard {

    public static void main(String[] arg) throws IOException{
        SparseMatrix<Integer> sudoku = new SparseMatrix(9, 9);//board is 9*9
        boolean randfill = true;
        /*//commented out temporarily to test file read in.
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (randfill == true)
                    sudoku.add(r, c, (int) (Math.random() * 9) + 1);
                //else
                //    sudoku.add(r,c,"");
                randfill = !randfill;
            }
        }
        */
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                FileReader()
            }
        }
        System.out.println(sudoku);              //finally, show the contents of the sparse matrix

    }
}
