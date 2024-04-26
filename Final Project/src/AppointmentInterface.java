package src;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentInterface {

    LocalDate getAppointmentDate();
    void setAppointmentDate(LocalDate date);
    LocalTime getAppointmentTime();
    void setAppointmentTime(LocalTime time);
    void reschedule(LocalDate newDate, LocalTime newTime);

    // Add more

}
