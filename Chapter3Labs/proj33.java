/*
3-3: The kinetic energy of a moving object is given by the formula KE=(1/2)mv^2, where m is the object's
mass and v is its velocity. Modify the program of Chapter 2, Project 2-5, so that it prints the object's
kinetic energy as well as its momentum.
*/

import java.util.*;

public class proj33 {
    public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    double m, v, ke;
        System.out.println("What is the mass of of the object(in kg)");
    m = reader.nextDouble();
        System.out.println("What is the velocity of the object(in m/s)");
    v = reader.nextDouble();
    ke = (0.5 * m * v * v);
        System.out.println("The object's kinetic energy is " + ke + " Joules");
    }
}
/*
Open up 2-5 project.
*/