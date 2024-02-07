public class ElementNode implements IListOfInts{
    private int data;
    private IListOfInts rest;

    public ElementNode(int data, IListOfInts rest) {
        this.data = data;
        this.rest = rest;
    }

    @Override
    public IListOfInts prepend(int data) {
        return new ElementNode(data, this);             // Add data to the front of the list and return new list
    }

    @Override
    public IListOfInts append(int data) {
        rest = rest.append(data);                           // Recursively calls append method on the rest of the current list.
        return this;                                        // This ensures the data is appended to the end of the list recursively
    }                                                       // until reaching base case (empty node).

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
        if (index == 0)
            return data;

        else                                                    // If index != 0 (data is located somewhere other than the current node)
            return rest.getDataAtIndex(index - 1);              // Recursively calls getDataAtIndex on the rest of the current list
    }                                                           // Decrement index by 1 to ensure the recursion progresses towards the base case (index = 0)

    @Override
    public IListOfInts getRest() {
        return rest;
    }

    @Override
    public int getCount() {
        return rest.getCount() + 1;
    }

    @Override
    public int getSum() {
        return rest.getSum() + 1;
    }

    @Override
    public String toString() {
        return "";              // What am I returning ??
    }
}