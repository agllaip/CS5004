/**
 * This class represents a triangle. It defines all the operations mandated by the Shape interface.
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
     * Construct a triangle object using the given three points of the triangle.
     * @param x1 x coordinate of point A
     * @param y1 y coordinate of point A
     * @param x2 x coordinate of point B
     * @param y2 y coordinate of point B
     * @param x3 x coordinate of point C
     * @param y3 y coordinate of point C
     * @throws IllegalArgumentException if any two points are identical
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

    /**
     * Gets the x coordinate for point A
     * @return x coordinate for point A
     */
    public double getX1() {
        return reference.getX();
    }

    /**
     * Gets the y coordinate for point A
     * @return y coordinate for point A
     */
    public double getY1() {
        return reference.getY();
    }

    /**
     * Gets the x coordinate for point B
     * @return x coordinate for point B
     */
    public double getX2() {
        return x2;
    }

    /**
     * Gets the y coordinate for point B
     * @return y coordinate for point B
     */
    public double getY2() {
        return y2;
    }

    /**
     * Gets the x coordinate for point C
     * @return x coordinate for point C
     */
    public double getX3() {
        return x3;
    }

    /**
     * Gets the y coordinate for point C
     * @return y coordinate for point C
     */
    public double getY3() {
        return y3;
    }

    /**
     * Calculates the distance (length) between two points:
     * distanceAB - distance from point A to point B
     * distanceBC - distance from point B to point C
     * distanceCA - distance from point C to point A
     */
    private void calculateDistances() {
        distanceAB = Math.sqrt(Math.pow((x2 - reference.getX()), 2) + Math.pow((y2 - reference.getY()), 2));
        distanceBC = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        distanceCA = Math.sqrt(Math.pow((reference.getX() - x3), 2) + Math.pow((reference.getY() - y3), 2));
    }

    /**
     * Calculates the area of a triangle using Heron's formula
     * @return area of a triangle
     */
    @Override
    public double area() {
        // Calculate s = semi-perimeter = (a + b + c) / 2
        double s = ((distanceAB + distanceBC + distanceCA) / 2);

        // Apply Heron's formula (Area = sqrt (s(s - a)(s - b)(s - c)) )
        return Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));
    }

    /**
     * Calculates the perimeter of a triangle by adding the length of a triangles three sides
     * @return perimeter of a triangle
     */
    @Override
    public double perimeter() {
        return distanceAB + distanceBC + distanceCA;
    }

    /**
     * Resize a triangle by the factor given as a parameter
     * @return resized triangle based on the factor given
     */
    // Create and return a triangle, resized in area by the provided factor
    @Override
    public Shape resize(double factor) {
        // Return new Triangle
        return new Triangle(reference.getX(), reference.getY(), reference.getX() + distanceAB * Math.sqrt(factor),
                reference.getY(), reference.getX(), reference.getY() + distanceCA * Math.sqrt(factor));
    }

    /**
     * Gets a string representation of a triangle
     * @return string representing a triangle
     */
    public String toString() {
        return String.format("Triangle: (%.1f, %.1f), (%.1f, %.1f), (%.1f, %.1f)", reference.getX(),
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