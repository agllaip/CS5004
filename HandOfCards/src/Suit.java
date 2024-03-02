/**
 * Enumeration representing the suits of playing cards.
 */
public enum Suit {
    CLUBS("BLACK"),
    HEARTS("RED"),
    DIAMONDS("RED"),
    SPADES("BLACK");

    private final String color;

    /**
     * Constructs a Suit enum value with the specified color.
     * @param color the color associated with the suit.
     */
   Suit(String color) {
        this.color = color;
    }

    /**
     * Gets the color associated with the suit.
     * @return the color of the suit.
     */
    public String getColor() {
       return color;
    }
}