import java.util.Objects;

/**
 * This class represents a Person. A person has a first name, last name and a
 * year of birth. This class is needed for authors of publications, for example.
 */
public class Person {
  private String firstName;
  private String lastName;
  private final int yearOfBirth;

  /**
   * Constructs a Person object and initializes it given first name,
   * last name and year of birth
   * <p>
   * @param firstName the first name of this person, a String
   * @param lastName the last name of this person, a String
   * @param yearOfBirth the year of birth of this person, an int
   */
  public Person(String firstName, String lastName, int yearOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.yearOfBirth = yearOfBirth;
  }

  /**
   * Gets the first name of this person
   *
   * @return String, the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  // FlawFound: (Missing Javadocs for getLastName method.)
  // FlawFixToDo: (Add Javadocs in correct format with a sentence explaining
  // what it does and param and or return statements if needed.)
  // FlawFixed: (Added the Javadocs for getLastName above the method.)

  /**
   * Gets the last name of this person.
   *
   * @return String, the last name of this person.
   */

  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the year of birth of this person
   *
   * @return int, representing the year of birth of this person
   */
  public int getYearOfBirth() {
    return this.yearOfBirth;
  }
  
  /**
   Returns a string representation of the person with their first and last name

   @return a formatted string, representing the person's full name
   */
  @Override
  public String toString() {
    return firstName  + " " + lastName;
  }
  
  /**
   * Check if this person equals the person in the argument.
   * <p>
   * @param other The other person to be compared to
   * @return boolean, true iff this person is same as other
   * Two persons are equal iff they have the same first and last names
   * and the same year of birth.
   */
  @Override
  public boolean equals(Object other) {
    // Check if identical
    if (this == other)
      return true;
    // Check if null
    if (other == null)
      return false;
    // Check type compatibility
    if (!(other instanceof Person))
      return false;
    // Cast to Person type
    Person person = (Person) other;
    // Compare relevant fields
    return this.firstName.equals(person.firstName)
        && this.lastName.equals(person.lastName)
        && this.yearOfBirth == person.yearOfBirth;
  }

  /**
   * Ensure that equals method honors the contract with hashCode
   * <p>
   * Uses the same fields for hashing that are used for equality
   * @return int, the integer that this Person should hash to
   */

  // FlawFound: (Missing yearOfBirth field in hashCode method. In the equals method above
  // we override equals for class Person to be based on equal firstName, equal lastName, and
  // equal yearOfBirth we need to make sure the hashCode method mirrors that.)
  // FlawFixToDo: (Add the yearOfBirth field with firstName and lastName fields.)
  // FlawFixed: (Added yearOfBirth in with the other fields, "Objects.hash(firstName, lastName, yearOfBirth)".)

  @Override
  public int hashCode() {
     return Objects.hash(firstName, lastName, yearOfBirth);
  }
}
