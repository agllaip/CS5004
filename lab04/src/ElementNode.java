import javax.swing.text.Element;

public class ElementNode implements IListOfInts{
    private int data;
    private IListOfInts rest;

    public ElementNode(int data, IListOfInts rest) {
        this.data = data;
        this.rest = rest;
    }

    @Override
    public IListOfInts prepend(int data) {
        return new ElementNode(data, this);                 // Add data to the front of the list and return new list
    }

    @Override
    public IListOfInts append(int data) {
        if (rest instanceof EmptyNode) {                        // Base case: If current list is empty,
            rest = new ElementNode(data, new EmptyNode());    // Creates a new ElementNode with the given data, and an empty list (new EmptyNode()) as its rest.
        }                                                       // Adds the data to the current list, replacing the empty list with the new node.

        else {                                                  // Current list is not empty
            rest = rest.append(data);                           // Recursively append data to the rest of the list (ensures data is appended to the end of the list)
        }
        return rest;                                            // Return newly appended list
    }

    @Override
    public IListOfInts insertAtIndex(int data, int index) {
        if (index == 0) {                                   // If index is at 0 insert data at front
            return new ElementNode(data, this);        // new data at front the rest of the integers trailing it
        }

        else {                                                    // If index != 0 data should be inserted somewhere else
            rest = rest.insertAtIndex(data, index - 1);     // Recursively calls insertAtIndex on the rest of the current list
            return this;                                          // Decrement index by 1 to ensure the recursion progresses towards the base case (index = 0)
        }
    }

    @Override
    public int getDataAtIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be positive.");
        }

        else if (index == 0) {
            return data;
        }

        else {                                                    // If index != 0 (data is located somewhere other than the current node)
            return rest.getDataAtIndex(index - 1);              // Recursively calls getDataAtIndex on the rest of the current list
        }                                                           // Decrement index by 1 to ensure the recursion progresses towards the base case (index = 0)
    }

    @Override
    public IListOfInts getRest() {
        return rest;
    }

    @Override
    public int getCount() {
        if (rest instanceof EmptyNode) {
            return 1;
        }

        else {
            return rest.getCount() + 1;
        }
    }

    @Override
    public int getSum() {
        if (rest instanceof EmptyNode) {
            return data;
        }

        else {
            return rest.getSum() + data;
        }
    }

    @Override
    public String toString() {
        return data + " " + rest.toString();
    }
}