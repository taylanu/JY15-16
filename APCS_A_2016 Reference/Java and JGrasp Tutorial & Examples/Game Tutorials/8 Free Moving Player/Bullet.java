public class Bullet extends Entity {
    private int power;    //the power of the bullet

    //pre: 	r and c must be valid indecies of the board in MyGridExample
    //			image must at least be of size 1 x 1 and contain String values of image file names
    //			ad >= 1
    public Bullet(String n, int X, int Y, int p, String[][] image, int ad) {
        super(n, X, Y, image, ad);
        power = p;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int p) {
        power = p;
    }
}