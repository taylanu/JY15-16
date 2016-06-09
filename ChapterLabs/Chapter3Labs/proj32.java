/*
3-2: Write a program that takes the radius of a sphere (a double) as input and
outputs the sphere's diameter, circumference, surface area, and volume.
*/

import java.util.Scanner;

public class proj32 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double radius, surfarea, circum, vol, diam;
        System.out.println("What is the radius of the sphere? (in cm)");
        radius = reader.nextDouble();
        diam = (radius * 2);
        surfarea = (4 * Math.PI * (radius * radius));
        circum = (diam * Math.PI);
        vol = (4 / 3 * Math.PI * (radius * radius * radius));
        System.out.println("The sphere's diameter is " + diam + " centimeters");
        System.out.println("The sphere's circumference is " + circum + " centimeters");
        System.out.println("The sphere's surface area is " + surfarea + " centimeters");
        System.out.println("The sphere's volume is " + vol + " centimeters");
    }
}