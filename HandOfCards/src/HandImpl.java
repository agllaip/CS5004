import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents a hand of cards and provides implementations for all operations mandated by the Hand interface.
 */
// Declare a public class named 'HandImpl' that implements the 'Hand<Card>' interface
// Provides implementations for all methods defined in 'Hand' interfaced for the type 'Card'
public class HandImpl implements Hand<Card> {
    // Type: ArrayList<Card>
    // field = cards
    private ArrayList<Card> cards;

    /**
     * Constructs an empty hand.
     */
    public HandImpl() {
        // Construct an empty hand.
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the 'front' (index 0) of the hand.
     * @param card the card that gets added to the 'front' of the hand.
     */
    @Override
    public void add(Card card){
        cards.addFirst(card);
    }

    /**
     * Removes the card at the specified index from the hand.
     * @param index the index of the card to discard.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public void discard(int index) {
        if (index < 0 || index >= cards.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        cards.remove(index);
    }

    /**
     * Returns the card at the specified index from the hand.
     * @param index the index of the object to get.
     * @return the card at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public Card get(int index){
        if (index < 0 || index >= cards.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return cards.get(index);
    }

    /**
     * Returns the number of cards currently in the hand.
     * @return the number of cards in the hand.
     */
    @Override
    public int getSize () {
        return cards.size();
    }

    /**
     * Checks if the hand is empty.
     * @return true if the hand is empty, false otherwise.
     */
    @Override
    public boolean isEmpty () {
        return cards.isEmpty();
    }

    /**
     * Returns the index of the first occurrence of the specified card in the hand.
     * @param card the card to find.
     * @return the index of the first occurrence of the specified card in the hand.
     */
    @Override
    public int find (Card card){
        return cards.indexOf(card);
    }

    /**
     * Sorts the hand using the comparator function.
     * @param comparator the comparator used for sorting.
     */
    @Override
    public void sortHand(Comparator<Card> comparator){
        cards.sort(comparator);
    }

    /**
     * Returns a subset of the hand based on the specified predicate.
     * @param predicate the predicate to filter the hand.
     * @return a list of the subset of the cards that satisfy the predicate.
     */
    @Override
    public List<Card> getHand(Predicate<Card> predicate) {
        List<Card> newHand = new ArrayList<>();
        // Iterate through each Card in the list of cards
        for (int i = 0; i < cards.size(); i++) {
        // If any of the cards I iterate through satisfy the predicate (some condition) add them to my hand
            if (predicate.test(cards.get(i))) {
                newHand.add(cards.get(i));
            }
        }
        return newHand;
    }

    /**
     * Returns the sum of the ranks of the cards in the hand.
     * @return the sum of the ranks of the cards in the hand.
     */
    @Override
    public int rankSum () {
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i).getRank();
        }
        return sum;
    }

    /**
     * Returns a new hand containing cards of a different type, based on the specified mapping function.
     * @param <R> the type of the new cards.
     * @param function the function to map cards to the new type.
     * @return a new hand containing cards of the new type.
     */
    @Override
    public <R> Hand <R> getMap(Function <Card, R> function) {
        ArrayList<R> newList = new ArrayList<R>();
        for (int i = 0; i < cards.size(); i++) {
            newList.add(function.apply(cards.get(i)));
        }
        return (Hand<R>) newList;
    }
}