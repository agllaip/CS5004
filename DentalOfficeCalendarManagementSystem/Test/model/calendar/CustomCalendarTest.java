package model.calendar;

import model.appointment.Appointment;
import model.appointment.DentistAppointment;
import model.appointment.enums.DentistAppointmentType;
import model.person.Provider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class CustomCalendarTest {

    private CustomCalendar calendar;
    private Provider provider;

    @Before
    public void setUp() {
        calendar = new CustomCalendar(2024, 4, 30);
        provider = new Provider("Olivia", "Johnson", 1234567890, "Dentist");
        calendar.addProvider(provider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsWeekend() {
        new CustomCalendar(2024, 5, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsWithinBusinessHours() {
        Appointment appointment = new DentistAppointment(30, LocalDate.of(2024, 4, 23),
                                                          LocalTime.of(17,30), DentistAppointmentType.EMERGENCY,
                                                         "Dentist");

        calendar.addAppointment(provider, appointment);
        assertTrue("Appointment added successfully", calendar.getProvidersAppointments(provider).contains(appointment));
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.of(2024, 4, 30), calendar.getDate());
    }

    @Test
    public void testAddProvider() {
        assertNotNull("Provider has been added to the calender.", calendar.getProvidersAppointments(provider));
        assertEquals(0, calendar.getProvidersAppointments(provider).size());
    }

    @Test
    public void addAppointment() {
        Appointment appointment = new DentistAppointment(30, LocalDate.of(2024, 4, 30),
                                  LocalTime.of(12,30), DentistAppointmentType.EMERGENCY, "DENTIST");

        calendar.addAppointment(provider, appointment);
        assertTrue("Appointment has been scheduled.", calendar.getProvidersAppointments(provider).contains(appointment));
        assertFalse("Appointment was not scheduled.", calendar.getProvidersAppointments(provider).isEmpty());
    }

    @Test
    public void removeAppointment() {
        Appointment appointment = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(16,30), DentistAppointmentType.EMERGENCY, "DENTIST");

        calendar.addAppointment(provider, appointment);
        calendar.removeAppointment(provider, appointment);
        assertFalse("Appointment has been canceled.", calendar.getProvidersAppointments(provider).contains(appointment));
        assertTrue("Appointment list should be empty after removal.", calendar.getProvidersAppointments(provider).isEmpty());
    }

    @Test
    public void addToCancellationList() {
        Appointment appointment = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(16,30), DentistAppointmentType.EMERGENCY, "DENTIST");

        calendar.addToCancellationList(appointment);
        assertTrue("Appointment was added to cancellation list", calendar.isAppointmentInCancellationList(appointment));
    }

    @Test
    public void pollFromCancellationList() {
        Appointment appointment = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(16,30), DentistAppointmentType.EMERGENCY, "DENTIST");

        calendar.addToCancellationList(appointment);
        Appointment polledAppointment = calendar.pollFromCancellationList();
        assertEquals(appointment, polledAppointment);
    }

    @Test
    public void getProvidersAppointments() {
        Appointment appointment1 = new DentistAppointment(30, LocalDate.of(2024, 4, 30),
                LocalTime.of(8,00), DentistAppointmentType.EMERGENCY, "DENTIST");
        Appointment appointment2 = new DentistAppointment(45, LocalDate.of(2024, 4, 30),
                LocalTime.of(8,30), DentistAppointmentType.CROWN_PLACEMENT, "DENTIST");
        Appointment appointment3 = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(9,15), DentistAppointmentType.CROWN_PREP, "DENTIST");

        calendar.addAppointment(provider, appointment1);
        calendar.addAppointment(provider, appointment2);
        calendar.addAppointment(provider, appointment3);

        calendar.addToCancellationList(appointment1);
        calendar.addToCancellationList(appointment2);
        calendar.addToCancellationList(appointment3);

        List<Appointment> appointments = calendar.getProvidersAppointments(provider);

        assertTrue("Appointment 1 has been scheduled.", appointments.contains(appointment1));
        assertTrue("Appointment 2 has been scheduled.", appointments.contains(appointment2));
        assertTrue("Appointment 3 has been scheduled.", appointments.contains(appointment3));
        assertEquals(3, appointments.size());
    }

    @Test
    public void overlapPresent() {
        Appointment appointment1 = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(8,00), DentistAppointmentType.EMERGENCY, "DENTIST");
        calendar.addToCancellationList(appointment1);

        Appointment appointment2 = new DentistAppointment(45, LocalDate.of(2024, 4, 30),
                LocalTime.of(8,30), DentistAppointmentType.CROWN_PREP, "DENTIST");

        assertTrue("These two appointments overlap.", calendar.overlapPresent(provider, appointment2.getAppointmentDate(),
                   appointment2.getAppointmentTime(), appointment2.getAppointmentLength()));

        try {
            calendar.addAppointment(provider, appointment2);
            fail("IllegalArgumentException is expected due to the appointments overlapping.");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }

        Appointment appointment3 = new DentistAppointment(60, LocalDate.of(2024, 4, 30),
                LocalTime.of(9,45), DentistAppointmentType.EMERGENCY, "DENTIST");

        assertFalse("These two appointments do not overlap.", calendar.overlapPresent(provider, appointment3.getAppointmentDate(),
                appointment3.getAppointmentTime(), appointment3.getAppointmentLength()));
    }

    @Test
    public void testEquals() {
        CustomCalendar sameDay = new CustomCalendar(2024, 4, 30);
        CustomCalendar differentDay = new CustomCalendar(2024, 5, 1);

        assertEquals("Calendars on the same day should be equal.", calendar, sameDay);
        assertNotEquals("Calendars on different days should not be equal.", calendar, differentDay);
    }

    @Test
    public void testHashCode() {
        CustomCalendar sameDay = new CustomCalendar(2024, 4, 30);
        assertEquals("Hash codes should be the same for the same objects.", calendar.hashCode(), sameDay.hashCode());
    }

    @Test
    public void testToString() {
        Appointment appointment1 = new DentistAppointment(60, LocalDate.of(2024,4,30),
                LocalTime.of(8,0), DentistAppointmentType.CROWN_PREP, "DENTIST");
        Appointment appointment2 = new DentistAppointment(45, LocalDate.of(2024,4,30),
                LocalTime.of(9,0), DentistAppointmentType.CROWN_PLACEMENT, "DENTIST");

        calendar.addAppointment(provider, appointment1);
        calendar.addAppointment(provider, appointment2);

        String expected = "On 2024-04-30 " + provider.toString() + " has 2 appointments.";
        assertEquals(expected, calendar.toString());
    }
}