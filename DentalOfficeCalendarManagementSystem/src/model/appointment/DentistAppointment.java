package model.appointment;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.ProviderType;
import model.appointment.interfaces.IAppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments specific to a general dentist. This class extends Appointment, the
 * appointments that a general dentist provides have the following attributes: length of appointment, appointment
 * date, appointment time, and three different appointment types.
 */
public class DentistAppointment extends Appointment {
    private IAppointmentType dentistAppointmentType;

    /**
     * Constructs an DentistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment in minutes.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param dentistAppointmentType the type of dentist appointment.
     * @param providerType the type of provider.
     */
    public DentistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                              IAppointmentType dentistAppointmentType, String providerType) {
        super(appointmentLength, appointmentDate, appointmentTime, ProviderType.valueOf(providerType));
        this.dentistAppointmentType = dentistAppointmentType;
    }

    /**
     * Sets the type of dentist appointment.
     * @param dentistAppointmentType the type of dentist appointment.
     */
    public void setDentistAppointmentType(DentistAppointmentType dentistAppointmentType) {
        this.dentistAppointmentType = dentistAppointmentType;
    }

    /**
     * Get the type of dentist appointment.
     * @return the type of dentist appointment.
     */
    public IAppointmentType getAppointmentType() {
        return this.dentistAppointmentType;
    }
}