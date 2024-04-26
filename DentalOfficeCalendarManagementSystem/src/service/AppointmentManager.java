package service;

import model.appointment.*;
import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.PeriodontistAppointmentType;
import model.calendar.CustomCalendar;
import model.person.Provider;
import java.time.LocalDate;
import java.time.LocalTime;
import model.appointment.enums.EnumUtility;

/**
 * The AppointmentManager class manages the creation, scheduling, rescheduling, and cancellation of appointments.
 * AppointmentManager makes sure that appointments are created within the constraints of business days and hours.
 */
public class AppointmentManager {
    private CustomCalendar calendar;

    /**
     * Constructs an AppointmentManager to handle operations related to a given calendar.
     * @param calendar calendar this manager will operate with.
     */
    public AppointmentManager(CustomCalendar calendar) {
        this.calendar = calendar;
    }

    private void validateAppointmentDateAndTime(LocalDate date, LocalTime time, int length) throws IllegalArgumentException {
        if (calendar.isWeekend(date)) {
            throw new IllegalArgumentException("Appointments must be scheduled within business days, Monday to Friday.");
        }
        if (!calendar.isWithinBusinessHours(time, length)) {
            throw new IllegalArgumentException("Appointments must be scheduled within business hours, 8am to 5pm.");
        }
    }

    /**
     * Creates and schedules an appointment based on the provided parameters.
     * @param provider the provider that the patient is scheduling their appointment with.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param appointmentLength the length of the appointment in minutes.
     * @param patientFullName the patient's full name.
     * @param providerFullName the provider's full name.
     * @param appointmentType the type of appointment the patient is having.
     * @throws IllegalArgumentException if the appointment falls on a weekend or outside business hours.
     */
    public void createAppointment(Provider provider, LocalDate appointmentDate, LocalTime appointmentTime,
                                  int appointmentLength, String patientFullName, String providerFullName,
                                  String appointmentType) {
        validateAppointmentDateAndTime(appointmentDate, appointmentTime, appointmentLength);

        Appointment appointment;
        try {
            switch (provider.getSpecialty()) {
                case "Dental Hygiene":
                    appointment = new HygienistAppointment(appointmentLength, appointmentDate, appointmentTime,
                            EnumUtility.fromString(HygienistAppointmentType.class, appointmentType), provider.getSpecialty());
                    break;
                case "General Dentistry":
                    appointment = new DentistAppointment(appointmentLength, appointmentDate, appointmentTime,
                            EnumUtility.fromString(DentistAppointmentType.class, appointmentType), provider.getSpecialty());
                    break;
                case "Periodontics":
                    appointment = new PeriodontistAppointment(appointmentLength, appointmentDate, appointmentTime,
                            EnumUtility.fromString(PeriodontistAppointmentType.class, appointmentType), provider.getSpecialty());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown provider type.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        calendar.addAppointment(provider, appointment);
        System.out.println("Appointment has been scheduled for  " + patientFullName + " with Dr." + providerFullName);
    }

    /**
     * Reschedules an existing appointment to a new date and time.
     * @param provider the provider that the patient is scheduled with.
     * @param existingAppointment the appointment to be rescheduled.
     * @param newAppointmentDate new date of the appointment.
     * @param newAppointmentTime new time of the appointment.
     * @throws IllegalArgumentException if the new dat and time fall on a weekend or outside business hours.
     */
    public void rescheduleAppointment(Provider provider, Appointment existingAppointment, LocalDate newAppointmentDate,
                                      LocalTime newAppointmentTime) {

        validateAppointmentDateAndTime(newAppointmentDate, newAppointmentTime, existingAppointment.getAppointmentLength());

        existingAppointment.reschedule(newAppointmentDate, newAppointmentTime);
        System.out.println("Appointment has been rescheduled to  " + newAppointmentDate + " at " + newAppointmentTime);
    }

    /**
     * Cancels an existing appointment.
     * @param provider the provider that the patient is scheduled with.
     * @param appointment the appointment to cancel.
     */
    public void cancelAppointment(Provider provider, Appointment appointment) {
        calendar.removeAppointment(provider, appointment);
    }

    /**
     * Edits the length of the appointment and ensures the length is within business hours.
     * @param provider the provider that the patient is scheduled with.
     * @param appointment the appointment to adjust the length off.
     * @param newAppointmentLength the new length of the appointment in minutes.
     * @throws IllegalArgumentException if the new appointment length is not within business hours.
     */
    public void editAppointmentLength(Provider provider, Appointment appointment, int newAppointmentLength) {
        validateAppointmentDateAndTime(appointment.getAppointmentDate(), appointment.getAppointmentTime(), newAppointmentLength);
        appointment.setAppointmentLength(newAppointmentLength);
    }

    /**
     * Edits the date of the appointment and ensures the new date is not a weekend.
     * @param provider the provider that the patient is scheduled with.
     * @param appointment the appointment to change the date off.
     * @param newAppointmentDate the new date of the appointment.
     * @throws IllegalArgumentException if the new appointment date is on a weekend.
     */
    public void editAppointmentDate(Provider provider, Appointment appointment, LocalDate newAppointmentDate) {
        validateAppointmentDateAndTime(newAppointmentDate, appointment.getAppointmentTime(), appointment.getAppointmentLength());
        appointment.setAppointmentDate(newAppointmentDate);
    }

    /**
     * Edits the time of the appointment and ensures the new time is within business hours.
     * @param provider the provider that the patient is scheduled with.
     * @param appointment the appointment to change the time off.
     * @param newAppointmentTime the new time of the appointment.
     * @throws IllegalArgumentException if the new appointment length is not within business hours.
     */
    public void editAppointmentTime(Provider provider, Appointment appointment, LocalTime newAppointmentTime) {
        validateAppointmentDateAndTime(appointment.getAppointmentDate(), newAppointmentTime, appointment.getAppointmentLength());
        appointment.setAppointmentTime(newAppointmentTime);
    }
}