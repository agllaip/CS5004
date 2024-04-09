package src;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {
    private TicTacToeModel TTTModel;

    @Before
    public void setUp() throws Exception {
        TTTModel = new ConcreteTicTacToeModelClass();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMoveInvalidPosition() {
        TTTModel.move(5,5);
    }

    @Test (expected = IllegalStateException.class)
    public void testMoveOccupiedPosition() {
        TTTModel.move(1,1);                     // X plays
        TTTModel.move(1,1);                     // Y attempts to play at the same spot
    }

    @Test
    public void testNextPlayer() {
        TTTModel.move(1,1);                     // X moves first
        assertEquals(Player.O, TTTModel.nextPlayer());      // Y should be the next player
    }

    @Test
    public void testIsGameOver() {
        assertFalse(TTTModel.isGameOver());
    }

    @Test
    public void testGetWinner() {
        TTTModel.move(1,1);
        TTTModel.move(2,2);
        TTTModel.move(0,0);
        TTTModel.move(2,1);
        TTTModel.move(2,0);
        TTTModel.move(0,2);
        TTTModel.move(1,0);

        assertTrue(TTTModel.isGameOver());
        assertEquals(Player.X, TTTModel.getWinner());
    }

    @Test
    public void testTieGame() {
        TTTModel.move(0,0);
        TTTModel.move(1,1);
        TTTModel.move(2,2);
        TTTModel.move(0,2);
        TTTModel.move(0,1);
        TTTModel.move(2,0);
        TTTModel.move(1,0);
        TTTModel.move(1,2);
        TTTModel.move(2,1);

        assertTrue("The game should be over.", TTTModel.isGameOver());
        assertEquals("The game should be a tie.", Player.null, TTTModel.getWinner());
    }

    @Test (expected = IllegalStateException.class)
    public void testGetWinnerBeforeGameIsOver() {
        TTTModel.getWinner();
    }

    @Test
    public void testGetBoard() {
        TTTModel.move(1,1);                     // X moves
        Player[][] expectedBoard = new Player[3][3];
        expectedBoard[1][1] = Player.X;
        assertArrayEquals(expectedBoard, TTTModel.getBoard());
    }
}