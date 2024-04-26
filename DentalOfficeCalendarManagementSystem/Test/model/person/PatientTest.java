package model.person;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.interfaces.IAppointmentType;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class PatientTest {
    private Patient patient;

    @Before
    public void setUp() {
        patient = new Patient("Agllai", "Papaj", LocalDate.of(1994,12,26),
                123456, "508-123-4567", "papaj.ag@northeastern.edu", DentistAppointmentType.EMERGENCY);
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals(LocalDate.of(1994, 12, 26), patient.getDateOfBirth());
    }

    @Test
    public void testGetAge() {
        assertEquals(29, patient.getAge());
    }

    @Test
    public void testGetPatientID() {
        assertEquals(123456, patient.getPatientID());
    }

    @Test
    public void testSetAndGetPhoneNumber() {
        String newPhoneNumber = "508-123-4567";
        patient.setPhoneNumber(newPhoneNumber);

        assertEquals(newPhoneNumber, patient.getPhoneNumber());
    }

    @Test
    public void testSetAndGetEmail() {
        String newEmail = "papaj.ag@northeastern.edu";
        patient.setEmail(newEmail);

        assertEquals(newEmail, patient.getEmail());
    }

    @Test
    public void testSetAndGetAppointmentType() {
        IAppointmentType newAppointmentType = DentistAppointmentType.EMERGENCY;
        patient.setAppointmentType(newAppointmentType);

        assertEquals(newAppointmentType, patient.getAppointmentType());
    }

    @Test
    public void testTestToString() {
        String expected = "Patient Name: Agllai Papaj\n" +
                          "ID: 123456\n" +
                          "Date of Birth: 1994-12-26\n" +
                          "Phone Number: 508-123-4567\n" +
                          "Email: papaj.ag@northeastern.edu\n" +
                          "Appointment Type: EMERGENCY";

        assertEquals(expected, patient.toString());
    }
}