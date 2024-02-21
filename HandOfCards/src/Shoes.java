/**
 * This class represents a shoe with the attributes: type, color, brand, and size.
 */
public class Shoes {
        private String type;
        private String color;
        private String brand;
        private double size;

    /**
     * Construct a shoe object using the four given parameters.
     * @param type
     * @param color
     * @param brand
     * @param size
     */
        public Shoe(String type, String color, String brand, double size) {
            this.type = type;
            this.color = color;
            this.brand = brand;
            this.size = size;
        }

    /**
     * Gets the type of the shoe.
     * @return type of the shoe.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the color of the shoe.
     * @return color of the shoe.
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the brand of the shoe.
     * @return brand of the shoe.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the size of the shoe.
     * @return size of the shoe.
     */
    public double getSize() {
        return size;
    }

    /**
     * Returns a string representation of the shoe object.
     * @return string representation of the shoe object.
     */
    public String toString() {
            return "Shoe: " + brand + type + "in size" + size + "and color" + color + ".";
    }
}