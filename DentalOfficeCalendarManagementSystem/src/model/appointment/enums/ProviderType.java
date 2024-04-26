package model.appointment.enums;

/**
 * Enumerates the types of providers. Each provider is associated with a specific specialty of dentistry.
 */
public enum ProviderType {
    HYGIENIST("Dental Hygiene"),
    DENTIST("General Dentistry"),
    PERIODONTIST("Periodontics");

    private final String specialty;

    /**
     * Constructs a ProviderType enum with the specified specialty.
     * @param specialty the specialty associated with the provider.
     */
    ProviderType(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Gets the specialty associated with this provider. This specialty categorizes the
     * different types of providers based on the types of dental appointments they provide.
     * @return the name of the specialty associated with the provider.
     */
    public String getSpecialty() {
        return this.specialty;
    }

    public static ProviderType getProviderTypeFromDescription(String specialty) {
        for (ProviderType type: ProviderType.values()) {
            if (type.getSpecialty().equalsIgnoreCase(specialty)) {
                return type;
            }
        }
        throw new IllegalArgumentException("There is not matching ProviderType.");
    }
}