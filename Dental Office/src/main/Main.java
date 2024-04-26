package main;

import controller.AppointmentController;
import model.calendar.CustomCalendar;
import service.AppointmentManager;
import view.View;

/**
 * The Main class represents is the entry point for the application. It initializes the
 * components and starts the user interface.
 */
public class Main {

    /**
     * The start of the application. Initiates the interaction with the user through the View.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        CustomCalendar calendar = new CustomCalendar(2024, 4, 30);
        AppointmentManager manager = new AppointmentManager(calendar);
        AppointmentController controller = new AppointmentController(manager);
        View view = new View(controller);

        view.begin();
    }
}
