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
        if (index == 0) {
            return new ElementNode(data, this);
        }
        // How do I insert element at index in an empty list? Do I just add it to index 0?
        else {
            throw new IndexOutOfBoundsException("There is no such index. Node is empty.");
        }
    }

    @Override
    public int getDataAtIndex(int index) {
        throw new IndexOutOfBoundsException("There is no such index. Node is empty.");
    }

    @Override
    public IListOfInts getRest() {
        throw new IndexOutOfBoundsException("Node is empty, there is no list to provide.");
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
        return "";
    }
}