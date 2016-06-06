package dataStructure;

public interface Matrixable<anyType> {
    anyType get(int r, int c);                //returns the element at row r, col c

    anyType set(int r, int c, anyType x);    //changes element at (r,c), returns old value

    boolean add(int r, int c, anyType x);       //adds obj at row r, col c

    anyType remove(int r, int c);

    //anyType clone();

    int size();            //returns # actual elements stored

    int numRows();        //returns # rows set in constructor

    int numColumns();    //returns # cols set in constructor

    void clear();                            //clears all elements out of the list

    boolean contains(anyType x);        //true if x exists in list

    boolean isEmpty(Cell<anyType> anyTypeCell);                    //returns true if there are no actual elements stored

    int[] getLocation(anyType x);    //returns location [r,c] of where x exists in list, null otherwise

    Object[][] toArray();                //returns equivalent structure in 2-D array form

    void setBlank(char blank);
}
