import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This interface represents a hand of cards and defines various operations on it.
 * @param <C> the type of objects in the hand (i.e. Cards)
 */
public interface Hand<C> {

    /**
     * Adds one card to the 'front' (index 0) of the hand.
     * @param card the object to add to the front of the hand.
     */
    // void means the method does not return a value after it is executed.
    // Method takes a parameter of type C, the parameter is named 'card' (represents object that will be added to the Hand).
    void add(C card);

    /**
     * Removes the card at the specified index from the hand (after verifying that the index is valid).
     * @param index the index of the object to discard.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    void discard(int index);

    /**
     * Returns the card at the specified index from the hand (after verifying that the index is valid).
     * @param index the index of the object to get.
     * @return the object at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    // C indicates return type - in this case 'Card', but could be another type depending on how 'Hand' us implemented.
    C get(int index);

    /**
     * Returns the number of objects currently in the Hand.
     * @return the number of objects currently in the Hand.
     */
    int getSize();

    /**
     * Checks if the hand is empty.
     * @return true if the hand is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the index of the first occurrence of a card in the hand.
     * @param card the object to find.
     * @return the index of the first occurrence of the object.
     */
    int find(C card);

    /**
     * Sorts the hand using the comparator function.
     * @param comparator the comparator used for sorting.
     */
    // It performs some action but doesn't produce any result that needs to be returned.
    // Function is a functional interface in java representing a function that accepts one argument and produces a result
    // Function is parameterized by 2 types: input 'C' and output 'Integer' (<C, Integer>)
    // comparator is the name of the parameter.
    void sortHand(Function<C, Integer> comparator);

    /**
     * Returns a subset of the hand based on the specified predicate (i.e. “suitColor is RED” or “rank > 10”).
     * @param predicate the predicate to filter the hand.
     * @return a list of the subset of the objects that satisfy the predicate.
     */
    // List<C> indicates a return type. The method will return a list of elements of type 'C' in Java.
    // (Predicate<C> predicate) represents the parameter list of the method, indicating the method takes a single parameter
    // which is a predicate that operates on elements of type 'C'.
    // Predicate = a boolean-valued function.
    List<C> getHand(Predicate<C> predicate);

    /**
     * Returns the sum of the ranks of the cards in the hand.
     * @return the sum of the ranks of the cards in the hand.
     */
    int rankSum();

    /**
     * Returns a new hand containing objects of a different type, based on the specified mapping function.
     * @param <R> the type of the new objects.
     * @param function the function to map objects to the new type.
     * @return a new hand containing objects of the new type.
     */
    <R> Hand<R> getMap(Function<C, R> function);
}