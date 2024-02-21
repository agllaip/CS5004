import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This interface contains all operations that all types of ....
 */
public interface Hand<C> {

    /**
     * Adds one card to the "front" of a Hand.
     */
    // void means the method does not return a value after it is executed.
    // Method takes a parameter of type C, the parameter is named 'card' (represents object that will be added to the Hand).
    void add(C card);

    /**
     * Removes the index’th card from a Hand (after verifying that the index is valid).
     */
    void discard(int index);

    /**
     * Gets the index’th card from the Hand (ensuring that the index is within bounds).
     */
    // C indicates return type - in this case 'Card', but could be another type depending on how 'Hand' us implemented.
    C get(int index);

    /**
     * Returns the number of cards currently in the Hand.
     */
    int getSize();

    /**
     * Checks if a Hand is empty.
     * @return ...
     */
    boolean isEmpty();

    /**
     * Return the index of the first item in the Hand that is equal to it, or -1 if the Hand does not contain that particular card.
     */
    int find(C card);

    /**
     * Sort the Hand using the comparator function.
     */
    // It performs some action but doesn't produce any result that needs to be returned.
    // Function is a functional interface in java representing a function that accepts one argument and produces a result
    // Function is parameterized by 2 types: input 'C' and output 'Integer' (<C, Integer>)
    // comparator is the name of the parameter.
    void sortHand(Function<C, Integer> comparator);

    /**
     * Return a subset of a Hand based on a Predicate (such as “suitColor is RED” or “rank > 10”).
     */
    // List<C> indicates a return type. The method will return a list of elements of type 'C' in Java.
    // (Predicate<C> predicate) represents the parameter list of the method, indicating the method takes a single parameter
    // which is a predicate that operates on elements of type 'C'.
    // Predicate = a boolean-valued function.
    List<C> getHand(Predicate<C> predicate);

    /**
     * Returns the sum of the ranks of the cards in the hand.
     */
    int rankSum();

    /**
     * Returns a Hand<C> where C is some other reference type, such as mapping each Card to its Color or its Rank, based on a higher-order function f.
     */
    <R> Hand<R> getMap(Function<C, R> function);
}