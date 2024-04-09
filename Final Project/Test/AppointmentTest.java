package Test;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class AppointmentTest {

    private AppointmentTest appointment;

    @Before
    public void setUp() throws Exception {
        // Create a LocalDate object
        LocalDate appointmentDate = LocalDate.of(2024, 5, 15);

        // Create a LocalTime object
        LocalTime appointmentTime = LocalTime.of(16,15);

        // Create an Appointment object
        appointment = new Appointment(60, appointmentDate, appointmentTime);
    }

    @Test
    public void getAppointmentLength() {
        assertEquals(60, appointment.getAppointmentLength());
    }

    @Test
    public void getAppointmentTime() {
        LocalTime expected = LocalTime.of(16, 15);
        assertEquals(expected, appointment.getAppointmentTime());
    }

    @Test
    public void getAppointmentDate() {
        LocalDate expected = LocalDate.of(2024, 5, 15);
        assertEquals(expected, appointment.getAppointmentDate());
    }

    @Test
    public void setAppointmentDate() {
    }

    @Test
    public void setAppointmentTime() {
    }

    @Test
    public void setAppointmentLength() {
    }
}