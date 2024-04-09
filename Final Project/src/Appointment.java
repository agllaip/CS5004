package src;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This abstract class represents an appointment, including its length, date, and time.
 * This abstract class is designed to be extended by more specific types of appointments.
 */
public abstract class Appointment {

    private int appointmentLength;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    /**
     * Constructs an Appointment object and initializes it to the given length of
     * appointment, appointment date, and appointment time.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @throws IllegalArgumentException if the length of appointment is less than 15 minutes.
     */
    public Appointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime) {
        setAppointmentLength(appointmentLength);  // Uses setter for validation
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    /**
     * Get the length of this appointment.
     * @return the length of this appointment in minutes.
     */
    public int getAppointmentLength() {
        return this.appointmentLength;
    }

    public void setAppointmentLength(int appointmentLength) {
        if (appointmentLength < 15) {
            throw new IllegalArgumentException("Length of appointment can't be less than 15 minutes.");
        }

        this.appointmentLength = appointmentLength;
    }

    /**
     * Get the date of this appointment.
     * @return the date of this appointment.
     */
    public LocalDate getAppointmentDate() {
        return this.appointmentDate;
    }

    /**
     * Set the date of this appointment.
     * @param appointmentDate the date for this appointment.
     */
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Get the time of this appointment.
     * @return the time of this appointment.
     */
    public LocalTime getAppointmentTime() {
        return this.appointmentTime;
    }

    /**
     * Set the time of this appointment.
     * @param appointmentTime the time for this appointment.
     */
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment on " + appointmentDate + " at " + appointmentTime + " for " + appointmentLength + " minutes.";
    }
}