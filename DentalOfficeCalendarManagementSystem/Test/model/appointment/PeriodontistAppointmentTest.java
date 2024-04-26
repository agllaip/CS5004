package model.appointment;

import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.PeriodontistAppointmentType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class PeriodontistAppointmentTest {
    private PeriodontistAppointment periodontistAppointment1;
    private PeriodontistAppointment periodontistAppointment2;


    @Before
    public void setUp() throws Exception {
        periodontistAppointment1 = new PeriodontistAppointment(60, LocalDate.now(), LocalTime.of(10,0),
                PeriodontistAppointmentType.DENTAL_IMPLANT, "PERIODONTIST");


        periodontistAppointment2 = new PeriodontistAppointment(75, LocalDate.now(), LocalTime.of(10,0),
                PeriodontistAppointmentType.EXTRACTION, "PERIODONTIST");
    }

    @Test
    public void setPeriodontistAppointmentType() {
        periodontistAppointment1.setPeriodontistAppointmentType(PeriodontistAppointmentType.SCALING_ROOT_PLANNING);
        periodontistAppointment2.setPeriodontistAppointmentType(PeriodontistAppointmentType.DENTAL_IMPLANT);

        assertSame(PeriodontistAppointmentType.SCALING_ROOT_PLANNING, periodontistAppointment1.getAppointmentType());
        assertSame(PeriodontistAppointmentType.DENTAL_IMPLANT, periodontistAppointment2.getAppointmentType());
    }

    @Test
    public void getAppointmentType() {
        periodontistAppointment1.setPeriodontistAppointmentType(PeriodontistAppointmentType.DENTAL_IMPLANT);
        periodontistAppointment2.setPeriodontistAppointmentType(PeriodontistAppointmentType.EXTRACTION);

        assertSame(PeriodontistAppointmentType.DENTAL_IMPLANT, periodontistAppointment1.getAppointmentType());
        assertSame(PeriodontistAppointmentType.EXTRACTION, periodontistAppointment2.getAppointmentType());
    }
}