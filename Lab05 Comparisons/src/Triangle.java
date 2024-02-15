/**
 * This class represents a triangle.  It offers all the operations mandated by the Shape interface.
 */

// Triangle inherits properties and methods from AbstractShape
public class Triangle extends AbstractShape {
    // Declare private fields representing points and distances
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    double distanceAB;
    double distanceBC;
    double distanceCA;


    /**
     * Construct a triangle object using the given reference point
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(new Point2D(x1, y1));

        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        // Compare points
        boolean case1 = (x1 == x2) && (y1 == y2);
        boolean case2 = (x2 == x3) && (y2 == y3);
        boolean case3 = (x1 == x3) && (y1 == y3);

        // Check if these 3 points are unique
        if (case1 || case2 || case3) {
            throw new IllegalArgumentException("The 3 points of the triangle need to be unique.");
        }

        calculateDistances();
    }

    // Declare private method that calculates distances between the points
    private void calculateDistances() {
        distanceAB = Math.sqrt(Math.pow((x2 - reference.getX()), 2) + Math.pow((y2 - reference.getY()), 2));
        distanceBC = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        distanceCA = Math.sqrt(Math.pow((reference.getX() - x3), 2) + Math.pow((reference.getY() - y3), 2));
    }

    // Computes and returns the area of this triangle
    @Override
    public double area() {
        // Calculate s = semi-perimeter = (a + b + c) / 2
        double s = ((distanceAB + distanceBC + distanceCA) / 2);

        // Apply Heron's formula (Area = sqrt (s(s - a)(s - b)(s - c)) )
        return Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));
    }

    // Computes and returns the perimeter (the addition of the length of the triangles 3 sides) of this triangle
    @Override
    public double perimeter() {
        return distanceAB + distanceBC + distanceCA;
    }

    // Create and return a shape of the same kind as this one, resized in area by the provided factor
    @Override
    public Shape resize(double factor) {
        // Return new Triangle
        return new Triangle(reference.getX(), reference.getY(), reference.getX() + distanceAB * Math.sqrt(factor),
                reference.getY(), reference.getX(), reference.getY() + distanceCA * Math.sqrt(factor));
    }

    public String toString() {
        return String.format("Triangle: (%f, %f), (%f, %f), (%f, %f)", reference.getX(),
                reference.getY(), x2, y2, x3, y3);
    }

    /**
     * Question:
     * Suppose you were asked to provide a different ordering of Shape, where comparisons
     * would be based on perimeter rather than area. Which parts of which files would have
     * needed to be modified? If it were not for sharing code via AbstractShape.java, how
     * many files would have needed modification (assuming you have concrete Shapes for
     * Rectangle, Circle, and Triangle)?
     *
     * Answer:
     * The Triangle, Rectangle, and Circle files would need to be changed. More specifically
     * their compareTo in the AbstractShape class to compare by perimeter instead of area.
     */

}