package model.appointment;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.HygienistAppointmentType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class HygienistAppointmentTest {
    private HygienistAppointment hygienistAppointment1;
    private HygienistAppointment hygienistAppointment2;


    @Before
    public void setUp() throws Exception {
        hygienistAppointment1 = new HygienistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                HygienistAppointmentType.ADULT_CLEANING, "HYGIENIST");

        hygienistAppointment2 = new HygienistAppointment(30, LocalDate.now(), LocalTime.of(10,0),
                HygienistAppointmentType.CHILD_CLEANING, "HYGIENIST");
    }

    @Test
    public void testSetHygienistAppointmentType() {
        hygienistAppointment1.setHygienistAppointmentType(HygienistAppointmentType.SCALING_ROOT_PLANNING);
        hygienistAppointment2.setHygienistAppointmentType(HygienistAppointmentType.ADULT_CLEANING);

        assertSame(HygienistAppointmentType.SCALING_ROOT_PLANNING, hygienistAppointment1.getAppointmentType());
        assertSame(HygienistAppointmentType.ADULT_CLEANING, hygienistAppointment2.getAppointmentType());
    }

    @Test
    public void testGetAppointmentType() {
        hygienistAppointment1.setHygienistAppointmentType(HygienistAppointmentType.ADULT_CLEANING);
        hygienistAppointment2.setHygienistAppointmentType(HygienistAppointmentType.CHILD_CLEANING);

        assertSame(HygienistAppointmentType.ADULT_CLEANING, hygienistAppointment1.getAppointmentType());
        assertSame(HygienistAppointmentType.CHILD_CLEANING, hygienistAppointment2.getAppointmentType());
    }
}