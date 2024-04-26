package model.appointment;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.HygienistAppointmentType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class HygienistAppointmentTest {
    private HygienistAppointment hygienistAppointment;

    @Before
    public void setUp() throws Exception {
        hygienistAppointment = new HygienistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                HygienistAppointmentType.ADULT_CLEANING, "HYGIENIST");
    }

    @Test
    public void testSetHygienistAppointmentType() {
        hygienistAppointment.setHygienistAppointmentType(HygienistAppointmentType.SCALING_ROOT_PLANNING);
        assertSame(HygienistAppointmentType.SCALING_ROOT_PLANNING, hygienistAppointment.getAppointmentType());
    }

    @Test
    public void testGetAppointmentType() {
        hygienistAppointment.setHygienistAppointmentType(HygienistAppointmentType.ADULT_CLEANING);
        assertSame(HygienistAppointmentType.ADULT_CLEANING, hygienistAppointment.getAppointmentType());
    }
}