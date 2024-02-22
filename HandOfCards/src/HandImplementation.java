import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a ... It defines all the operations mandated by the Hand interface.
 */
public class HandImplementation implements Hand<C> {
    private ArrayList<Card> cards;

    /**
     * Construct a card object using the given three points of the triangle.
     * @param ...
     * @throws IllegalArgumentException if ...
     */
    public HandImplementation(Suit suit, Rank rank) {

        }

    /**
     * Adds a card to the 'front' of the hand.
     * @param card that gets added to the 'front' of the hand.
     */
    @Override
    public void add (Card card){
        cards.addFirst(card);
    }

    /**
     * Removes the card at the provided index.
     * @param index that the card will be removed from.
     */
    @Override
    public void discard (int index){
        if (index < 0 || index > cards.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        cards.remove(index);
    }

    /**
     * Gets the card at the provided index.
     * @param index that the card will be gotten from.
     * @return card at provided index ????
     */
    @Override
    public C get (int index){
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
    public int getSize () {
        return cards.size();
    }

    /**
     * Checks if the Hand is empty. Returns false if the hand is empty.
     *
     * @return false if had is empty ???
     */
    @Override
    public int isEmpty () {
        return 0;
    }

    /**
     * Returns the index of the first card that is equal to the provided card.
     * @param card that the program is looking for.
     * @return index of the first equal card.
     */
    @Override
    public int find (Card card){
        return 0;
    }

    /**
     * Sort the Hand using the comparator function.
     * @param comparator ....
     */
    @Override
    public void sortHand (Function < Card, Integer > comparator){

    }

    /**
     * Return a subset of a Hand based on a Predicate (such as “suitColor is RED” or “rank > 10”).
     * @param predicate ....
     * @return subset of the Hand based on the provided predicate.
     */
    @Override
    public List<C> getHand (Predicate <Card> predicate) {
        return null;
    }

    /**
     * Returns the sum of the ranks of the cards in the hand.
     * @return sum of Hand.
     */
    @Override
    public int rankSum () {
        return 0;
    }

    /**
     *
     * @param function ....
     * @return ....
     */
    @Override
    public <R> Hand <R> getMap(Function <Card, R> function) {
        return null;
    }
}