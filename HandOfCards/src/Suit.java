public enum Suit {

    CLUBS("BLACK"),
    HEARTS("RED"),
    DIAMONDS("RED"),
    SPADES("BLACK");

    // Store the color associated with each suit:
    private final String color;
    //private final String suit;

   Suit(String color) {
        this.color = color;
        //this.suit = suit;
    }

    public String getColor() {
       return color;
    }

    //public String getSuit() {
        //return suit;
    //}
}