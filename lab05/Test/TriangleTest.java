import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This test contains all the unit tests for triangles.
 */

public class TriangleTest {
    private Triangle triangle1;
    private Triangle triangle2;

    @Before
    public void setup() {
        triangle1 = new Triangle(0, 0, 5, 0, 0, -2);
        triangle2 = new Triangle(-2, -2, -4, -4, -1, -6);
    }

    /**
     * Tests the getX1 method of a triangle.
     */
    @Test
    public void testGetX1() {
        assertEquals(0.0, triangle1.getX1(), 0.1);
        assertEquals(-2.0, triangle2.getX1(), 0.1);
    }

    /**
     * Tests the getY1 method of a triangle.
     */
    @Test
    public void testGetY1() {
        assertEquals(0.0, triangle1.getY1(), 0.1);
        assertEquals(-2.0, triangle2.getY1(), 0.1);
    }

    /**
     * Tests the getX2 method of a triangle.
     */
    @Test
    public void testGetX2() {
        assertEquals(5.0, triangle1.getX2(), 0.1);
        assertEquals(-4.0, triangle2.getX2(), 0.1);
    }

    /**
     * Tests the getY2 method of a triangle.
     */
    @Test
    public void testGetY2() {
        assertEquals(0.0, triangle1.getY2(), 0.1);
        assertEquals(-4.0, triangle2.getY2(), 0.1);
    }

    /**
     * Tests the getX3 method of a triangle.
     */
    @Test
    public void testGetX3() {
        assertEquals(0.0, triangle1.getX3(), 0.1);
        assertEquals(-1.0, triangle2.getX3(), 0.1);
    }

    /**
     * Tests the getY3 method of a triangle.
     */
    @Test
    public void testGetY3() {
        assertEquals(-2.0, triangle1.getY3(), 0.1);
        assertEquals(-6.0, triangle2.getY3(), 0.1);
    }

    /**
     * Tests the calculateDistances method of a triangle.
     */
    @Test
    public void testCalculateDistances() {
        // Triangle 1 distances
        assertEquals(5.0, triangle1.distanceAB, 0.1);
        assertEquals(5.3, triangle1.distanceBC, 0.1);
        assertEquals(2.0, triangle1.distanceCA, 0.1);

        // Triangle 2 distances
        assertEquals(2.8, triangle2.distanceAB, 0.1);
        assertEquals(3.6, triangle2.distanceBC, 0.1);
        assertEquals(4.1, triangle2.distanceCA, 0.1);
    }

    /**
     * Tests the creation of a triangle.
     */
    @Test
    public void testTriangleCreation() {
        assertNotNull(triangle1);
        assertNotNull(triangle2);
    }

    /**
     * Tests the creation of a triangle with the same three points and expecting and IllegalArgumentException.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testTriangleCreationException() {
        Triangle triangle = new Triangle(0,0,0,0,0,0);
    }

    /**
     * Tests the area calculation of a triangle.
     */
    @Test
    public void testArea() {
        assertEquals(5.0, triangle1.area(), 0.1);
        assertEquals(5.0, triangle2.area(), 0.1);
    }

    /**
     * Tests the perimeter calculation of a triangle.
     */
    @Test
    public void testPerimeter() {
        assertEquals(12.3, triangle1.perimeter(), 0.1);
        assertEquals(10.5, triangle2.perimeter(), 0.1);
    }

    /**
     * Tests the resize calculation of a triangle.
     */
    @Test
    public void testResize() {
        Shape resizedTriangle1 = triangle1.resize(3.0);
        Shape resizedTriangle2 = triangle1.resize(2.0);
        assertEquals(15.0, resizedTriangle1.area(), 0.1);
        assertEquals(10.0, resizedTriangle2.area(), 0.1);
    }

    /**
     * Tests the toString method of a triangle.
     */
    @Test
    public void testToString() {
        // Triangle 1
        String expectedString1 = "Triangle: (0.0, 0.0), (5.0, 0.0), (0.0, -2.0)";
        // Triangle 2
        String expectedString2 = "Triangle: (-2.0, -2.0), (-4.0, -4.0), (-1.0, -6.0)";
        assertEquals(expectedString1, triangle1.toString());
        assertEquals(expectedString2, triangle2.toString());
    }
}