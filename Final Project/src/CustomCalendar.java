package src;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomCalendar {

    // Added 'final' to ensure immutability (no changes can be made after an instance of CustomCalender is created)
    private final LocalDate date;
    private final List<Appointment> appointmentList;

    public CustomCalendar(int month, int day, int year) {
        this.date = LocalDate.of(year, month, day);

        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("The office is closed on weekends and appointments cannot be scheduled.");
        }
        this.appointmentList = new ArrayList<>();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public List<Appointment> getAppointmentList() {
        return new ArrayList<>(appointmentList);
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null && !isWeekend(appointment.getAppointmentDate())) {
            appointmentList.add(appointment);
        }
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    // For comparison of dates:
    // TO DO: equals()
    // TO DO: compareTo()

    @Override
    public String toString() {
        return date.toString() + "with " + appointmentList.size() + " appointments.";
    }
}