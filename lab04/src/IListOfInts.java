import java.util.List;
import java.util.function.Predicate;

/**
 * This interface represents all the operations to be supported by a list of integers.
 */
public interface IListOfInts {

    /**
     * adds to front
     */
    IListOfInts prepend(int data);

    /**
     * adds to back
     */
    IListOfInts append(int data);

    /**
     * inserts data so as to become the index'th element, before rest
     */
    IListOfInts insertAtIndex(int data, int index);

    /**
     *
     */
    int getDataAtIndex(int index);

    /**
     * Returns list of all but the first
     */
    IListOfInts getRest();

    /**
     * Return the number of integers in this list
     * @return the length of this list
     */
    int getCount();

    /**
     * Return the sum of integers in this list
     * @return the sum of the elements in the list
     */
    int getSum();

    /**
     * Create and return a string that can be used to print this list
     * @return
     */
    String toString();
}