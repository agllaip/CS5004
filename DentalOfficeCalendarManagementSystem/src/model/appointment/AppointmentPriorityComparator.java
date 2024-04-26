package model.appointment;

import model.appointment.enums.DentistAppointmentType;

import java.util.Comparator;

/**
 * A comparator for comparing two objects based on the priority of their appointment type.
 * This comparison is used to sort appointments based on priority in the cancellation list,
 * priority is defied in order in the enums associated with each dental specialty.
 */
public class AppointmentPriorityComparator implements Comparator<Appointment> {

    /**
     * Compares two appointments based on their priority of their appointment types.
     * @param appointment1 the first object to be compared.
     * @param appointment2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer if the first argument is
     * less than, equal to, or greater than the second argument.
     */
    @Override
    public int compare(Appointment appointment1, Appointment appointment2) {
        DentistAppointmentType type1 = (DentistAppointmentType) appointment1.getAppointmentType();
        DentistAppointmentType type2 = (DentistAppointmentType) appointment2.getAppointmentType();

        return type1.compareTo(type2);
    }
}