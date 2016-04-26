package matrix;
import java.util.*;

public class SparseMatrix<anyType> implements Matrixable<anyType>{
	/*public SparseMatrix(int i, int j) {
	// TODO Auto-generated constructor stub
	//builds 2D array for sparse matrix
//
}
*/
	private int numElements;
	private ArrayList<Cell<anyType>> list;//create Cells that will contain points
	private int numRows;
	private int numCols;
	
	public SparseMatrix(int r, int c) {
		// TODO Auto-generated constructor stub
		list = new ArrayList();
		numElements = 0;
		numRows = r;
		numCols = c;
		ArrayList<Integer> keys = new ArrayList(r*c);
		
		for(int i=0;i<keys.size();i++){//list of keys that exist within the data structure.
			
		}
	}

	@Override
	public anyType get(int r, int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public anyType set(int r, int c, Object x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int r, int c, Object x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public anyType remove(int r, int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numColumns() {
		// TODO Auto-generated method stub
		return 0;
	}
}
