package Test;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class DentistAppointmentTest {

    private DentistAppointmentTest appointment;

    @Before
    public void setUp() throws Exception {
        appointment = new DentistAppointmentTest(60, 20240515, 14);
    }

    @Test
    public void getAppointmentLength() {
        assertEquals(60, appointment.getAppointmentLength());
    }

    @Test
    public void getAppointmentTime() {
        assertEquals(LocalTime.of(14, 0), appointment.getAppointmentTime());
    }

    @Test
    public void getAppointmentDate() {
        assertEquals(LocalDate.of(2024, 5, 15), appointment.getAppointmentDate());
    }

    @Test
    public void setAppointmentDate() {
        appointment.setAppointmentDate(LocalDate.of(2024, 4, 30));
        assertEquals(LocalDate.of(2024, 4, 30), appointment.getAppointmentDate());
    }

    @Test
    public void setAppointmentTime() {
        appointment.setAppointmentTime(LocalTime.of(11, 30));
        assertEquals(LocalTime.of(11, 30), appointment.getAppointmentTime());
    }
}