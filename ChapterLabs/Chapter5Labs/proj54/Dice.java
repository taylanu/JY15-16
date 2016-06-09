//Info Java
public class Dice {
    private int number;

    public Dice() {
        number = 1;
    }

    public int getNum() {
        return number;
    }

    public void roll() {
        number = (int) (Math.random() * 6) + 1;
    }


}
