import java.util.Scanner;

public class DoubleSort {

    public static void main(String arg[]) {

        double[] doubleList = new double[10];
        double avg;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i <= 9; i++) {
            System.out.println("Enter a decimal number");
            doubleList[i] = input.nextDouble();
        }

        avg = findAvg(doubleList);
        System.out.println("The average for your set is " + avg);
        System.out.println("The numbers in your set that were greater than the average were");

        for (int i = 0; i <= 9; i++) {
            if (doubleList[i] > avg)
                System.out.print(doubleList[i] + "\t");
        }
    }

    public static double findAvg(double[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum / list.length;
    }

}
