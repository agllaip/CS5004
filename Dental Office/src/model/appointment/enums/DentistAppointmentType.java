package model.appointment.enums;

import model.appointment.interfaces.IAppointmentType;

/**
 * Enumerates the type and priority of the general dentistry appointments conducted by provider.
 */
public enum DentistAppointmentType implements IAppointmentType {
    EMERGENCY,
    CROWN_PREP,
    CROWN_PLACEMENT;

    /**
     * Gets the name of this appointment type.
     * @return name of this appointment type.
     */
    @Override
    public String getAppointmentName() {
        return this.name();
    }
}