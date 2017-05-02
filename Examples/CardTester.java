import java.util.*;
public class CardTester {
	public static void main (String[] args) {
		// create deck
		StandardDeck deck = new StandardDeck();
		// print deck
		System.out.println(deck);
		// shuffle
		deck.shuffle();
		// print deck
		System.out.println(deck);
		// print no of cards left
		System.out.println(deck.noOfCardsLeft());
		// Deal
		System.out.println("You dealt the " + deck.deal() + "\n");
		// print no of cards left
		System.out.println(deck.noOfCardsLeft());
		// print all ranks
		System.out.println(Arrays.toString(Rank.values()));
		Card c = new Card(Rank.TWO, Suit.HEARTS);
		System.out.println(c + " " + c.isRed() +  " should be true.");

		// reset deck
		deck.reset();
		System.out.print(deck + "\n");
		System.out.println(deck.noOfCardsLeft());
	}
}