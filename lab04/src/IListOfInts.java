/**
 * This interface represents all the operations to be supported by a list of integers.
 */
public interface IListOfInts {

    /**
     * Adds data to the front of the list.
     * @param data
     * @return new list
     */
    IListOfInts prepend(int data);

    /**
     * Recursively adds data to the back of the list.
     * @param data
     * @return new list
     */
    IListOfInts append(int data);

    /**
     * Checks if the index = 0 (base case)
     * If not base case recursively inserts data so as to become the index'th element, before rest.
     * @param data
     * @param index
     * @return new list
     */
    IListOfInts insertAtIndex(int data, int index);

    /**
     * Checks if the index = 0 (base case)
     * If not base case recursively retrieves data at a certain index.
     * @param index
     * @return data from a specific index
     */
    int getDataAtIndex(int index);

    /**
     * Returns list of all elements but the first.
     * @return the list excluding the front element.
     */
    IListOfInts getRest();

    /**
     * Returns the number of integers in this list.
     * @return the length of this list.
     */
    int getCount();

    /**
     * Returns the sum of integers in this list.
     * @return the sum of all elements in the list.
     */
    int getSum();

    /**
     * Create and return a string that can be used to print this list.
     * @return the list.
     */
    public String toString();
}