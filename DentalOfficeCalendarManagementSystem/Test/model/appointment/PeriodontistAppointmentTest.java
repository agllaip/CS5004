package model.appointment;

import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.PeriodontistAppointmentType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class PeriodontistAppointmentTest {
    private PeriodontistAppointment periodontistAppointment;

    @Before
    public void setUp() throws Exception {
        periodontistAppointment = new PeriodontistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                PeriodontistAppointmentType.DENTAL_IMPLANT, "HYGIENIST");
    }

    @Test
    public void setPeriodontistAppointmentType() {
        periodontistAppointment.setPeriodontistAppointmentType(PeriodontistAppointmentType.SCALING_ROOT_PLANNING);
        assertSame(PeriodontistAppointmentType.SCALING_ROOT_PLANNING, periodontistAppointment.getAppointmentType());
    }

    @Test
    public void getAppointmentType() {
        periodontistAppointment.setPeriodontistAppointmentType(PeriodontistAppointmentType.DENTAL_IMPLANT);
        assertSame(PeriodontistAppointmentType.DENTAL_IMPLANT, periodontistAppointment.getAppointmentType());
    }
}