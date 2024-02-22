/**
 * This class represents a card.
 */
public class Card implements Comparable<Card> {
    public Suit suit;
    private Rank rank;

    /**
     * Construct a card object using the given three points of the triangle.
     * @param suit ...
     * @param rank ...
     * @throws IllegalArgumentException if ...
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        // Check the validity of the rank in the constructor to detect the issue early when the Card object is created
        // You can handle the problem before the object is used elsewhere in your code
        // Is this how you account for if the rank is out of range.
        if (rank == null || rank.ordinal() < 1 || rank.ordinal() > 13) {                 // Double check this!!!!!
            throw new IllegalArgumentException("Invalid rank.");
        }
    }

        /**
         * Gets the suit of a card.
         * @return suit of a card.
         */
        public Suit getSuit () {
            return suit;
        }

        /**
         * Gets the rank of a card.
         * @return rank of a card.
         */
        public Rank getRank () {
            return rank;
        }

        /**
         * Returns an Enum RED or BLACK depending on whether the suit is DIAMONDS/HEARTS versus CLUBS/SPADES
         * @return ...
         */
        public String getColor () {
            return suit.getColor();
        }

        /**
         *
         * @param otherCard the object to be compared.
         * @return ....
         */
        public int compareTo (Card otherCard){
            // Compare
            if (this.rank < other.rank) {
                return -1;
            }
            else if (this.rank > other.rank) {
                return 1;
            }
            else {
                return 0;
            }
        }

        public int hashCode() {
            return ...;
        }

        /**
        * Returns a string of the suit and rank of a card.
        * @return a string representation of the suit and rank of a card.
        */
        public String toString () {
            return "Card: " + suit + rank;
        }
    }