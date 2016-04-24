package binarybisection;

public class binHelper {
	private static int binHelper(int[]array, int key, int left, int right){
	     if(left > right)
	           return -1;			//key not found in array
	     int mid = (left+right)/2;	//find index in the middle of sub-array
	     if(array[mid] == key)
	           return mid;		//we found it – return its index
	     if(key < array[mid])		
	           return binHelper (array, key, left, mid - 1);       //search in left side
	     return binHelper (array, key, mid+1, right);            //search in right side
	}
	
	public static int binSearch(int[]array, int key){
	     return binHelper(array, key, 0, array.length -1);
	}

}
