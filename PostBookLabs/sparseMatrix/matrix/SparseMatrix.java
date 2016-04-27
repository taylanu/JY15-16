package matrix;
import java.util.*;

public class SparseMatrix<anyType> implements Matrixable<anyType>{
	//needs to have util imported.
	//COMMENT.
	
	private int numElements;
	private ArrayList<Cell<anyType>> list;//create Cells that will contain points
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

	@Override
	public anyType get(int r, int c) {//complete
		for(Cell i : list)
			if(i.getRow()==r && i.getCol()==c)
				return (anyType) i.getVal();
		return null;
	}

	@Override
	public anyType set(int r, int c, Object x) {
		for(Cell i : list)
			if(i.getRow()==r && i.getCol()==c)
				i.setVal(x);
		return null;//should be old value, so build a temp value to store old value
	}

	@Override
	public void add(int r, int c, Object x) {
		for(Cell i : list)
			if(i.getRow()==r && i.getCol()==c)
				list.add((Cell<anyType>) x);
	}

	@Override
	public anyType remove(int r, int c) {
		anyType temp = null;
		for(Cell i : list)
			if(i.getRow()==r && i.getCol()==c){
				temp = (anyType) i.getVal();
				list.remove(i);
				//return (anyType) i.getVal();
			}
		return null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public int numRows() {
		return numRows;
	}

	@Override
	public int numColumns() {
		return numCols;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean contains(anyType x) {
		// TODO Auto-generated method stub
		if(list.contains(x))
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(list.isEmpty())
			return true;
		return false;
	}

	@Override
	public int[] getLocation(anyType x) {
		for(int i=0;i<list.size();i++)
			if(list.get(i) == x)
				return null;
		return null;
	}
}
