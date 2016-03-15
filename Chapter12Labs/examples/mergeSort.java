package examples;
//smarter perfectShuffle
//http://www.java-tips.org/java-se-tips-100019/24-java-lang/1895-merge-sort-implementation-in-java.html
public class mergeSort {
	private static void mergeSort(int low, int high){
		if(low>high){
			int middle = low + (high-low)/2;
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			//merge(low,middle,high);
		}
	}

	private static int[] merge(int[] left, int[] right) {
		int[] temp = new int[left.length + right.length];
		int x=0, y = 0;//iterators
		while(left[x]<left.length && right[y]<right.length){
			if(left[x]<right[y])
			x++;
			y++;
		}
		return temp;
		// TODO Auto-generated method stub
		
	}
}
