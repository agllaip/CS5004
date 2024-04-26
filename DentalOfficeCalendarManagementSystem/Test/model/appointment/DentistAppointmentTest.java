package model.appointment;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.ProviderType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class DentistAppointmentTest {
    private DentistAppointment dentistAppointment1;
    private DentistAppointment dentistAppointment2;


    @Before
    public void setUp() throws Exception {
        dentistAppointment1 = new DentistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                                                     DentistAppointmentType.CROWN_PREP, "DENTIST");

        dentistAppointment2 = new DentistAppointment(45, LocalDate.now(), LocalTime.of(10,0),
                                                      DentistAppointmentType.CROWN_PLACEMENT, "DENTIST");
    }

    @Test
    public void testSetDentistAppointmentType() {
        dentistAppointment1.setDentistAppointmentType(DentistAppointmentType.CROWN_PLACEMENT);
        dentistAppointment2.setDentistAppointmentType(DentistAppointmentType.EMERGENCY);

        assertSame(DentistAppointmentType.CROWN_PLACEMENT, dentistAppointment1.getAppointmentType());
        assertSame(DentistAppointmentType.EMERGENCY, dentistAppointment2.getAppointmentType());
    }

    @Test
    public void getAppointmentType() {
        assertSame(DentistAppointmentType.CROWN_PREP, dentistAppointment1.getAppointmentType());
        assertSame(DentistAppointmentType.CROWN_PLACEMENT, dentistAppointment2.getAppointmentType());
    }
}