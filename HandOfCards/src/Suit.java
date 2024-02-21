public enum Suit {

    CLUBS("BLACK", 0),
    DIAMONDS("RED", 2),
    HEARTS("RED", 1),
    SPADES("BLACK", 3);

    // Store the color associated with each suit:
    private final String color;
    private final int value;

    Suit(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}
