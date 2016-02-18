
public class selectionSort {

	public static void selectionSort(int[] a) {
		for(int i =0; i < a.length-1;i++){
			int minIndex = findMinimum(a,i);
			if(minIndex != i)
				swap (a,i,minIndex);
		}
	}

}
