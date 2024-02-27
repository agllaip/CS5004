import java.util.Objects;

/**
 * This class represents a playing card.
 */
public class Card implements Comparable<Card> {
    // Instance variables: suit and rank
    // final means they can only be initialized once
    private final Suit suit;
    private final Rank rank;

    /**
     * Constructs a card object using the given the attributes; suit and rank.
     * @param suit a deck of cards has 4 suits: CLUBS, HEARTS, DIAMONDS, SPADES.
     * @param rank a deck of cards has 13 ranks: ACE, 2 - 10, JACK, QUEEN, KING.
     * @throws IllegalArgumentException if the rank is out of range.
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        if (rank == null || rank.ordinal() < 1 || rank.ordinal() > 13) {
            throw new IllegalArgumentException("Invalid rank, rank must be between 1 and 13.");
        }
    }

        /**
         * Gets the suit of the card.
         * @return suit of the card.
         */
        public Suit getSuit() {
            return suit;
        }

        /**
         * Gets the rank of the card.
         * @return rank of the card.
         */
        public Rank getRank() {
            return rank;
        }

        /**
         * Returns the color of the card.
         * @return "RED" if the suit is DIAMONDS/HEARTS, "BLACK" if CLUBS/SPADES.
         */
        public String getColor() {
            return suit.getColor();
        }

        /**
         * Compares this card's rank with another (other) card's rank.
         * @param other the card to compare.
         * @return -1 if the rank of this card is less than the rank of the other card,
         * 1 if the rank of this card is greater than the rank of the other card,
         * and 0 if the rank of this card and the rank of the other card are equal.
         */
        public int compareTo(Card other){
            // Compare
            if (this.rank.ordinal() < other.rank.ordinal()) {
                return -1;
            }
            else if (this.rank.ordinal() > other.rank.ordinal()) {
                return 1;
            }
            else {
                return 0;
            }
        }

        /**
         * Checks whether some other object is 'equal to' this one.
         * @param o the card to compare.
         * @return true if the objects are equal, false otherwise.
         */
        @Override
        public boolean equals(Object o) {
            // Short circuit: is o the same as this?
            if (this == o) {
                return true;
            }

            // Is o  the same type as this?
            if (!(o instanceof Card)) {
                return false;
            }

            // Cast to the correct type
            Card other = (Card)o;

            // Below is the actual definition of equality
            return this.rank.equals(other.rank) && this.suit.equals(other.suit);
        }

        /**
         * Returns a hash code value for the card.
         * @return a hash code value for this card.
         */
        // Generates a hash code for the 'Card' object based on suit and rank
        @Override
        public int hashCode() {
            return Objects.hash(suit, rank);
        }

        /**
        * Returns a string representation of the card.
        * @return a string representation of the card.
        */
        public String toString() {
            return "Card: " + rank + " of " + suit;
        }
    }