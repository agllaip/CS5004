package model.appointment.interfaces;

/**
 * This interface provides a method that retrieves the type of appointment that is being scheduled.
 */
public interface IAppointmentType {

    /**
     * Gets the appointment type.
     * @return a string representing the type of appointment.
     */
    String getAppointmentName();
}