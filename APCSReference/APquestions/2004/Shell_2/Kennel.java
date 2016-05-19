import java.util.ArrayList;

public class Kennel {
    private ArrayList petList;

    public Kennel() {
        petList = new ArrayList();
    }

    public static void main(String[] args) {
        System.out.println("******* A-2 *******");

        Kennel kennel = new Kennel();
        kennel.add(new Dog("Fido"));
        kennel.add(new Cat("Tommy"));
        kennel.add(new LoudDog("Barker"));
        kennel.allSpeak();
    }

    // A-2, (c)

    public void add(Pet pet) {
        petList.add(pet);
    }

    public void allSpeak() {

    }
}

