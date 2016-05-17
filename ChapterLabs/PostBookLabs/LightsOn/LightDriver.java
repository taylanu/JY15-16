import java.util.Scanner;

//Taylan Unal APCS 2016
//n generally means number. num feels too extraneous.
public class LightDriver {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] arg) {

        //Test 1 for 20 students pulling strings and 100 bulbs in the hallway.
        int nBulb1 = 100;//100 bulbs
        int nStudents1 = 20; //20 students

        LightBulb[] h1 = new LightBulb[nBulb1];//h1 short for hallway1
        for (int i = 0; i < h1.length; i++)//Creating instances of bulbs
            h1[i] = new LightBulb();

        System.out.println("With " + nBulb1 + " bulbs in the hallway and " + nStudents1 + " pulling strings..");
        System.out.println(lightSwitcher(h1, nStudents1) + " lights were turned on.");

        //Test 2 for random number of students in the hall between 100-1500 and random number of students from 10-150.
        int nBulb2 = (int) (Math.random() * 1500) + 100;//minimum of 100, and max of 1500 bulbs.
        int nStudents2 = (int) (Math.random() * 150) + 10;

        LightBulb[] h2 = new LightBulb[nBulb2];//h2 short for hallway2
        for (int i = 0; i < h2.length; i++)//creates instances of bulbs for hallway2
            h2[i] = new LightBulb();

        System.out.println("With " + nBulb2 + " bulbs in the hallway and " + nStudents2 + " pulling strings..");
        System.out.println(lightSwitcher(h2, nStudents2) + " lights were turned on.");
        //System.out.println(numStudents);
    }

    public static int lightSwitcher(LightBulb[] light, int students) {

        for (int i = 1; i <= students; i++) {
            for (int j = 1; j <= light.length; j++) {
                if (j % i == 0)
                    light[j - 1].pullString();
            }
        }
        int count = 0;
        for (int i = 0; i < light.length; i++) {//after students pass, checks for number of lights that are turned on.
            if (light[i].isOn())
                count++;
        }
        return count;//final returns the number of bulbs turned on.
    }
}
