import java.util.Scanner;

//Driver
public class LuckySeven {
    public static void main(String arg[]) {
        int initial, maxMon, roll, maxRoll, currentMon;
        Dice d1, d2;
        Scanner input;

        d1 = new Dice();
        d2 = new Dice();

        input = new Scanner(System.in);
        //Start
        System.out.println("Enter the initial amount of money: ");
        initial = input.nextInt();

        maxMon = initial;
        currentMon = initial;
        roll = 0;
        maxRoll = 0;

        while (currentMon > 0) {
            roll++;
            d1.roll();
            d2.roll();

            if (d1.getNum() + d2.getNum() == 7) {
                currentMon = currentMon + 4;
            } else {
                currentMon = currentMon - 1;
            }

            if (currentMon > maxMon) {
                maxMon = currentMon;
                maxRoll = roll;
            }
        }
        //Sad Trumpet
        System.out.println("You run out of money after " + roll + " rolls.\nYou should have quit at " + maxRoll + " rolls when you had $" + maxMon);
    }
}
