package model.calendar;

import model.appointment.Appointment;
import model.appointment.AppointmentPriorityComparator;
import model.person.Provider;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * This class represents a calendar for a dental office. Operations like scheduling appointments,
 * canceling appointments, managing a cancellation list, and general calendar management operations
 * are outlined.
 */
public class CustomCalendar {
    private final LocalDate date;
    private final Map<Provider, List<Appointment>> appointmentsByProvider;
    private PriorityQueue<Appointment> cancellationList;

    /**
     * Creates a specific day in our calendar. Initializes all parameters associated with creating
     * a day in the dental offices calendar.
     * @param year the year of the calendar date.
     * @param month the month of the calendar date.
     * @param day the day of the calendar date.
     * @throws IllegalArgumentException if the date is a weekend
     */
    public CustomCalendar(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        this.appointmentsByProvider = new HashMap<>();
        this.cancellationList = new PriorityQueue<>(new AppointmentPriorityComparator());

        if (isWeekend(this.date)) {
            throw new IllegalArgumentException("The office is closed on weekends and appointments cannot be scheduled.");
        }
    }

    /**
     * Checks if the date falls on a weekend.
     * @param date the date to check.
     * @return true if the date is a weekend, false otherwise.
     */
    public boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    /**
     * Checks if the time and duration of the appointment fall outside business hours.
     * @param start the starting time of the appointment.
     * @param duration the length of the appointment in minutes.
     * @return true if the time is within business hours, false otherwise.
     */
    public boolean isWithinBusinessHours(LocalTime start, int duration) {
        LocalTime end = start.plusMinutes(duration);
        LocalTime businessStart = LocalTime.of(8,0);
        LocalTime businessEnd = LocalTime.of(17,0);
        return !start.isBefore(businessStart) && !end.isAfter(businessEnd);
    }

    /**
     * Gets the calendar date.
     * @return the calendar date.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Adds a provider to the calendar, initializing their schedule (appointment list) for the day.
     * @param provider the provider to add to the calendar.
     */
    public void addProvider(Provider provider) {
        appointmentsByProvider.putIfAbsent(provider, new ArrayList<>());
    }

    /**
     * Adds an appointment to the provider's schedule.
     * @param provider the provider that will be seeing the patient.
     * @param appointment the appointment to add.
     * @throws IllegalArgumentException if the appointment overlaps with other existing appointments.
     */
    public void addAppointment(Provider provider, Appointment appointment) {
        if (overlapPresent(provider, appointment.getAppointmentDate(), appointment.getAppointmentTime(), appointment.getAppointmentLength())) {
            throw new IllegalArgumentException("This appointment overlaps with an existing appointment.");
        }

        List<Appointment> providerAppointments = appointmentsByProvider.get(provider);
        if (providerAppointments == null) {
            providerAppointments = new ArrayList<>();
            appointmentsByProvider.put(provider, providerAppointments);
        }
        providerAppointments.add(appointment);
    }

    /**
     * Removes an appointments from a provider's schedule.
     * @param provider the provider whose schedule an appointment is being removed from.
     * @param appointment the appointment to remove.
     * @return true if the appointment was successfully removed, false otherwise.
     */
    public boolean removeAppointment(Provider provider, Appointment appointment) {
        List<Appointment> providerAppointments = appointmentsByProvider.get(provider);
        if (providerAppointments != null) {
            return providerAppointments.remove(appointment);
        }
            return false;
    }

    /**
     * Adds an appointment to the cancellation list, which is prioritized by appointment type.
     * @param appointment the appointment to add to the cancellation list.
     */
    public void addToCancellationList(Appointment appointment) {
        cancellationList.add(appointment);
    }

    /**
     * Checks if an appointment was successfully added to the cancellation list.
     * @param appointment the appointment to check.
     * @return true if the appointment was successfully added to the cancellation list, false otherwise.
     */
    public boolean isAppointmentInCancellationList(Appointment appointment) {
        return cancellationList.contains(appointment);
    }

    /**
     * Retrieves and removes the highest priority appointment from the cancellation list.
     * @return the appointment removed from the cancellation list.
     */
    public Appointment pollFromCancellationList() {
        return cancellationList.poll();
    }

    /**
     * Gets a list of appointments for a specific provider.
     * @param provider the provider whose schedule is to be retrieved.
     * @return the providers schedule (list of appointments for the day).
     */
    public List<Appointment> getProvidersAppointments(Provider provider) {
        return new ArrayList<>(appointmentsByProvider.getOrDefault(provider, Collections.emptyList()));
    }

    /**
     * Checks for overlapping appointments for a specific provider on a given date and time.
     * @param provider the provider whose appointments are checked.
     * @param date the date of the appointment.
     * @param start the start time of the appointment.
     * @param duration the length of the appointment in minutes.
     * @return true if there is an overlap, false otherwise.
     */
    public boolean overlapPresent(Provider provider, LocalDate date, LocalTime start, int duration) {
        List<Appointment> appointments = appointmentsByProvider.get(provider);

        if (appointments == null) {
            return false;
        }

        LocalTime end = start.plusMinutes(duration);
        for (Appointment existingAppointment : appointments) {
            if (!existingAppointment.getAppointmentDate().equals(date)) {
                continue;
            }

            LocalTime existingStart = existingAppointment.getAppointmentTime();
            LocalTime existingEnd = existingStart.plusMinutes(existingAppointment.getAppointmentLength());

            // Check for overlap
            if (start.isBefore(existingEnd) && end.isAfter(existingStart)) {
                return true;            // overlap present
            }
        }
        return false;                   // No overlap
    }

    /**
     * Compares this calendar instance with another object for equality, based on the date.
     * @param o the object to compare with this instance.
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomCalendar)) {
            return false;
        }
        CustomCalendar other = (CustomCalendar) o;
        return Objects.equals(date, other.date);  // Objects.equals is null-safe, meaning it can handle null without throwing NullPointerException
    }

    /**
     * Computes the hash code for this CustomCalendar instance, based on the date.
     * @return the computed hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    /**
     * Provides a string representation of each provider's schedule that includes the date and number of appointments.
     * @return a formatted string of all appointments on this date for each provider.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(date.toString() + " has appointments with:\n");
        appointmentsByProvider.forEach((provider, appointments) -> {
            result.append(provider.toString()).append(" - ").
                    append(appointments.size()).append(" appointments\n");
        });
        return result.toString();
    }
}