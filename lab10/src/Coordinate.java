/**
 * This class represents a point in a two-dimensional coordinate system.
 */
public class Coordinate {

    /**
     * Constructs a coordinate object with the given x and y coordinates.
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     */
    // Constructor that takes 2 parameters
    public Coordinate(int x, int y) {
        this.x = x;                       // Initialize the x field
        this.y = y;                       // Initialize the y field
    }

    /**
     * The x coordinate of the point.
     */
    int x;                              // Declare an integer named x

    /**
     * The y coordinate of the point.
     */
    int y;                              // Declare an integer named y

    /**
     * Checks whether some other object is 'equal to' this one.
     * @param obj the object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    // Compares this coordinate object to the other coordinate object given.
    // Returns a boolean value indicating whether the two objects are equal.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {                          // Check if obj is an instance of the Coordinate class
            Coordinate other = (Coordinate) obj;                    // Cast (convert an object of one type to another) the obj parameter to a Coordinate object
            return other.x == this.x && other.y == this.y;          // Compare x & y coordinates of this and other - return true if equal
        }

        return false;                                             // If this and other are not equal return false
    }
}