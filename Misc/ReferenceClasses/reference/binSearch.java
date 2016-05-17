package reference;

public class binSearch {
    public static int binarySearch(long[] a, long key) {
        int low = -1;
        int high = a.length;

        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (key > a[mid])
                low = mid;
            else
                high = mid;
        }
        if (a[high] == key)
            return high;
        else
            return (-high - 1);
    }
}
