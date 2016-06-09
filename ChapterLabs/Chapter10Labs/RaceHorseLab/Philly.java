package RaceHorseLab;

public class Philly extends Horse {
    private int power;

    public Philly() {
        // Super method to call from Horse.
        super();
        power = (int) (Math.random() * 61) + 30;
    }

    public Philly(int loc, int i) {
        super(loc, i);
        power = (int) (Math.random() * 61) + 30;
    }

    @Override
    public void raceStride() {
        int rand = (int) (Math.random() * 100) + 1;
        if (rand < power) {
            super.advance();
        }
    }

    @Override
    public String toString() {
        String str = super.toString() + "*";//Concats the star to the end of the lane with Philly
        return str;
    }
}
