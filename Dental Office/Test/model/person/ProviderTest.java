package model.person;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProviderTest {
    private Provider provider;

    @Before
    public void setUp() throws Exception {
        provider = new Provider("Olivia", "Johnson", 1234567890, "Dentist");
    }

    @Test
    public void testGetNPI() {
        assertEquals(1234567890, provider.getNPI());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalNPI() {
        new Provider("Olivia", "Johnson", 1234, "Dentist");
    }

    @Test
    public void testGetSpecialty() {
        assertEquals("Dentist", provider.getSpecialty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSpecialty() {
        new Provider("Olivia", "Johnson", 1234567890, "Pediatrics");
    }

    @Test
    public void testToString() {
        String expected = "Doctor's Name: Olivia Johnson\n" +
                          "NPI: 1234567890\n" +
                          "Specialty: Dentist";
        assertEquals(expected, provider.toString());
    }
}