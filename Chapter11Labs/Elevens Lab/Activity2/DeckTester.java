package Activity2;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck one = new Deck(args, args, null);
		Deck two = new Deck(args, args, null);
		Deck three = new Deck(args, args, null);
		System.out.println(one.isEmpty());
		System.out.println(two.isEmpty());
		System.out.println(three.isEmpty());
		one.toString();
		two.toString();
		three.toString();
	}
}
