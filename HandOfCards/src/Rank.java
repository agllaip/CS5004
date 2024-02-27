/**
 * Enumeration representing the ranks of playing cards.
 */
public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int value;

    /**
     * Constructs a Rank enum value with the specified values.
     * @param value the value associated with the rank.
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Gets the value associated with the rank.
     * @return the value of the rank.
     */
    public int getValue() {
        return value;
    }
}