import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class HandImplTest {
    private HandImpl hand;
    @Before
    public void setUp() throws Exception {
        hand = new HandImpl();
    }

    @Test
    public void testAdd() {
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        hand.add(card);
        assertEquals(1, hand.getSize());
        assertEquals(card, hand.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testDiscard() {
        Card card = new Card(Suit.HEARTS, Rank.FOUR);
        hand.add(card);
        hand.discard(0);
        // Check if the hand is empty after discarding the only card
        assertTrue(hand.isEmpty());
        // Attempt to discard from empty hand (should throw exception)
        hand.discard(0);
    }

    @Test
    public void testGet() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        hand.add(card2);
        hand.add(card1);
        assertEquals(card1, hand.get(0));
        assertEquals(card2, hand.get(1));
    }

    @Test
    public void testGetSize() {
        assertEquals(0, hand.getSize());
        hand.add(new Card(Suit.HEARTS, Rank.FOUR));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        assertEquals(2, hand.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hand.isEmpty());
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        assertFalse(hand.isEmpty());
    }

    @Test
    public void testFind() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        hand.add(card1);
        hand.add(card2);
        assertEquals(0, hand.find(card2));
        assertEquals(1, hand.find(card1));
    }

    @Test
    public void testSortHand() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        Card card3 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card4 = new Card(Suit.SPADES, Rank.SEVEN);

        hand.add(card1);
        hand.add(card4);
        hand.add(card3);
        hand.add(card2);

        hand.sortHand(Comparator.comparing(Card::getSuit));

        assertEquals(card1, hand.get(0));
        assertEquals(card2, hand.get(1));
        assertEquals(card3, hand.get(2));
        assertEquals(card4, hand.get(3));
    }

    @Test
    public void testGetHand() {
        // Declare hand object with the correct type
        HandImpl<Card> hand = new HandImpl<>();

        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        Card card3 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card4 = new Card(Suit.SPADES, Rank.SEVEN);

        hand.add(card1);
        hand.add(card4);
        hand.add(card3);
        hand.add(card2);

        List<Card> blackCards = hand.getHand(card -> card.getSuit().getColor().equals("BLACK"));
        assertTrue(blackCards.stream().allMatch(card -> card.getSuit().getColor().equals("BLACK")));

        List<Card> redCards = hand.getHand(card -> card.getSuit().getColor().equals("RED"));
        assertTrue(redCards.stream().allMatch(card -> card.getSuit().getColor().equals("RED")));

        List<Card> lessThanJackCards = hand.getHand(card -> card.getRank().getValue() < 11);
        assertTrue(lessThanJackCards.stream().allMatch(card -> card.getRank().getValue() < 11));
    }

    @Test
    public void testRankSum() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
        Card card3 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card4 = new Card(Suit.SPADES, Rank.SEVEN);

        hand.add(card1);
        hand.add(card4);
        hand.add(card3);
        hand.add(card2);

        assertEquals(24, hand.rankSum());
        hand.discard(0);
        assertEquals(20, hand.rankSum());
    }

    @Test
    public void testGetMap() {
        // Declare hand object with the correct type
        HandImpl<Card> hand = new HandImpl<>();

        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.FOUR);

        hand.add(card1);
        hand.add(card2);

        Hand<Suit> suitHand = hand.getMap(Card::getSuit);

        assertTrue(suitHand.get(0) instanceof Suit);
        assertTrue(suitHand.get(1) instanceof Suit);
    }
}