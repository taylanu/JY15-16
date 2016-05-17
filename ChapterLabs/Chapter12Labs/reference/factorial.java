package reference;

public class factorial {
    public static long factorial(int n) {
        long prod = 1;
        for (int i = 1; i <= n; i++)
            prod *= i;
        return prod;
    }
}
