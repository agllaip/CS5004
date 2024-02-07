import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FractionImplTest {

    private FractionImpl fraction;

    @Before
    public void setUp() {
        fraction = new FractionImpl(6,9);
    }

    @Test
    public void testGetNumerator() {
        assertEquals(6, fraction.getNumerator());
    }

    @Test
    public void testSetNumerator() {
        fraction.setNumerator(8);
        assertEquals(8, fraction.getNumerator());
    }

    @Test
    public void testGetDenominator() {
        assertEquals(9, fraction.getDenominator());
    }

    @Test
    public void testSetDenominator() {
        fraction.setNumerator(2);
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testToDouble() {
        assertEquals(0.666, fraction.toDouble(), 0.001);
    }

    @Test
    public void testGcd() {
        assertEquals(3, FractionImpl.gcd(6,9));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGcdException() {
        FractionImpl.gcd(6,0);
    }

    @Test
    public void testToString() {
        assertEquals("2 / 3", fraction.toString());
    }

    @Test
    public void testReciprocal() {
        Fraction reciprocal = fraction.reciprocal();
        assertEquals("3 / 2", reciprocal.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testReciprocalException() {
        FractionImpl zeroNumerator = new FractionImpl(0,9);
        zeroNumerator.reciprocal();
    }

    @Test
    public void testAdd() {
        FractionImpl fraction1 = new FractionImpl(4, 10);
        FractionImpl fraction2 = new FractionImpl(9, 20);
        Fraction result = fraction1.add(fraction2);
        assertEquals("17 / 20", result.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddException() {
        FractionImpl zeroDenominator = new FractionImpl(6,0);
        FractionImpl fraction2 = new FractionImpl(9, 20);
        zeroDenominator.add(fraction2);
    }

    @Test
    public void testCompareTo() {
        FractionImpl fraction1 = new FractionImpl(4, 10);
        FractionImpl fraction2 = new FractionImpl(9, 20);
        assertEquals(-1, fraction1.compareTo(fraction2));
    }
}