public class EmptyNode implements IListOfInts{
    @Override
    public IListOfInts prepend(int data) {
        return new ElementNode(data, this);
    }

    @Override
    public IListOfInts append(int data) {
        return new ElementNode(data, this);
    }

    @Override
    public IListOfInts insertAtIndex(int data, int index) {
        if (index == 0)                     // If the index is equal to 0 insert data at front of list
            return prepend(data);           // Calls prepend and inserts data at front and returns updated list
        else {                              // If index is not 0 (can't insert at given index)
            System.out.println("Cannot insert " + data + "at index " + index + ".");
            return this;                    // Returns unchanged list
        }
    }

    @Override
    public int getDataAtIndex(int index) {
        System.out.println("No value at " + index + ". List is empty.");
        return -1;                          // What am I returning?

    }

    @Override
    public IListOfInts getRest() {
        System.out.println("Cannot get rest of list because the list is empty.");
        return this;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int getSum() {
        return 0;
    }

    @Override
    public String toString() {
        return "";                          // What am I returning ??
    }
}