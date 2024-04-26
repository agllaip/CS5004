package model.appointment;

import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.ProviderType;
import model.appointment.interfaces.IAppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments specific to a hygienist. This class extends Appointment, the
 * appointments that a hygienist provides have the following attributes: length of appointment, appointment
 * date, appointment time, and three different appointment types.
 */
public class HygienistAppointment extends Appointment {
    private IAppointmentType hygienistAppointmentType;

    /**
     * Constructs an PeriodontistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param hygienistAppointmentType the type of hygienist appointment.
     * @param providerType the type of provider.
     */
    public HygienistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                                IAppointmentType hygienistAppointmentType, String providerType) {
        super(appointmentLength, appointmentDate, appointmentTime, ProviderType.valueOf(providerType));
        this.hygienistAppointmentType = hygienistAppointmentType;
    }

    /**
     * Sets the type of hygienist appointment.
     * @param hygienistAppointmentType the type of hygienist appointment.
     */
    public void setHygienistAppointmentType(HygienistAppointmentType hygienistAppointmentType) {
        this.hygienistAppointmentType = hygienistAppointmentType;
    }

    /**
     * Gets the type of hygienist appointment.
     * @return the type of dentist appointment.
     */
    public IAppointmentType getAppointmentType() {
        return this.hygienistAppointmentType;
    }
}