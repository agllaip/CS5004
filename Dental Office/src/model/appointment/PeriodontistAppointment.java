package model.appointment;

import model.appointment.enums.PeriodontistAppointmentType;
import model.appointment.enums.ProviderType;
import model.appointment.interfaces.IAppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments specific to a periodontist. This class extends Appointment, the
 * appointments that a periodontist provides have the following attributes: length of appointment, appointment
 * date, appointment time, and three different appointment types.
 */
public class PeriodontistAppointment extends Appointment {
    private IAppointmentType periodontistAppointmentType;

    /**
     * Constructs an PeriodontistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param periodontistAppointmentType the type of periodontist appointment.
     * @param providerType the type of provider.
     */
    public PeriodontistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                                   IAppointmentType periodontistAppointmentType, String providerType) {

        super(appointmentLength, appointmentDate, appointmentTime, ProviderType.valueOf(providerType));
        this.periodontistAppointmentType = periodontistAppointmentType;
    }

    /**
     * Sets the type of periodontist appointment.
     * @param periodontistAppointmentType the type of periodontist appointment.
     */
    public void setPeriodontistAppointmentType(PeriodontistAppointmentType periodontistAppointmentType) {
        this.periodontistAppointmentType = periodontistAppointmentType;
    }

    /**
     * Get the type of periodontist appointment.
     * @return the type of dentist appointment.
     */
    public IAppointmentType getAppointmentType() {
        return this.periodontistAppointmentType;
    }
}