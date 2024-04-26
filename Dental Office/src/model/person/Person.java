package model.person;

/**
 * This class represents a person with a  first name and last name. It provides the foundational
 * attributes and methods for managing a persons basic identity.
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a new Person object and initializes it with the given first and last name.
     * @param firstName the first name of this person.
     * @param lastName the last name of this person.
     * @throws IllegalArgumentException first and/or last name are null.
     */
    public Person(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First and last name cannot be null.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Sets the first name of this person.
     * @param firstName the first name of this person.
     * @throws IllegalArgumentException if the first name is null.
     */
    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null.");
        }
        this.firstName = firstName;
    }

    /**
     * Sets the last name of this person.
     * @param lastName the last name of this person.
     * @throws IllegalArgumentException if the last name is null.
     */
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null.");
        }

        this.lastName = lastName;
    }

    /**
     * Gets the first name of this person.
     * @return the first name of this person.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of this person.
     * @return the last name of this person.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the full name of this person.
     * @return the full name of this person (firstName lastName).
     */
    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    /**
     * Returns a string representation of this person with their first and last name.
     * @return a formatted string of this person's full name.
     */
    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}