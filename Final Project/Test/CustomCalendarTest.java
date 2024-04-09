package Test;
import org.junit.Before;
import org.junit.Test;
import src.CustomCalendar;

import static org.junit.Assert.*;

public class CustomCalendarTest {

    private CustomCalendarTest calendar;

    @Before
    public void setUp() {
        // Create a customCalendar instance with a specific month
        calendar = new CustomCalendarTest(12, 26, 1994);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        CustomCalendarTest invalidMonth = new CustomCalendarTest(15, 26, 1994);
        CustomCalendarTest invalidDay = new CustomCalendarTest(12, 33, 1994);
        CustomCalendarTest invalidYear = new CustomCalendarTest(15, 26, -2000);
    }

    @Test
    public void testGetMonth() {

        // Get month
        int month = calendar.getMonth();

        // Check if the months match
        assertEquals(12, month);
    }

    @Test
    public void testGetDay() {

        int day = calendar.getDay();

        assertEquals(26, day);
    }

    @Test
    public void testGetYear() {
        int year = calendar.getYear();

        assertEquals(1994, year);
    }

    @Test
    public void testGetDate() {
        String expected = "12 26 1994";

        String date = calendar.getDate();

        assertEquals(expected, date);
    }

    @Test
    public void testToString() {
        // Expected string representation
        String expected = "12 26 1994";

        // Get string representation
        String result = calendar.toString();

        // Check if result matches expected string representation
        assertEquals(expected, result);
    }
}