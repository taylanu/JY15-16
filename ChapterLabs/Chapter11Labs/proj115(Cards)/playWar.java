package proj115;

public class playWar {

    public static void main(String[] args) {

        Deck deck = new Deck();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        ArrayList<Card> war1 = new ArrayList<Card>();
        ArrayList<Card> war2 = new ArrayList<Card>();
        ArrayList<Card> win1 = new ArrayList<Card>();
        ArrayList<Card> win2 = new ArrayList<Card>();

        deck.shuffle();
        for (int i = 0; i < 26; i++) {
            hand1.add(0, deck.deal());
            hand2.add(0, deck.deal());
        }

        play(hand1, hand2, war1, war2, win1, win2);
        System.out.println("\n\n\n" + win1);
        System.out.println(win2);
        if (win1.size() > win2.size()) {
            System.out.println("Player 1 wins!");
        } else if (win2.size() > win1.size()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void play(ArrayList<Card> hand1, ArrayList<Card> hand2, ArrayList<Card> war1, ArrayList<Card> war2, ArrayList<Card> win1, ArrayList<Card> win2) {
        while (!hand1.isEmpty()) {//plays as long as one player hasn't already lost.
            war1.add(0, hand1.remove(0));
            war1.get(0).turn();

            war2.add(0, hand2.remove(0));
            war2.get(0).turn();

            System.out.println("\n\n\n" + war1);
            System.out.println(war2);
            int count = war1.size();

            if (war1.get(0).compareTo(war2.get(0)) > 0) {
                for (int i = 0; i < count; i++) {
                    win1.add(0, war1.remove(0));
                    win1.add(0, war2.remove(0));
                }
                System.out.println(win1 + "\n" + win2);

            } else if (war2.get(0).compareTo(war1.get(0)) > 0) {
                for (int i = 0; i < count; i++) {
                    win2.add(0, war2.remove(0));
                    win2.add(0, war1.remove(0));
                }
                System.out.println(win1 + "\n" + win2);
            } else {
                play(hand1, hand2, war1, war2, win1, win2);
            }

        }
    }
}
