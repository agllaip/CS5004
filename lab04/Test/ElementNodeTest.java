import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ElementNodeTest {

    private IListOfInts emptyList;
    private IListOfInts list;

    @Before
    public void setUp() {
        emptyList = new EmptyNode();
        list = new ElementNode(1, new ElementNode(2, new ElementNode(3, new EmptyNode())));
    }

    @Test
    public void prepend() {
        IListOfInts newList1 = emptyList.prepend(4);
        IListOfInts newList2 = emptyList.prepend(5);
        IListOfInts newList3 = emptyList.prepend(6);

        assertEquals(4, newList1.getDataAtIndex(0));
        assertEquals(5, newList2.getDataAtIndex(0));
        assertEquals(6, newList3.getDataAtIndex(0));
    }

    @Test
    public void append() {
        // Append to empty list
        IListOfInts newList1 = emptyList.prepend(4);
        IListOfInts newList2 = emptyList.prepend(5);
        IListOfInts newList3 = emptyList.prepend(6);

        assertEquals(4, newList1.getDataAtIndex(0));
        assertEquals(5, newList2.getDataAtIndex(0));
        assertEquals(6, newList3.getDataAtIndex(0));

        // Test on list with at least 1 element
        IListOfInts appendList1 = list.append(4);
        IListOfInts appendList2 = list.append(5);
        IListOfInts appendList3 = list.append(6);

        assertEquals(4, appendList1.getDataAtIndex(3));
        assertEquals(5, appendList2.getDataAtIndex(3));
        assertEquals(6, appendList3.getDataAtIndex(3));
    }

    @Test
    public void insertAtIndex() {
        IListOfInts insert1 = list.insertAtIndex(4,0);
        IListOfInts insert2 = list.insertAtIndex(4,1);
        IListOfInts insert3 = list.insertAtIndex(4,2);

        assertEquals(4, insert1.getDataAtIndex(0));
        assertEquals(4, insert2.getDataAtIndex(1));
        assertEquals(4, insert3.getDataAtIndex(2));
    }

    @Test
    public void getDataAtIndex() {
        assertEquals(1, list.getDataAtIndex(0));
        assertEquals(2, list.getDataAtIndex(1));
        assertEquals(3, list.getDataAtIndex(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetDataAtIndexException() {
        list.getDataAtIndex(-1);
        list.getDataAtIndex(3);
        list.getDataAtIndex(100);

    }

    @Test
    public void getRest() {
        IListOfInts restList = list.getRest();
        assertEquals(2, restList.getDataAtIndex(0));
    }

    @Test
    public void getCount() {
        assertEquals(3, list.getCount());
    }

    @Test
    public void getSum() {
        assertEquals(6, list.getSum());
    }

    @Test
    public void testToString() {
        assertEquals("1 2 3", list.toString());
    }
}