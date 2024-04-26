package src;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentManager {
    private CustomCalendar calendar;

    public AppointmentManager(CustomCalendar calendar) {
        this.calendar = calendar;
    }

    public void createAppointment(LocalDate appointmentDate, LocalTime appointmentTime, int appointmentLength,
                                  String patientFullName, String providerFullName, String appointmentType) {

        Appointment appointment = new Appointment(appointmentLength, appointmentDate, appointmentTime,
                                  patientFullName, providerFullName, appointmentType);

        calendar.addAppointment(appointment);
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newAppointmentDate, LocalTime newAppointmentTime) {
        if (calendar.getAppointmentList().contains(appointment)) {
            appointment.setAppointmentDate(newAppointmentDate);
            appointment.setAppointmentTime(newAppointmentTime);
        }
        else {
            throw new IllegalArgumentException("Appointment does not exist.");
        }
    }

    public void cancelAppointment(Appointment appointment) {
        if (calendar.getAppointmentList().contains(appointment)) {
            calendar.removeAppointment(appointment);
        }
        else {
            throw new IllegalArgumentException("Appointment does not exist.");
        }
    }

    public void editAppointmentLength(Appointment appointment, int newAppointmentLength) {
        if (calendar.getAppointmentList().contains(appointment)) {
            appointment.setAppointmentLength(newAppointmentLength);
        }
        else {
            throw new IllegalArgumentException("Appointment does not exist.");
        }
    }

    public void editAppointmentDate(Appointment appointment, LocalDate newAppointmentDate) {
        rescheduleAppointment(appointment, newAppointmentDate, appointment.getAppointmentTime());
    }

    public void editAppointmentTime(Appointment appointment, LocalTime newAppointmentTime) {
        rescheduleAppointment(appointment, appointment.getAppointmentDate(), newAppointmentTime);
    }

    public void sendAppointmentReminder();
}