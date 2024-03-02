import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * This test contains all the unit tests for card.
 */
public class CardTest {
    private Card card1;
    private Card card2;
    private Card card3;
    @Before
    public void setUp() throws Exception {
        card1 = new Card(Suit.CLUBS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.FOUR);
        card3 = new Card(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.CLUBS, card1.getSuit());
        assertEquals(Suit.HEARTS, card2.getSuit());
    }

    @Test
    public void testGetRank() {
        assertEquals(Rank.ACE, card1.getRank());
        assertEquals(Rank.FOUR, card2.getRank());
    }

//    @Test (expected = IllegalArgumentException.class)
//    public void testInvalidRank() throws IllegalArgumentException{
////        new Card(Suit.DIAMONDS, Rank.JOKER);
//    }

    @Test
    public void testGetColor() {
        assertEquals("BLACK", card1.getColor());
        assertEquals("RED", card2.getColor());
    }

    @Test
    public void testCompareTo() {
        assertTrue(card1.compareTo(card2) < 0);
        assertTrue(card2.compareTo(card1) > 0);
        assertFalse(card1.compareTo(card2) > 0);
        assertFalse(card2.compareTo(card1) < 0);
        assertEquals(0, card1.compareTo(card3));
    }

    @Test
    public void testToString() {
        assertEquals("Card: ACE of CLUBS", card1.toString());
        assertEquals("Card: FOUR of HEARTS", card2.toString());
    }
}
