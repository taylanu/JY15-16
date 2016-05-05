package matrix;
import java.util.*;

public class SparseMatrix<anyType> implements Matrixable<anyType>{
	//needs to have util imported.
	//COMMENT.
	
	private int numElements;
	private ArrayList<Cell<anyType>> list = new ArrayList<Cell<anyType>>();//create Cells that will contain points
	private int numRows;
	private int numCols;
	
	public SparseMatrix(int r, int c) {
		numElements = 0;
		numRows = r;
		numCols = c;
		ArrayList<Integer> keys = new ArrayList(r*c);
		
		for(int i=0;i<keys.size();i++){//list of keys that exist within the data structure.
		}
	}

	
	public anyType get(int r, int c) {//complete
		Cell<anyType> temp = null;
		Cell<anyType> returnTemp = null;
		for(int i = 0; i<list.size();i++){
			temp = list.get(i);
			returnTemp = temp;
			if(temp.getRow()==r && temp.getCol()==c){
				return (anyType) temp;
			}
		}
		return (anyType) returnTemp;
	}

	
	public anyType set(int r, int c, Object x) {
		// temp = null;
		Cell<anyType> returnTemp = null;
		for(int i=0;i<list.size();i++){
			Cell<anyType> c1 = list.get(i);
			returnTemp = list.get(i);
			if(returnTemp.getRow()==r && returnTemp.getCol()==c){
				c1 = list.get(i);
			}
		}
		return (anyType) returnTemp;//should be old value, so build a temp value to store old value
	}

	
	public void add(int r, int c, Object x) {
		//Cell<anyType> temp = null;
		//Cell<anyType> returnTemp = null;
		for(int i=0; i<list.size();i++){
			//temp = list.get(i);
			//if(temp.getRow()==r && temp.getCol()==c){
			//	list.add((Cell<anyType>) x);
			//}
		}
	}
		
	
	public anyType remove(int r, int c) {
		anyType temp = null;
		for(int i=0;i<list.size();i++){
			if(i.getRow()==r && i.getCol()==c){
				temp = (anyType) i.getVal();
				list.remove(i);
				//return (anyType) i.getVal();
			}
		}
		return (anyType) "debug";
	}

	
	public int size() {return list.size();}

	
	public int numRows() {return numRows;}

	
	public int numColumns() {return numCols;}

	
	public void clear() {list.clear();}

	
	public boolean contains(anyType x) {
		// TODO Auto-generated method stub
		if(list.contains(x))
			return true;
		return false;
	}

	public boolean isEmpty() {
		if(list.isEmpty())
			return true;
		return false;
	}

	public int[] getLocation(anyType x) {
		for(int i=0;i<list.size();i++)
			if(list.get(i) == x)
				return null;
		return null;
	}
}
