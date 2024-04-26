package model.person;

import model.appointment.interfaces.IAppointmentType;
import java.time.LocalDate;
import java.time.Period;

/**
 * This class represents a patient of a dental office, extending the Person. A patient is represented
 * by personal information as well as dental specific information; name, date of birth, patient ID,
 * phone number, email and appointment type.
 */
public class Patient extends Person {
    private final LocalDate dateOfBirth;
    private final long patientID;
    private String phoneNumber;
    private String email;
    private IAppointmentType appointmentType;

    /**
     * Constructs a Patient object with the specified attributes.
     * @param firstName the first name of the patient.
     * @param lastName the last name of the patient.
     * @param dateOfBirth the date of birth of the patient.
     * @param patientID the patient's unique medical ID number.
     * @param phoneNumber the patient's phone number.
     * @param email the patient's email address.
     * @param appointmentType the type of appointment, defining the priority.
     * @throws IllegalArgumentException if patient ID is negative or if a patient ID is greater
     * or less than 6 digits.
     */
    public Patient(String firstName, String lastName, LocalDate dateOfBirth, long patientID, String phoneNumber, String email,
                   IAppointmentType appointmentType) {
        super(firstName,lastName);

        if (patientID < 0) {
            throw new IllegalArgumentException("Patient ID must be non-negative.");
        }
        if ((patientID < 100000) || (patientID > 999999)) {
            throw new IllegalArgumentException("Patient ID must be 6 digits.");
        }

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
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Calculates the patient's age in years based on their date of birth and the current date.
     * @return this patient's age in years.
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * Gets the patient's unique 6 digit dental ID number.
     * @return this patient's unique 6 digit dental ID number.
     */
    public long getPatientID() {
        return patientID;
    }

    /**
     * Sets the patients phone number.
     * @param phoneNumber this patient's phone number to be set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the patients phone number.
     * @return this patient's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the patients email address.
     * @param email this patient's email address to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the patient's email address.
     * @return this patient's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the patients appointment type.
     * @param appointmentType this patient's appointment type to be set.
     */
    public void setAppointmentType(IAppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    /**
     * Gets the patient's appointment type.
     * @return this patient's appointment type.
     */
    public IAppointmentType getAppointmentType() {
        return appointmentType;
    }

    /**
     * Returns a string representation of this patient with their full name and other attributes.
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