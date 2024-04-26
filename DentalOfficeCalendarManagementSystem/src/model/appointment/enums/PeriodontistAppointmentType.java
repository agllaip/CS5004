package model.appointment.enums;

import model.appointment.interfaces.IAppointmentType;

/**
 * Enumerates the type and priority of the periodontal appointments conducted by provider.
 */
public enum PeriodontistAppointmentType implements IAppointmentType {
    EXTRACTION,
    SCALING_ROOT_PLANNING,
    DENTAL_IMPLANT;

    /**
     * Gets the name of this appointment type.
     * @return name of this appointment type.
     */
    @Override
    public String getAppointmentName() {
        return this.name();
    }
}