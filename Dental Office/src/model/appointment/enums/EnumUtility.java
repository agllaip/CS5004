package model.appointment.enums;

/**
 * The EnumUtility class provides a method for working with enum types. It handles the conversion
 * of a string representation of an enum to the enum constant.
 */
public class EnumUtility {

    /**
     * Gets the enum constant from its string representation provided by the user.
     * @param enumType the object of the enum type where we need to get the constant from.
     * @param name the name of the enum constant to get.
     * @return the enum constant that matches the given string.
     * @param <T> the type of enum.
     */
    public static <T extends Enum<T>> T fromString(Class<T> enumType, String name) {
        for (T enumConstant : enumType.getEnumConstants()) {
            if (enumConstant.name().equalsIgnoreCase(name)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Invalid entry.");
    }
}