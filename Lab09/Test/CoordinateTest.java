import org.junit.Test;
import static org.junit.Assert.*;
public class CoordinateTest {

    @Test
    public void testConstructor() {
        // Create new Coordinate object
        Coordinate coordinate = new Coordinate(7, 3);

        // Check if the constructor initializes the x/y coordinates
        assertEquals(7, coordinate.x);
        assertEquals(3, coordinate.y);
    }

    @Test
    public void testEquals() {
        // Create new Coordinate objects
        Coordinate coordinate1 = new Coordinate(7, 3);
        Coordinate coordinate2 = new Coordinate(7, 3);
        Coordinate coordinate3 = new Coordinate(3, 7);

        // Test equality between coordinate1 and coordinate2
        assertTrue(coordinate1.equals(coordinate2));
        assertTrue(coordinate2.equals(coordinate1));

        // Test equality between coordinate1 and coordinate3
        assertFalse(coordinate1.equals(coordinate3));
        assertFalse(coordinate3.equals(coordinate1));

        // Test equality between coordinate2 and coordinate3
        assertFalse(coordinate2.equals(coordinate3));
        assertFalse(coordinate3.equals(coordinate2));
    }
}