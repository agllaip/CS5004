import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HandImplTest {
    private HandImpl hand;
    @Before
    public void setUp() throws Exception {
        // Initialize a new HandImpl object before each test
        hand = new HandImpl();
    }

    @Test
    public void add() {
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        // Add a card to the hand
        hand.add(card);
        // Check that the size of the hand is 1 after adding 1 card
        assertEquals(1, hand.getSize());
        // Check if added card is the same as the one retrieved from hand
        assertEquals(card, hand.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void discard() {
        Card card = new Card(Suit.HEARTS, Rank.FOUR);
        hand.add(card);
        hand.discard(0);
        // Check if the hand is empty after discarding the only card
        assertTrue(hand.isEmpty());
        // Attempt to discard from empty hand (should throw exception)
        hand.discard(0);
    }

    @Test
    public void get() {
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        hand.add(card);
        // Check if the retrieved card is the same as the one added to the hand
        assertEquals(card, hand.get(0));
    }

    @Test
    public void getSize() {
        assertEquals(0, hand.getSize());
        hand.add(Suit.HEARTS, Rank.FOUR);
        hand.add(Suit.CLUBS, Rank.ACE);
        assertEquals(2, hand.getSize());
    }

    @Test
    public void isEmpty() {
        // Check that hand is empty
        assertTrue(hand.isEmpty());
        // Add card
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        // Check if card is empty (not empty)
        assertFalse(hand.isEmpty());

    }

    @Test
    public void find() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        hand.add(card1);
        hand.add(card2);
        assertEquals(0, hand.find(card2));
        assertEquals(1, hand.find(card1));
    }

    @Test
    public void sortHand() {
    }

    @Test
    public void getHand() {
    }

    @Test
    public void rankSum() {
    }

    @Test
    public void getMap() {
    }
}