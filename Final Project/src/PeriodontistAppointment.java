package src;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents the appointments of a periodontist. An appointment has the following attributes:
 * length of appointment, appointment date, appointment time, and three different appointment types.
 */
public class PeriodontistAppointment extends Appointment{

    private String dentalImplant;
    private String scalingRootPlanning;
    private String extraction;

    /**
     * Constructs an PeriodontistAppointment object and initializes it to the given length of
     * appointment, appointment date, appointment time, and three different appointment types.
     * @param appointmentLength the length of the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param dentalImplant appointment type - implant placement.
     * @param scalingRootPlanning appointment type - deep cleaning.
     * @param extraction appointment type - tooth extraction.
     */
    public PeriodontistAppointment(int appointmentLength, LocalDate appointmentDate, LocalTime appointmentTime,
                                        String dentalImplant, String scalingRootPlanning, String extraction) {

        super(appointmentLength, appointmentDate, appointmentTime);
        this.dentalImplant = dentalImplant;
        this.scalingRootPlanning = scalingRootPlanning;
        this.extraction = extraction;

    }
}