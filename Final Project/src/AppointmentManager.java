package src;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentManager {

    public void createAppointment(LocalDate appointmentDate, LocalTime appointmentTime, int appointmentLength,
                                  String patientFullName, String providerFullName, String appointmentType) {

        Appointment appointment = new Appointment(appointmentLength, appointmentDate, appointmentTime,
                patientFullName, providerFullName, appointmentType);

        calendar.addAppointment(appointment);
    }

    public void scheduleAppointment();

    /**
     *
     * @param appointment
     * @param newAppointmentDate
     * @param newAppointmentTime
     */
    public void rescheduleAppointment(Appointment appointment, LocalDate newAppointmentDate, LocalTime newAppointmentTime) {

        appointment.setAppointmentDate(newAppointmentDate);
        appointment.setAppointmentTime(newAppointmentTime);
    }

    /**
     *
     * @param appointment
     */
    public void cancelAppointment(Appointment appointment) {

        // Should I check if the appointment exists before I remove it?

        calendar.removeAppointment(appointment);
    }

    public void waitlistAppointment();

    /**
     *
     * @param appointment
     * @param newAppointmentLength
     */
    public void editAppointmentLength(Appointment appointment, int newAppointmentLength) {
        appointment.setAppointmentLength(newAppointmentLength);
    }

    public void editAppointmentProvider(Appointment appointment, String newProviderFullName) {

    }

    /**
     *
     * @param appointment
     * @param newAppointmentDate
     */
    public void editAppointmentDate(Appointment appointment, LocalDate newAppointmentDate) {
        appointment.setAppointmentDate(newAppointmentDate);
    }

    /**
     *
     * @param appointment
     * @param newAppointmentTime
     */
    public void editAppointmentTime(Appointment appointment, LocalTime newAppointmentTime) {
        appointment.setAppointmentTime(newAppointmentTime);
    }

    public void sendAppointmentReminder();
}