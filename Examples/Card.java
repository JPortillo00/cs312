/* Card class
*
*/

public class Card {
	private Rank myRank;
	private Suit mySuit;

	public Card (Rank r, Suit s) {
		myRank = r;
		mySuit = s;
	}
	
	public Rank getRank () {
		return myRank;
	}
	
	public Suit getSuit () {
		return mySuit;
	}

	public String toString () {
		return myRank + " of " + mySuit;
	}

	public boolean isRed() {
		return mySuit==Suit.HEARTS || mySuit == Suit.DIAMONDS;
	}
}