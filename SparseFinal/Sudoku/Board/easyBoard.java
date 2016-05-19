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

    static String filename = "C:\\Users\\taylanu\\Documents\\JY15-16\\SparseFinal\\Sudoku\\Board\\trimvals";
    static File file = new File(filename);
    static SparseMatrix<Integer> sudoku = new SparseMatrix(9, 9);//board is 9*9 This is a global variable.

    public static Integer[] readFile(String f) throws IOException {
        int index = 0;
        int size = getFileSize(filename);
        Integer[] list = new Integer[size];
        int val = 0;
        Scanner reader = new Scanner(new FileReader(filename));
        do if (reader.nextInt() == 0) {
            list[index] = 0;
            index++;
        } else {
            val = reader.nextInt();
            list[index] = val;
            index++;
        }
            while (reader.hasNext()) ;
    reader.close();
    return list;
}

    public static int getFileSize(String fileName) throws IOException {//confirmed that getfilesize is working properly
        Scanner input = new Scanner(new FileReader(fileName));
        int size = 0;
        while (input.hasNext()){
            size++;
            input.next();//add to the size
        }
        input.close();
        return size;
    }

   /* public static void toMatrix(SparseMatrix<Integer> s) throws IOException {
        Scanner input = new Scanner(new FileReader(filename));
        int index = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (index <= 81) {
                    if (input.nextInt() == 0) {
                        s.add(r, c, "-");
                        index++;
                    } else {
                        s.add(r, c, input.next());
                        index++;
                    }
                }
            }
        }
    }
*/

    public static void main(String[] arg) throws IOException {
        //SparseMatrix sudoku = new SparseMatrix(9,9);//board is 9*9 Moved to class value
       // input = new Scanner(new FileReader(filename));// concept should work
        /*//commented out temporarily to test file read in.
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (randfill == true)
                    sudoku.add(r, c, (int) (Math.random() * 9) + 1);
                //else
                //    sudoku.add(r,c,"");
                randfill = !randfill;
            }
        }*/

        System.out.println(sudoku);              //finally, show the contents of the sparse matrix
        System.out.println(getFileSize(filename));
    }

}
