package Shell_3;

public class RaceHorse implements Horse {
    private String name;
    private int weight;

    public RaceHorse(String _name, int _weight) {
        name = _name;
        weight = _weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + "/" + weight;
    }
}
