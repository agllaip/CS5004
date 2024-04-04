/** This class represents a person. A person has the following attributes:
 first name, last name.
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a Person object and initializes it to the given first and last name.
     * @param firstName the first name of this person.
     * @param lastName the last name of this person.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the first name of this person.
     * @return the first name of this person.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get the last name of this person.
     * @return the last name of this person.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get the full name of this person.
     * @return the full name of this person.
     */
    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    /**
     * Returns a string representation of this person with their first and last name.
     * @return a formatted string.
     */
    public String toString() {
        return firstName + ' ' + lastName;
    }

    // Do I need a boolean method?
}