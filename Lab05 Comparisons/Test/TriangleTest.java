import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains all the unit tests for triangles.
 */

public class TriangleTest {
    private Triangle triangle1;
    private Triangle triangle2;

    @Before
    public void setup() {
        triangle1 = new Triangle(0, 0, 5, 0, 0, -2);
        triangle2 = new Triangle(-2, -2, -4, -4, -1, -6);
    }

    @Test
    public void testTriangleCreation() {
        assertNotNull(triangle1);
        assertNotNull(triangle2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTriangleCreationException() {
        Triangle triangle = new Triangle(0,0,0,0,0,0);
    }

    @Test
    public void testArea() {
        assertEquals(5.0, triangle1.area(), 0.01);
        assertEquals(5.0, triangle2.area(), 0.01);
    }

    @Test
    public void testPerimeter() {
        assertEquals(12.38, triangle1.perimeter(), 0.01);
        assertEquals(10.55, triangle2.perimeter(), 0.01);
    }

    @Test
    public void testResize() {
        Shape resizedTriangle1 = triangle1.resize(3.0);
        Shape resizedTriangle2 = triangle1.resize(2.0);
        assertEquals(15.0, resizedTriangle1.area(), 0.01);
        assertEquals(10.0, resizedTriangle2.area(), 0.01);
    }
}