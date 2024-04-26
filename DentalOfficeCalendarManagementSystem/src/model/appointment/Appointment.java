package model.appointment;

import model.appointment.enums.ProviderType;
import model.appointment.interfaces.IAppointment;
import model.appointment.interfaces.IAppointmentType;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This abstract class represents an appointment, including details important to appointments such as length,
 * date, and time. This abstract class is designed to be extended by more specific types of appointments.
 */
public abstract class Appointment implements IAppointment {
    private int appointmentLength;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private ProviderType providerType;

    /**
     * Constructs an Appointment object with the specified parameters.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param providerType the type of provider for the appointment.
     */
    public Appointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                       ProviderType providerType) {
        setAppointmentLength(appointmentLength);
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.providerType = providerType;
    }

    /**
     * Gets the type of appointment the specified provider will be providing to the patient.
     * @return the type appointment.
     */
    public abstract IAppointmentType getAppointmentType();

    /**
     * Get the length of this appointment.
     * @return the length of this appointment in minutes.
     */
    public int getAppointmentLength() {
        return this.appointmentLength;
    }

    /**
     * Sets the length of this appointment.
     * @param appointmentLength length of this appointment in minutes.
     * @throws IllegalArgumentException if the length of appointment is less than 15 minutes.
     */
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
    @Override
    public LocalDate getAppointmentDate() {
        return this.appointmentDate;
    }

    /**
     * Set the date of this appointment.
     * @param appointmentDate the date for this appointment.
     * @throws IllegalArgumentException if the date of appointment is in the past.
     */
    @Override
    public void setAppointmentDate(LocalDate appointmentDate) {
        if (appointmentDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date  of appointment can't be in the past.");
        }
        this.appointmentDate = appointmentDate;
    }

    /**
     * Get the time of this appointment.
     * @return the time of this appointment.
     */
    @Override
    public LocalTime getAppointmentTime() {
        return this.appointmentTime;
    }

    /**
     * Set the time of this appointment.
     * @param appointmentTime the time for this appointment.
     */
    @Override
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * Gets the provider type for this appointment.
     * @return the type of provider associated with the appointment.
     */
    @Override
    public ProviderType getProviderType() {
        return this.providerType;
    }

    /**
     * Sets the provider type for this appointment.
     * @param providerType the type of provider associated with the appointment.
     */
    @Override
    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }

    /**
     * Reschedules this appointment to a new date and time.
     * @param newDate the new date to which the appointment is rescheduled.
     * @param newTime the new time to which the appointment is rescheduled.
     */
    @Override
    public void reschedule(LocalDate newDate, LocalTime newTime) {
        setAppointmentDate(newDate);
        setAppointmentTime(newTime);
    }

    /**
     * Returns a string representation of an appointment including the date, time and length of the appointment.
     * @return a string representation of an appointment.
     */
    @Override
    public String toString() {
        return "Appointment on " + appointmentDate + " at " + appointmentTime + " for " + appointmentLength + " minutes.";
    }
}