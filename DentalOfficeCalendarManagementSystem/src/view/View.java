package view;

import controller.AppointmentController;
import java.util.Scanner;
import model.appointment.enums.DentistAppointmentType;
import model.appointment.enums.HygienistAppointmentType;
import model.appointment.enums.PeriodontistAppointmentType;
import model.appointment.enums.ProviderType;
import model.appointment.interfaces.IAppointmentType;
import model.person.Provider;
import model.appointment.enums.EnumUtility;

/**
 * The View class is responsible for interacting with the user, handling all inputs and outputs.
 */
public class View {
    private AppointmentController controller;
    private Scanner scanner;

    /**
     * Constructs a View object that manages user interactions for the appointment system. The View
     * initializes the controller and sets up scanner for input handling.
     * @param controller the controller that handles the logic of the appointment operations.
     */
    public View(AppointmentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts main loop of the application, continually displaying the menu to the user and processing
     * their inputs and preforming actions until the user quits.
     */
    public void begin() {
        String input = "";
        while (true) {
            System.out.print("Welcome to Dental Manager!\n");
            System.out.print("Please choose an option listed below:\n");
            displayMenu();
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                System.out.println("Goodbye.");
                break;
            }
            processInput(input);
        }
    }

    /**
     * Displays main menu options to the user.
     */
    private void displayMenu() {
        System.out.print("A - Add Appointment\n");
        System.out.print("R - Remove Appointment\n");
        System.out.print("Q - Quit\n");
    }

    /**
     * Process user input from the main menu. Currently only adding an appointment is possible.
     * @param input the user's input that determines what action will be performed.
     */
    private void processInput(String input) {
        switch (input) {
            case "A":
                addAppointment();
                break;
            case "R":
                removeAppointment();
                break;
            case "Q":
                System.out.print("Goodbye.");
                break;
            default:
                System.out.print("Invalid option, please try again.");
        }
    }

    /**
     * Determines the type of appointment based on provider type and user input.
     * @param providerType the type of provider the patient will be seeing.
     * @param appointmentTypeInput user input string that needs to be converted into an enum constant.
     * @return the specific appointment type after the conversion.
     */
    private IAppointmentType getAppointmentTypeByProvider(ProviderType providerType, String appointmentTypeInput) {
        try {
            switch (providerType) {
                case DENTIST:
                    return EnumUtility.fromString(DentistAppointmentType.class, appointmentTypeInput);
                case HYGIENIST:
                    return EnumUtility.fromString(HygienistAppointmentType.class, appointmentTypeInput);
                case PERIODONTIST:
                    return EnumUtility.fromString(PeriodontistAppointmentType.class, appointmentTypeInput);
                default:
                    throw new IllegalArgumentException("Unknown provider type: " + providerType);
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid appointment type. " + e.getMessage());
        return null;
        }
    }

    /**
     * Handles the addition of a new appointment, prompting the user for various appointment specific information.
     * Based on the information it makes an appointment through the controller.
     */
    private void addAppointment() {
        System.out.print("Please enter date of appointment (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Please enter time of appointment (HH:MM): ");
        String appointmentTime = scanner.nextLine();
        System.out.print("Please enter the appointment's length in minutes: ");
        int appointmentLength = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter patient's full name: ");
        String patientFullName = scanner.nextLine();
        System.out.print("Please enter provider's full name: ");
        String providerFullName = scanner.nextLine();
        System.out.print("Please enter the type of provider: ");
        String providerTypeInput = scanner.nextLine();
        ProviderType providerType = ProviderType.getProviderTypeFromDescription(providerTypeInput);
        System.out.print("Please enter appointment type: ");
        String appointmentTypeInput = scanner.nextLine();

        IAppointmentType appointmentType = getAppointmentTypeByProvider(providerType, appointmentTypeInput);
        if (appointmentType == null) {
            return;
        }

        Provider provider = new Provider("Olivia", "Johnson", 1234567890,
                                         providerType.getSpecialty());

        try {
            controller.createAppointment(provider, appointmentDate, appointmentTime, appointmentLength, patientFullName,
                                     providerFullName, appointmentType.getAppointmentName());
            System.out.println("Appointment was successfully created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating appointment. " + e.getMessage());
        }
    }

    /**
     * Currently a placeholder for removing an appointment, no functionality has been implemented yet.
     */
    private void removeAppointment() {
        System.out.println("Functionality to remove an appointment not yet implemented, will be implemented at a later date." +
                           "Please add an appointment instead.");
    }
}