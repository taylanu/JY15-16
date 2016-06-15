public abstract class Animal {
    private String name;

    public Animal(String n) {
        name = n;
    }

    public abstract void move();

    public abstract void breed();

    public String toString() {
        return name;
    }
}