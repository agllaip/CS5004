/**
 * This class represents a doctor. A doctor has a name, NPI number, specialty, ...
 */
public class Doctor extends Person{
    private int NPI;
    private String specialty;

    /**
     * Constructs a Doctor object with the specified attributes.
     * @param firstName the first name of the doctor.
     * @param lastName the last name of the doctor.
     * @param NPI the doctor's NPI number.
     * @param specialty the doctor's specialty.
     */
    public Doctor(String firstName, String lastName, int NPI, String specialty) {
        super(firstName, lastName);
        this.NPI = NPI;
        this.specialty = specialty;
    }

    /**
     * Gets the doctors NPI number.
     * @return this doctor's NPI number.
     */
    public int getNPI() {
        return NPI;
    }

    /**
     * Get the doctors dental specialty.
     * @return this doctor's dental specialty.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Returns a string representation of this doctor with their full name.
     * @return a formatted string.
     */
    @Override
    public String toString() {
        return "Doctor's Name: " + super.getFullName() + "\n" +
                "NPI: " + NPI + "\n" +
                "Specialty: " + specialty;
    }
}