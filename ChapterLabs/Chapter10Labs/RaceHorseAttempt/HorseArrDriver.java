package RaceHorseAttempt;

import RaceHorseLab.Philly;

//GIDDY UP!
public class HorseArrDriver {
    public static void main(String arg[]) {
        Philly h0, h1, h2;
        String str;

        h0 = new Philly(1, 0);
        h1 = new Philly(1, 1);
        h2 = new Philly(1, 2);

        str = race(h0, h1, h2);
        System.out.println(str);
    }

    public static String[] race(Philly[]) {

        System.out.println("\n\n\n" + h0 + "\n" + h1 + "\n" + h2);
        //Sets limit to horse's movement.
        while ((h0.getLocation() != 15) && (h1.getLocation() != 15) && (h2.getLocation() != 15)) {
            h0.raceStride();
            h1.raceStride();
            h2.raceStride();
            System.out.println("\n\n\n" + h0 + "\n" + h1 + "\n" + h2);
        }
        //Returned Messages at the end of the race//
        if ((h0.getLocation() == 15) && (h1.getLocation() == 15) && (h2.getLocation() == 15)) {
            return "It's a threeway tie!";
        } else if ((h0.getLocation() == 15) && (h1.getLocation() == 15) && (h2.getLocation() != 15)) {
            return "Horse 0 and Horse 1 have tied!";
        } else if ((h0.getLocation() == 15) && (h1.getLocation() != 15) && (h2.getLocation() == 15)) {
            return "Horse 0 and Horse 2 have tied!";
        } else if ((h0.getLocation() != 15) && (h1.getLocation() == 15) && (h2.getLocation() == 15)) {
            return "Horse 1 and Horse 2 have tied!";
        } else if ((h0.getLocation() == 15) && (h1.getLocation() != 15) && (h2.getLocation() != 15)) {
            return "Horse 0 has won!";
        } else if ((h0.getLocation() != 15) && (h1.getLocation() == 15) && (h2.getLocation() != 15)) {
            return "Horse 1 has won!";
        } else {
            return "Horse 2 has won!";
        }

    }
}
