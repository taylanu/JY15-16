package Activity4;

public class cleanDeckShuffle {
    public void cleanShuffle() {
        Deck standard = new Deck(str, str, num);
        System.out.println("How many times would you like to shuffle your fresh deck?");
        int numShuffle = input.nextInt();
        for (int i = 0; i < numShuffle; i++) {
            standard.shuffle();
            if (i > 3)
                System.out.println("After your " + i + "th Shuffle " + standard.toString());
            else if (i == 3)
                System.out.println("After your " + i + "rd Shuffle " + standard.toString());
            else if (i == 2)
                System.out.println("After your " + i + "nd Shuffle " + standard.toString());
            else
                System.out.println("After your " + i + "st Shuffle " + standard.toString());
        }
    }
}
