package dataStructure;

/**
 * Created by taylanu on 5/17/2016.
 */

import dataStructure.*;

public class testBoard {//essentially SparseMatrixTester

    public static void main(String[] arg) {
        SparseMatrix<Integer> sudoku = new SparseMatrix(9,9);//board is 9*9
        boolean randfill = true;
        //unnecessary for now Integer potentialval = (int)(Math.random()*9)+1;
        //more complex looping filling of sparsematrix
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (randfill == true)
                    sudoku.add(r, c, (int) (Math.random() * 9) + 1);
                //else
                //    sudoku.add(r,c,"");
                randfill = !randfill;
            }
        }

        //sudoku.add(2, 1, 8);//primitive adds for testing
        //sudoku.add(0, 4, 2);
        //sudoku.add(3, 3, 4);
        //Integer temp1 = sudoku.get(2, 1);            //get the element at row 2, col 1
        //Integer temp2 = sudoku.set(0, 4, (int)(Math.random()*9)+1);    //change the element at row 0, col 4 to a D, return the old value

        System.out.println(sudoku);              //finally, show the contents of the sparse matrix

         /*
          should display something like:
      									0 1 2 3 4
      	- - - - D		or		 0         D
      	- - - - -             1
      	- A - - - 				 2   A
      	- - - - -				 3

      	*/

        //System.out.println(temp1);
        //System.out.println(temp2);
        //System.out.println(temp3);
    }
}
