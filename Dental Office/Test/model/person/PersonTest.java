package model.person;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person("Agllai", "Papaj");
    }

    @Test
    public void testPersonConstructor() {
        // Verify constructor sets first and last name correctly
        assertNotNull("The person instance should not be null", person);
        assertEquals("Agllai", person.getFirstName());
        assertEquals("Papaj", person.getLastName());
    }

    @Test
    public void testSetFirstName() {
        // Change the first name and verify the change
        person.setFirstName("Eleni");
        assertEquals("Eleni", person.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameWithNull() {
        person.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstName() {
        new Person(null, "Papaj");
    }

    @Test
    public void testSetLastName() {
        // Change the last name and verify the change
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLastNameWithNull() {
        person.setLastName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLastName() {
        new Person("Agllai", null);
    }

    @Test
    public void testGetFullName() {
        assertEquals("Agllai Papaj", person.getFullName());

        person.setFirstName("Eleni");
        person.setLastName("Papaj");
        assertEquals("Eleni Papaj", person.getFullName());
    }

    @Test
    public void testToString() {
        assertEquals("Agllai Papaj", person.toString());
    }
}