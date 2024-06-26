import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * This class represents a hand of cards and provides implementations for all operations mandated by the Hand interface.
 */
public class HandImpl<T> implements Hand<T> {
    private ArrayList<T> cards;

    /**
     * Constructs an empty hand.
     */
    public HandImpl() {
        // Construct an empty hand.
        this.cards = new ArrayList<>();
    }

    public HandImpl(ArrayList<T> lst) {
        this.cards = new ArrayList<>();
        for (T card : lst) {
            cards.add(card);
        }
    }

    /**
     * Adds a card to the 'front' (index 0) of the hand.
     * @param card the card that gets added to the 'front' of the hand.
     */
    @Override
    public void add(T card) {
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
    public T get(int index) {
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
    public int getSize() {
        return cards.size();
    }

    /**
     * Checks if the hand is empty.
     * @return true if the hand is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns the index of the first occurrence of the specified card in the hand.
     * @param card the card to find.
     * @return the index of the first occurrence of the specified card in the hand.
     */
    @Override
    public int find(T card) {
        return cards.indexOf(card);
    }

    /**
     * Sorts the hand using the comparator function.
     * @param comparator the comparator used for sorting.
     */
    @Override
    public void sortHand(Comparator<T> comparator) {
        cards.sort(comparator);
    }

    /**
     * Returns a subset of the hand based on the specified predicate.
     * @param predicate the predicate to filter the hand.
     * @return a list of the subset of the cards that satisfy the predicate.
     */
    @Override
    public List<T> getHand(Predicate<T> predicate) {
        List<T> newHand = new ArrayList<>();
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
    public int rankSum() {
        int sum = 0;
        for (int i = 0; i< cards.size(); i++) {
            if (cards.get(i) instanceof Card) {
                Card card = (Card) cards.get(i);
                sum += card.getRank().getValue();
            }
        }
        return sum;
    }

    /**
     * Returns a new hand containing cards of a different type, based on the specified mapping function.
     * @param <Suit> the type of the new cards.
     * @param function the function to map cards to the new type.
     * @return a new hand containing cards of the new type.
     */
//    @Override
//    public <Suit> Hand <Suit> getMap(Function <Card, Suit> function) {
//        ArrayList<Suit> newList = new ArrayList<>();
//        for (int i = 0; i < cards.size(); i++) {
//            newList.add(function.apply(cards.get(i)));
//        }
//        Hand<Suit> result;
//        result = new HandImpl();
//        return result;
//    }

    // NEW MAP METHOD
    @Override
    public <Suit> Hand<Suit> getMap(Function<T, Suit> function) {
        // Convert the list of cards to a stream
        // Apply the mapping function
        // Collect the results into a list
        ArrayList<Suit> newCards = (ArrayList<Suit>) cards.stream().map(function).collect(Collectors.toList());

        // Create a new Hand instance with the mapped cards
        Hand<Suit> result = new HandImpl<>(newCards);

        // Return the Hand instance containing the transformed cards
        return result;
    }
}