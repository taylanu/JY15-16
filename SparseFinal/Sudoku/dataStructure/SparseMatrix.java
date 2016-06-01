package dataStructure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SparseMatrix<anyType> extends JComponent implements Matrixable<anyType> {
    //needs to have util imported.
    //COMMENT.
    private int numRows, numCols;
    private ArrayList<Cell<anyType>> list = new ArrayList<Cell<anyType>>();//create Cells that will contain points


    public SparseMatrix(int r, int c) {
        numRows = r;
        numCols = c;
        list = new ArrayList<Cell<anyType>>();
    }

    @Override
    public String toString() {//prints array ask RevO about 2d
        String str = "";
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                int index = -1;
                for (int i = 0; i < list.size(); i++) {
                    if (((r * numCols) + c) == (((Cell) list.get(i)).getKey())) {
                        str += (((Cell) list.get(i)).getVal());
                        index = i;
                    }
                }
                if (index == -1) {
                    str += "-";
                }
                str += "\t";
            }
            str += "\n";
        }
        return str;
    }

    public anyType get(int r, int c) {//complete
        int key = r * numCols + c;
        for (int i = 0; i < list.size(); i++) {
            if (key == ((Cell) list.get(i)).getKey()) {//(temp.getRow()==r && temp.getCol()==c)
                return list.get(i).getVal();
            }
        }
        return null;
    }
   /* public anyType[] getRow(int r){

    }*/

    public anyType set(int r, int c, anyType x) {
        // temp = null;
        Cell<anyType> temp = new Cell<anyType>(r, c, numCols, x);
        int key = r * numCols + c;
        for (int i = 0; i < list.size(); i++) {
            if (key == ((Cell) list.get(i)).getKey()) {
                anyType replace = list.get(i).getVal();//swap method of sorts
                list.set(i, temp);
                return replace;
            }
        }
        return null;//should be old value, so build a temp value to store old value
    }
    public boolean isMutable(int r,int c){
        return false;
    }

    public boolean add(int r, int c, Object x) {
        Cell sub = new Cell(r, c, numCols, x);
        int key = r * numCols + c;
        for (int i = 0; i < list.size(); i++) {
            if (key <= ((Cell) list.get(i)).getKey()) {
                list.add(i, sub);
                return true;
            }
        }
        list.add(sub);
        return true;
    }


    public anyType remove(int r, int c) {
        int key = (r * numCols) + c;
        for (int i = 0; i < list.size(); i++) {
            if (key == ((Cell) list.get(i)).getKey()) {
                Object temp = list.get(i).getVal();
                list.remove(i);
                return (anyType) temp;
            }
        }
        return null;
    }

    public int listSize() {
        return list.size();
    }

    public int numRows() {
        return numRows;
    }


    public int numColumns() {
        return numCols;
    }


    public void clear() {
        list.clear();
    }


    public boolean contains(anyType x) {
        // TODO Auto-generated method stub
        return list.contains(x);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int[] getLocation(anyType x) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == x)
                return null;
        return null;
    }


    public void setBlank(char blank) {//what do I need to set blank
        /*for(int r=0;r<list.size();r++)
            for(int c)*/
    }

    public Object[][] toArray() {
        // TODO Auto-generated method stub
        return null;
    }
}