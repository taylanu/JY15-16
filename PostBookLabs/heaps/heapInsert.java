
public class heapInsert {
	public void heapInsert(Comparable x){
		if(size == heap.length - 1) doubleSize();

		//Insert a new item to the end of the array
		int pos = ++size;

		//Percolate up
		for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
			heap[pos] = heap[pos/2];

		heap[pos] = x;
	}
}
