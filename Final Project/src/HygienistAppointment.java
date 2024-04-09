package src;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments of a hygienist. An appointment has the following attributes:
 * length of appointment, appointment date, appointment time, and three different appointment types.
 */
public class HygienistAppointment extends Appointment {
    private String childCleaning;
    private String adultCleaning;
    private String scalingRootPlanning;

    /**
     * Constructs an PeriodontistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param childCleaning appointment type - cleaning for a child.
     * @param adultCleaning appointment type - cleaning for an adult.
     * @param scalingRootPlanning appointment type - deep cleaning.
     */
    public HygienistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                              String childCleaning, String adultCleaning, String scalingRootPlanning) {
        super(appointmentLength, appointmentDate, appointmentTime);
        this.childCleaning = childCleaning;
        this.adultCleaning = adultCleaning;
        this.scalingRootPlanning = scalingRootPlanning;
    }
}