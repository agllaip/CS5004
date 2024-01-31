import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;


public class PetRockTest {
    private PetRock rocky;

    // Timeout rule:
    // @Rule
    //public Timeout globalTimeout = Timeout.seconds (10);

    @Before
    public void myTestSetUp() throws Exception {
        rocky = new PetRock("Rocky", 6.56);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Rocky", rocky.getName());
    }

    @Test                                                           // (expected = IllegalStateException.class)
    public void testUnhappyToStart() throws Exception {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() throws Exception {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Test
    public void getMass() throws Exception {
        assertEquals(6.56, rocky.getMass(), 0.001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nameFail() throws Exception {
        new PetRock("",6.56);
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNumber() throws Exception {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyNameFail() throws Exception {
        new PetRock ("", 6.56);
    }

    @Test
    public void testMassEquality() throws Exception {
        PetRock bolder = new PetRock("Bolder", 6.56);                   // Create another PetRock with the same mass
        assertEquals(6.56, bolder.getMass(), 0.001);               // Use to check equality of double values with a delta for precision
        //assertSame("Same mass expected.", rocky.getMass(), bolder.getMass());                              // Checks if they refer to the same object
    }

    @Test
    public void testToString() throws Exception {
        String expectedToString = "PetRock {name = 'Rocky', happy = false, mass = 6.56}";
        assertEquals(expectedToString, rocky.toString());
    }

    //@Test (timeout = 100)   // in ms
    //public void waitForHappyTimeout() throws Exception {
    //    rocky.waitTillHappy();
    //}
}