package controller;

import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.EnumUtility;
import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.PeriodontistAppointmentType;
import model.appointment.interfaces.IAppointmentType;
import service.AppointmentManager;
import model.person.Provider;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The AppointmentController class is responsible for handling the creation of different types of appointments
 * based on provider specialty. It uses the AppointmentManager to obtain the appointment details.
 */
public class AppointmentController {
    private AppointmentManager manager;

    /**
     * Constructs an AppointmentController with a specified AppointmentManager.
     * @param manager the appointment manager used to manage appointment related operations.
     */
    public AppointmentController(AppointmentManager manager) {
        this.manager = manager;
    }

    /**
     * Creates an appointment based on provider parameters. The appointment type is determined based on the
     * provider's specialty.
     * @param provider the provider conducting the appointment.
     * @param appointmentDate the date of the appointment.
     * @param appointmentTime the time of the appointment.
     * @param appointmentLength the length of the appointment.
     * @param patientFullName the patient's full name.
     * @param providerFullName the provider's full name.
     * @param appointmentTypeInput the input string specifying the type of appointment.
     * @throws IllegalArgumentException if the provider specialty is unknown or if the appointment type is invalid.
     */
    public void createAppointment(Provider provider, String appointmentDate, String appointmentTime,
                                  int appointmentLength, String patientFullName, String providerFullName,
                                  String appointmentTypeInput) {

        LocalDate date = LocalDate.parse(appointmentDate);
        LocalTime time = LocalTime.parse(appointmentTime);


        IAppointmentType appointmentType;
        try {
            switch (provider.getSpecialty()) {
                case "Dental Hygiene":
                    appointmentType = EnumUtility.fromString(HygienistAppointmentType.class, appointmentTypeInput);
                    break;
                case "General Dentistry":
                    appointmentType = EnumUtility.fromString(DentistAppointmentType.class, appointmentTypeInput);
                    break;
                case "Periodontics":
                    appointmentType = EnumUtility.fromString(PeriodontistAppointmentType.class, appointmentTypeInput);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown provider specialty: " + provider.getSpecialty());
            }

            manager.createAppointment(provider, date, time, appointmentLength, patientFullName, providerFullName,
                                      appointmentType.getAppointmentName());

        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create appointment: " + e.getMessage());
        }
    }
}