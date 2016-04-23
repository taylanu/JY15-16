package reference;
//http://algs4.cs.princeton.edu/24pq/Heap.java.html
public class heaps {
	private heaps() { }
	public static void main(String[] args){
		String[] a = //input array
        heaps.sort(a);
        show(a);
	}
	public static int[] buildHeap(int[] x){
		return x;
		
	}
	public static void reheapUp(int n){
		
	}
	public static void reheapDown(int n){
		
	}
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
	public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            swap(pq, 1, N--);
            sink(pq, 1, N);
        }
    }
	private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            swap(pq, k, j);
            k = j;
        }
	}
	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i-1].compareTo(pq[j-1]) < 0;
	}
	
	private static void swap(Comparable[] pq, int i, int j) {
	      Comparable swap = pq[i-1];
	        pq[i-1] = pq[j-1];
	        pq[j-1] = swap;
	}
	
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
