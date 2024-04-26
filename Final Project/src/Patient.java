package src;

/**
 * This class represents a patient. A patient has a name, date of birth, patient ID, phone number, ...
 */
public class Patient extends Person{
    private int dateOfBirth;
    private int patientID;
    private int phoneNumber;
    private String email;
    private AppointmentType appointmentType;



    /**
     * Constructs a Patient object with the specified attributes.
     * @param firstName the first name of the patient.
     * @param lastName the last name of the patient.
     * @param dateOfBirth the date of birth of the patient.
     * @param patientID the patient's medical ID number.
     * @param phoneNumber the patient's phone number.
     * @param email the patient's email address.
     * @param appointmentType the type of appointment, defining the priority.
     */
    public Patient(String firstName, String lastName, int dateOfBirth, int patientID, int phoneNumber, String email,
                   AppointmentType appointmentType) {
        super(firstName,lastName);
        this.dateOfBirth = dateOfBirth;
        this.patientID = patientID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.appointmentType = appointmentType;
    }

    /**
     * Gets the patient's date of birth.
     * @return this patient's date of birth.
     */
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets the patient's medical ID number.
     * @return this patient's medical ID number.
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * Gets the patients phone number.
     * @return this patient's phone number.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * gets the patient's email address.
     * @return this patient's email address.
     */
    public String getEmail() {
        return email;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    /**
     * Returns a string representation of this patient with their full name.
     * @return a formatted string.
     */
    @Override
    public String toString() {
        return "Patient Name: " + super.getFullName() + "\n" +
                "ID: " + patientID + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Appointment Type: " + appointmentType;
     }
}