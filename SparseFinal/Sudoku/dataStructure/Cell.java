package dataStructure;

public class Cell<anyType> {
	private int row, col, key;
	private anyType val;
	
	public Cell(int r, int c, int cols, anyType v){//constructor
		row = r;
		col = c;
		key = (r * cols) + c;//(r*numCols)+cols
		val = v;
	}
	
	public String toString() {
		return "Cell []";//unsure what Cell should print on toString.
	}
	public int getKey(){
		return key;
	}
	
	public void setKey(int k){
		key = k;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int r) {
		row = r;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int c) {
		col = c;
	}

	public anyType getVal() {
		return val;
	}

	public void setVal(anyType v) {
		val = v;
	}
}