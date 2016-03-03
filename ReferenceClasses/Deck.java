public class Deck{
	
	private int[] deck;
	public static final int NUMCARDS = 52;
	
	public Deck(){
		deck = new int[NUMCARDS];
		for(int i = 0; i < NUMCARDS; i++)
			deck[i]=i;
	}
	public void writeDeck(){
		for
	}
	public void shuffle() {
		int index;
		for(int i = NUMCARDS - 1;i > 0; i++)
				//generates int from 0 to i
			index= (int) (Math.random() * (i+1));
		swap(deck,i,index);
	}
}


}
