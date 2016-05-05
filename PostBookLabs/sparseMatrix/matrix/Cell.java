package matrix;

public class Cell<anyType> {
	int row;
	int col;
	anyType val;
	
	public Cell(int r, int c, anyType v){//constructor
		row = r;
		col = c;
		val = v;
	}
	
	public String toString() {
		return "Cell []";//unsure what Cell should print on toString.
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int r) {
		row = r;
	}

	/**
	 * @return the column
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the column to set
	 */
	public void setCol(int c) {
		col = c;
	}

	/**
	 * @return the value
	 */
	public anyType getVal() {
		return val;
	}

	/**
	 * @param set the value to val
	 */
	public void setVal(anyType v) {
		val = v;
	}
}