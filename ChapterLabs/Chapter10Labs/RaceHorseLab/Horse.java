package RaceHorseLab;

//NEIGH!
public class Horse {

    private int location, index;

    //Default Constructor
    public Horse() {
        location = 1;
        index = 0;
    }

    //Custom Constructor
    public Horse(int loc, int i) {
        location = loc;
        index = i;
    }

    //Getters
    public int getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }

    //Movement
    public void advance() {
        if (location < 15)
            location++;
    }

    public void raceStride() {
        int rand = (int) (Math.random() * 100) + 1;
        if (rand < 50)
            advance();
    }

    @Override
    public String toString() {
        String str = new String();
        String first = new String("");
        String second = new String("");
        if (location > 1) {
            for (int i = 1; i < location; i++) {
                first += "-";
            }
        }

        if (location < 15) {
            for (int i = location + 1; i <= 15; i++) {
                second = second + "-";
            }
        }
        str = "|S|" + first + index + second + "|F|";
        return str;
    }

}
