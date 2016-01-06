import java.util.*;

public class proj31 {
    public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    double length, surfarea;
        System.out.println("What is the length of one side of the cube (in cm)");
        length = reader.nextDouble();
    surfarea = (length * length * 6);
        System.out.println("The cube's surface area is " + surfarea + " centimeters");
    }
}