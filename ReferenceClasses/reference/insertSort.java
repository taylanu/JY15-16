package reference;

public class insertSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0; j--)
                if (a[j - 1].compareTo(a[j]) > 0)
                    swap(a, j, j - 1);
                else break;
    }

    public static void swap(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
