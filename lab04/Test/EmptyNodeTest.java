import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmptyNodeTest {

    private EmptyNode emptyList;

    @Before
    public void setUp() {
        emptyList = new EmptyNode();
    }

    @Test
    public void prepend() {
        IListOfInts newList1 = emptyList.prepend(10);
        IListOfInts newList2 = emptyList.prepend(20);
        IListOfInts newList3 = emptyList.prepend(30);

        assertEquals(10, newList1.getDataAtIndex(0));
        assertEquals(20, newList2.getDataAtIndex(0));
        assertEquals(30, newList3.getDataAtIndex(0));
    }

    @Test
    public void append() {
        IListOfInts newList1 = emptyList.append(40);
        IListOfInts newList2 = emptyList.append(50);
        IListOfInts newList3 = emptyList.append(60);

        assertEquals(40, newList1.getDataAtIndex(0));
        assertEquals(50, newList2.getDataAtIndex(0));
        assertEquals(60, newList3.getDataAtIndex(0));
    }

    @Test
    public void insertAtIndex() {
        // Inserting at index 0
        IListOfInts newList = emptyList.insertAtIndex(70,0);
        assertEquals(70, newList.getDataAtIndex(0));

        // Testing at an index other than 0
        try {
            emptyList.insertAtIndex(70, 8);
            fail("Expected IndexOutOfBoundsException to be thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("There is no such index. Node is empty.", e.getMessage());
        }
    }

    @Test
    public void getDataAtIndex() {
        try {
            emptyList.getDataAtIndex(8);
            fail("Expected IndexOutOfBoundsException to be thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("There is no such index. Node is empty.", e.getMessage());
        }
    }

    @Test
    public void getRest() {
        try {
            emptyList.getRest();
            fail("Expected IndexOutOfBoundsException to be thrown.");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Node is empty, there is no list to provide.", e.getMessage());
        }
    }

    @Test
    public void getCount() {
        assertEquals(0, emptyList.getCount());
    }

    @Test
    public void getSum() {
        assertEquals(0, emptyList.getSum());
    }

    @Test
    public void testToString() {
        assertEquals("", emptyList.toString());
    }
}