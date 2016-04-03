package Activity4;

import java.util.Scanner;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
static Scanner input = new Scanner(System.in);
	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();
		
}
	/*public void cleanShuffle(){
		Deck standard = new Deck(str, str, num);
		System.out.println("How many times would you like to shuffle your fresh deck?");
		int numShuffle = input.nextInt();
		for(int i = 0; i < numShuffle; i++){
			standard.shuffle();
			if(i>3)
				System.out.println("After your " + i + "th Shuffle " + standard.toString());
			else if(i==3)
				System.out.println("After your " + i + "rd Shuffle " + standard.toString());
			else if(i==2)
				System.out.println("After your " + i + "nd Shuffle " + standard.toString());
			else
				System.out.println("After your " + i + "st Shuffle " + standard.toString());
		}
	}*/
}