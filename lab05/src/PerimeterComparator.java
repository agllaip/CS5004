import java.util.Comparator;            // Import Comparator interface from Java

// Define PerimeterComparator class and implement the Comparator<Shape>
// PerimeterComparator can now compare objects of type Shape

/**
 * The PerimeterComparator class implements the Comparator interface for comparing the perimeters of shapes.
 * It compares two shapes based on their perimeter.
 */
public class PerimeterComparator implements Comparator<Shape> {

    /**
     * Compares two shapes based on their perimeters.
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared.
     * @return -1 if the perimeter of s1 is less than s2, 1 if the perimeter
     * of s1 is greater than s2, and 0 if the perimeter of s1 is equal to s2.
     */
    @Override
    // Compare 2 shapes (s1 and s2) based on their perimeter
    public int compare(Shape s1, Shape s2) {
        // Calculate the perimeters of the 2 shapes
        double perimeter1 = s1.perimeter();
        double perimeter2 = s2.perimeter();

        // Compare shapes based on perimeter
        if (perimeter1 < perimeter2) {
            return -1;
        }

        else if (perimeter1 > perimeter2) {
            return 1;
        }

        // perimeter1 == perimeter2
        else {
            return 0;
        }
    }
}