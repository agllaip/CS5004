import java.util.Comparator;

/**
 * The CardComparator class implements the Comparator interface for comparing the suits of cards.
 * It compares two cards based on their suits
 */

// A separate Class should implement Comparator<Card> based on the suit, with CLUBS < HEARTS < DIAMONDS < SPADES.

public class CardComparator implements Comparator<Card> {
    /**
     * Compares two cards based on their suits.
     *
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return -1 if the suit of card1 is less than card2, 1 if the suit
     * of card1 is greater than card2, and 0 if the suit of card1 is equal to card2.
     */
    public int compare(Card card1, Card card2) {
        // Get the suits of the 2 cards
        Suit suit1 = card1.getSuit();
        Suit suit2 = card2.getSuit();

        // Compare cards based on suits
        return suit1.compareTo(suit2);
    }
}