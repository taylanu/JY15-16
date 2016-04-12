package priorityQ_STUDENT;

//Rev Dr. D. R. Oberle  Feb 2015
import java.util.*;
//Guide:
//parent = (p-1)/2
//leftSibling = i-1
//rightSibling = i+1
//leftChild = i*2+1
//rightChild = i*2+2
public class HeapPriorityQueue implements PriorityQueue{
   private static final int DFLT_CAPACITY = 1024;
   private Comparable [] items;		//index 0 will go unused
   private int numItems;

   public HeapPriorityQueue(int initialCapacity){
      items = new Comparable[initialCapacity + 1];
      numItems = 0;
   }

   public HeapPriorityQueue()
   {
      this(DFLT_CAPACITY);
   }

   @Override
   public boolean isEmpty()
   {return (numItems == 0);}

   @Override
   public Comparable peek(){
      if (numItems == 0)
      {
         throw new NoSuchElementException();
      }
   
      return items[1];
   }
   
   private void reheapDown(){//used when removing top element from heap. 
   //copy last element into root, remove the last element.
   //Reheap-Down: continually swap the new element with the higher-priority of its two children until its children are lower-priority, or it doesnt have any children.
   //OMG - YOU HAVE TO WRITE THIS!	
   //removes head and then adjusts
   int index = 1;//first element disregarding the unused 0 value
   	while((index!=items.length) && (items[index]) 
   		swap([],a,b);
   }
   
   //http://cs.fit.edu/~ryan/java/programs/sort/HeapSort-java.html
   // Assuming that the root of the heap is the only element out of
 49    // place, restore the heap property:  data[Parent] >= data[Child]
 50    // O(log n)
 51   // private static void reheapDown (final int [] data, int size) {
 52     //  int root = 0;
 53      // while (2*root+1<size) {
 54 	 // Root is an interior node
 55      //    final int maxChild = largerChild (data, root, size);
 56 	 //final int r = data[root];
 57 	 //final int max = data[maxChild];
 58 
 59 	// if (r>=max) break;
 60 	 // swap
 61 	 //data[root] = max;
 62 	 //data[maxChild] = r;
 63       //   root = maxChild;
 64       //}
 65    //}
 66 
   
   private void reheapUp(){//used when adding elements to heap
   //HOLY CRAP - YOU HAVE TO WRITE THIS ONE TOO!
   //adds to end of the array, from left to right on lowest level of the tree
   //Reheap-up: continually swap the new element with its parent until its parent is higher priority, or it has no parent.
	int index = numItems;//start at 'bottom'
	  while((index != 1) && (items[index].compareTo(items[index / 2]) < 0 )){
		  //^^checks both that the index is not the head, and that the item referenced is not higher priority than its parent.
	         swap(items, index, index / 2);//swaps index and parent
	         index = index / 2;//index becomes parent
	     }
   }
   
   @Override
   public Comparable remove()
   {
      if (numItems == 0){
         throw new NoSuchElementException();
      }
   
      Comparable min = items[1];
      items[1] = items[numItems];
      numItems--;
      reheapDown();
      return min;
   }

   private static void swap(Comparable [] list, int a, int b)
   {
      Comparable temp = list[a];
      list[a] = list[b];
      list[b] = temp;
   }

   @Override
   public boolean add(Comparable obj){
      numItems++;
      if (numItems >= items.length)
         doubleCapacity();
      items[numItems] = obj;
      reheapUp();
      return true;
   }

   private static boolean lowerPriority(Comparable<Comparable> obj1, Comparable obj2)
   {	//we will consider that low value == high priority
      return (obj1.compareTo(obj2) > 0);
   }//ask about this method.

   @Override
   public String toString()
   {
      String ans = "[";
      for (int i = 1; i <= numItems; i++)
      {
         ans += items[i];
         if(i <= numItems-1)
            ans += ", ";   
      }
      return ans+"]";
   }

   private void doubleCapacity()
   {
      Comparable tempItems[] = new Comparable[2 * items.length - 1];
      for (int i = 0; i <= numItems; i++)
         tempItems[i] = items[i];
      items = tempItems;
   }
}

