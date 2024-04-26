package model.person;

import java.util.Arrays;
import java.util.List;

/**
 * The Provider class represents a dental office provider, extending the Person class.
 * A provider is represented by their name, NPI (National Provider Identification) number
 * and the dental specialty they work in.
 */
public class Provider extends Person {
    private final long NPI;
    private final String specialty;

    /**
     * Constructs a Provider object with the personal and professional details.
     * @param firstName the first name of the doctor.
     * @param lastName the last name of the doctor.
     * @param NPI the provider's NPI number.
     * @param specialty the provider's specialty.
     * @throws IllegalArgumentException if the NPI number is not 10 digits.
     */

    public Provider(String firstName, String lastName, long NPI, String specialty) {
        super(firstName, lastName);

        if (String.valueOf(NPI).length() != 10) {
            throw new IllegalArgumentException("NPI number must be 10 digits.");
        }

        List<String> allowedSpecialties = Arrays.asList("Dentist", "Hygienist", "Periodontist");
        if (!allowedSpecialties.contains(specialty)) {
            throw new IllegalArgumentException("Invalid specialty.");
        }

        this.NPI = NPI;
        this.specialty = specialty;
    }

    /**
     * Gets the provider's NPI number.
     * @return this provider's NPI number.
     */
    public long getNPI() {
        return this.NPI;
    }

    /**
     * Gets the provider's dental specialty.
     * @return this provider's dental specialty.
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     * Returns a string representation of this provider with their full name, NPI number, and specialty.
     * @return a formatted string of this provider with their full name, NPI number, and specialty.
     */
    @Override
    public String toString() {
        return "Doctor's Name: " + super.getFullName() + "\n" +
                "NPI: " + NPI + "\n" +
                "Specialty: " + specialty;
    }
}