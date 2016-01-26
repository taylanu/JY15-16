package proj115;

public class Suit implements Comparable{
   static public final Suit spade = new Suit(4, "spades");
   static public final Suit heart = new Suit(3, "hearts");
   static public final Suit diamond = new Suit(2, "diamonds");
   static public final Suit club = new Suit(1, "club");
   private int order;
   private String name;
   
   private Suit(int ord, String nm){
      name = nm;
      order = ord;
   }
   
   @Override
public int compareTo(Object other){
      if(! (other instanceof Suit))
         throw new IllegalArgumentException("Parameter must be a Suit");
      Suit otherSuit = (Suit)other;
      return order - otherSuit.order;
   }
   
   @Override
public String toString(){
      return name;
   }
}