package src;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments of a dentist. An appointment has the following attributes:
 * length of appointment, appointment date, appointment time, and three different appointment types.
 */
public class DentistAppointment extends Appointment {

    public enum AppointmentType {
        crownPrep, crownPlacement, emergency
    }

    private AppointmentType appointmentType;

    /**
     * Constructs an DentistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param appointmentType appointment type
     */
    public DentistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                              AppointmentType appointmentType) {
        super(appointmentLength, appointmentDate, appointmentTime);
        this.appointmentType = appointmentType;
    }

    public AppointmentType getAppointmentType(AppointmentType appointmentType) {
        return this.appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }
}