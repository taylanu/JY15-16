package reference;

//example from a stackoverflow thread.
public class binConvert {
    public static int binConvert(int num) {
        if (num / 10 == 10)
            return (num % 10);
        else
            return binConvert(num / 10) + (num % 10);
    }
}
