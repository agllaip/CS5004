import java.util.Comparator;            // Import Comparator interface from Java

// Define PerimeterComparator class and implement the Comparator<Shape>
// PerimeterComparator can now compare objects of type Shape

public class PerimeterComparator implements Comparator<Shape> {

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