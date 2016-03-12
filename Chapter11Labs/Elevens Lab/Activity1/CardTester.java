package Activity1;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card one = new Card("King","Spades",10);
		Card two = new Card("Three","Diamonds",3);
		Card three = new Card("Ace","Spades",1);
		System.out.println(one.matches(two));
		System.out.println(one.matches(three));
		System.out.println(two.matches(three));
		one.toString();
		two.toString();
		three.toString();
	}
}
