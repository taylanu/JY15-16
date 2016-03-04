package myArrayList;

public class MyArrayList<anyType> implements ListInterface<anyType>
   {
      private Object[] list;		//stores the actual elements
      private int numElements;	//used to keep track of the number of valid elements in the list
   	
       public MyArrayList()
      {
         list = new Object[10];	//start with a buffer size of 10
         numElements = 0;
      }
   
       public boolean add(anyType x) {
		list[list.length+1]=x;
		return false;
	}
      
       public boolean add(int index, anyType x) {
		// TODO Auto-generated method stub
		for(int i = list.length; i>index;i--){
			list[list.length]=list[list.length+1];//unsure if works.
			//have to write in code to shift values to the right of array.
		}
		list[index]=x;
		return true;
	}
      
       private void cutCapacity()	//private because this is a helper method that need not be used outside of the class
      {
    	list = new Object[list.length/2];
      	//make list half as big, i.e. given [A, B, C, null, null, null, null, null], results with [A, B, C, null]
      	//to be used if after removing an element, we have less than 1/3 of the capacity of list being used
      }

	private void doubleCapacity(){	//private because this is a helper method that need not be used outside of the class
    			 list = new Object[list.length*2];
      	//make list twice as big, i.e. given [A, B, C, null], results with [A, B, C, null, null, null, null, null]
      	//to be used if we add an element that would be over the capacity of list
      }

	public anyType get(int index) {
		// TODO Auto-generated method stub
		return (anyType) list[index];
	}

	public anyType remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public anyType set(int index, anyType x) {
		// TODO Auto-generated method stub
		list[index]=x;
		return null;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return list.length;
	}

	public String toString()
      {
         String ans = "[";
      	for (int i = 0; i < list.length; i++) {
			ans+=list[i];
		}
		return ans + "]";
      }
      
   }