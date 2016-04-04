package myArrayList;

public class MyArrayList<anyType> implements ListInterface<anyType>{
      private Object[] list;		//stores the actual elements
      private int numElements;	//used to keep track of the number of valid elements in the list
   	
       public MyArrayList(){
         list = new Object[10];	//start with a buffer size of 10
         numElements = 0;
      }
   
       @Override
	public boolean add(anyType x) {
    	   if(numElements>=list.length)
    		   doubleCapacity();
    	list[numElements]=x;
    	numElements++;
		return true;
	}
      
       @Override
	public boolean add(int index, anyType x) {
		for(int i = list.length; i>index;i--){
			list[list.length]=list[list.length+1];//unsure if works.
		 }
		list[index]=x;
		return true;
	}
      
       private void cutCapacity(){//private because this is a helper method that need not be used outside of the class
           Object[] temp = new Object[list.length / 2];
           for(int i = 0; i < numElements; i++)
              temp[i] = list[i];
           list = temp;
      	//make list half as big, i.e. given [A, B, C, null, null, null, null, null], results with [A, B, C, null]
      	//to be used if after removing an element, we have less than 1/3 of the capacity of list being used
      }

	private void doubleCapacity(){	//private because this is a helper method that need not be used outside of the class
        Object[] temp = new Object[list.length * 2];
        for(int i = 0; i < numElements; i++)
           temp[i] = list[i];
        list = temp;
      	//make list twice as big, i.e. given [A, B, C, null], results with [A, B, C, null, null, null, null, null]
      	//to be used if we add an element that would be over the capacity of list
      }

	@Override
	public anyType get(int index) {//complete
			return (anyType) list[index];
	}

	@Override
	public anyType remove(int index) {
		anyType y = (anyType) list[index];
        for(int i = index; i < numElements - 1; i++)
           list[i] = list[i + 1];
        	list[numElements - 1] = null;
        	numElements--;
       if(numElements <= list.length / 2)
    	   cutCapacity();
       return y;
	}

	@Override
	public anyType set(int index, anyType x) {
		anyType y = (anyType) list[index];
		list[index]=x;
		return y;
	}
	
	@Override
	public int size() {
		return numElements;
	}

	@Override
	public String toString()
      {
         String ans = "[";
      	for (int i = 0; i < numElements; i++) {
			ans = ans + list[i]+ ",";
		}
		return ans + "]";
      }
      
   }