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
   
   while(index*2 <= numItems && (items[index].compareTo(items[index*2]) > 0 || items[index].compareTo(items[index * 2 + 1]) > 0)){
     if((index*2)+1 <= numItems){
      if(items[index*2].compareTo(items[index*2+1]) <= 0)
         {swap(items, index, index * 2);
         index = index*2;}
      else
         {swap(items, index, index*2 + 1);
         index = index*2+1;}
     }
     else if(index*2 == numItems){
      if(items[index*2].compareTo(items[index*2+1]) <= 0)
         {swap(items, index, index*2);
         index = index*2;}
     }      
   }
}
  
   
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

