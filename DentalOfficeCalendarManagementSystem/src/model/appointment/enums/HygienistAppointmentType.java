package model.appointment.enums;

import model.appointment.interfaces.IAppointmentType;

/**
 * Enumerates the type and priority of the hygiene appointments conducted by provider.
 */
public enum HygienistAppointmentType implements IAppointmentType {
    SCALING_ROOT_PLANNING,
    ADULT_CLEANING,
    CHILD_CLEANING;

    /**
     * Gets the name of this appointment type.
     * @return name of this appointment type.
     */
    @Override
    public String getAppointmentName() {
        return this.name();
    }
}