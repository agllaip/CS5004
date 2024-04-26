package model.appointment;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.ProviderType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class DentistAppointmentTest {
    private DentistAppointment dentistAppointment;

    @Before
    public void setUp() throws Exception {
        dentistAppointment = new DentistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                                                     DentistAppointmentType.CROWN_PREP, "DENTIST");
    }

    @Test
    public void testSetDentistAppointmentType() {
        dentistAppointment.setDentistAppointmentType(DentistAppointmentType.CROWN_PLACEMENT);
        assertSame(DentistAppointmentType.CROWN_PLACEMENT, dentistAppointment.getAppointmentType());
    }

    @Test
    public void getAppointmentType() {
        assertSame(DentistAppointmentType.CROWN_PREP, dentistAppointment.getAppointmentType());
    }
}