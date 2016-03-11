
public class findMinimum {

	public static int findMinimum(int[] a, int first) {
		int minIndex = first;

		for(int i = first+1;i<a.length;i++)
			if(a[i] < a[minIndex])
				minIndex=i;
		return first;

	}

}
