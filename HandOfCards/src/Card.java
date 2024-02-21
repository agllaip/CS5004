import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a ... It defines all the operations mandated by the Hand interface.
 */
public class Card implements Hand<Card> {
    private ArrayList<Card> cards;
    public Suit suit;
    private Rank rank;
    }

    /**
     * Construct a card object using the given three points of the triangle.
     * @param suit
     * @param rank
     * @throws IllegalArgumentException if ...
     */
    public Rank Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.cards = new ArrayList<>();

        // Check the validity of the rank in the constructor to detect the issue early when the Card object is created
        // You can handle the problem before the object is used elsewhere in your code
        // Is this how you account for if the rank is out of range.
        if (rank == null) {                 // Double check this!!!!!
            throw new IllegalArgumentException("Rank can't be null.");
    }

    /**
     * Gets the suit of a card.
     * @return suit of a card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets the rank of a card.
     * @return rank of a card.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns an Enum RED or BLACK depending on whether the suit is DIAMONDS/HEARTS versus CLUBS/SPADES
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Adds a card to the 'front' of the hand.
     * @param card
     */
    @Override
    public void add(Card card) {
        cards.add(0, card);
    }

    /**
     * Removes the card at the provided index.
     * @param index
     */
    @Override
    public void discard(int index) {
        if (index < 0 || index > cards.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        cards.remove(index);
    }

    /**
     * Gets the card at the provided index.
     * @param index
     * @return card at provided index ????
     */
    @Override
    public Card get(int index) {
        if (index < 0 || index > cards.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return cards.get(index);
    }

    /**
     * Returns the number of cards currently in the Hand.
     * @return number of cards in Hand.
     */
    @Override
    public int getSize() {
        return cards.getSize();

    }

    /**
     * Checks if the Hand is empty. Returns false if the hand is empty.
     * @return false if had is empty ???
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the index of the first card that is equal to the provided card.
     * @param card
     * @return index of the first equal card.
     */
    @Override
    public int find(Card card) {
        return 0;
    }

    /**
     * Sort the Hand using the comparator function.
     * @param comparator
     */
    @Override
    public void sortHand(Function<Card, Integer> comparator) {

    }

    /**
     * Return a subset of a Hand based on a Predicate (such as “suitColor is RED” or “rank > 10”).
     *
     * @param predicate
     * @return subset of the Hand based on the provided predicate.
     */
    @Override
    public List<C> getHand(Predicate<Card> predicate) {
        return null;
    }

    /**
     * Returns the sum of the ranks of the cards in the hand.
     * @return sum of Hand.
     */
    @Override
    public int rankSum() {
        return 0;
    }

    /**
     *
     * @param function
     * @return
     */
    @Override
    public <R> Hand<R> getMap(Function<Card, R> function) {
        return null;
    }

    /**
     *
     * @param otherCard the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Card otherCard) {
        // Get suits
        Suit suit1 = this.getSuit();
        Suit suit2 = otherCard.getSuit();

        // Compare
        return suit1.compareTo(suit2);
    }

    public String toString() {
        return String.format("");
    }
}