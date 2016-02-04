package myArrayList;

    //create your own version of the ArrayList by completing this class definition
	 //look in ListInterface to see what methods you need to create
    
    public class MyArrayList<anyType> implements ListInterface<anyType>
   {
      private Object[] list;		//stores the actual elements
      private int numElements;	//used to keep track of the number of valid elements in the list
   	
       public MyArrayList()
      {
         list = new Object[10];	//start with a buffer size of 10
         numElements = 0;
      }
   
       private void doubleCapacity(){	//private because this is a helper method that need not be used outside of the class
    	  list = new Object[list.length*2];
      	//make list twice as big, i.e. given [A, B, C, null], results with [A, B, C, null, null, null, null, null]
      	//to be used if we add an element that would be over the capacity of list
      }
      
       private void cutCapacity()	//private because this is a helper method that need not be used outside of the class
      {
    	   numElements/=2;
      	//make list half as big, i.e. given [A, B, C, null, null, null, null, null], results with [A, B, C, null]
      	//to be used if after removing an element, we have less than 1/3 of the capacity of list being used
      }
      
       public String toString()
      {
         String ans = "[";
      	//add all array elements with a comma separating each, i.e. [A, B, C] 
         return ans + "]";
      }

	@Override
	public boolean add(anyType x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int index, anyType x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public anyType set(int index, anyType x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public anyType get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public anyType remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
      
   }