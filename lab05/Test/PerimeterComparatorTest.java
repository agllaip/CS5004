import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This test contains all the unit tests for PerimeterComparator.
 */

public class PerimeterComparatorTest {
    private PerimeterComparator perimeterComparator;
    private Shape triangle1;
    private Shape triangle2;
    private Shape rectangle1;
    private Shape rectangle2;
    private Shape rectangle3;
    private Shape circle1;
    private Shape circle2;

    @Before
    public void setup() {
        perimeterComparator = new PerimeterComparator();

        // Create shapes
        triangle1 = new Triangle(0,0,2,2, 5, 2);
        triangle2 = new Triangle(0,0, 1, -5, -5, -5);
        rectangle1 = new Rectangle(0,0,3,5);
        rectangle2 = new Rectangle(0,0,8,10);
        rectangle3= new Rectangle(1,1,5, 3);
        circle1 = new Circle(0,0,5);
        circle2 = new Circle(0,0,10);
    }

    /**
     * Tests the perimeter comparison class for various kinds of shapes.
     */
    @Test
    public void testCompare() {
        assertEquals(-1, perimeterComparator.compare(triangle1, triangle2));
        assertEquals(1, perimeterComparator.compare(triangle2, triangle1));
        assertEquals(-1, perimeterComparator.compare(rectangle1, rectangle2));
        assertEquals(1, perimeterComparator.compare(rectangle2, rectangle1));
        assertEquals(-1, perimeterComparator.compare(circle1, circle2));
        assertEquals(1, perimeterComparator.compare(circle2, circle1));
        assertEquals(-1, perimeterComparator.compare(triangle1, rectangle1));
        assertEquals(0, perimeterComparator.compare(rectangle1, rectangle3));

    }
}
