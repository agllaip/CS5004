package model.appointment.interfaces;

import model.appointment.enums.ProviderType;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This interface provides the signatures for appointment-related operations.
 * Outlined are methods to manage and manipulate basic appointment details.
 */
public interface IAppointment {

    /**
     * Gets the date of the appointment.
     * @return the date of the appointment.
     */
    LocalDate getAppointmentDate();

    /**
     * Sets the date of the appointment.
     * @param date of the appointment.
     */
    void setAppointmentDate(LocalDate date);

    /**
     * Gets the time of the appointment.
     * @return the time of the appointment.
     */
    LocalTime getAppointmentTime();

    /**
     * Sets the time of the appointment.
     * @param time of the appointment.
     */
    void setAppointmentTime(LocalTime time);

    /**
     * Gets the type of provider associated with the appointment.
     * @return the type of provider associated with the appointment.
     */
    ProviderType getProviderType();

    /**
     * Sets the type of provider associated with the appointment.
     * @param providerType the type of provider associated with the appointment.
     */
    void setProviderType(ProviderType providerType);

    /**
     * Reschedules the appointment to a new date and time.
     * @param newDate the new date to which the appointment is rescheduled.
     * @param newTime the new time to which the appointment is rescheduled.
     */
    void reschedule(LocalDate newDate, LocalTime newTime);
}