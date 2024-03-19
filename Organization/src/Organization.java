/**
 * This interface represents and organization. It includes methods that an organization is expected to offer.
 */
public interface Organization {

    /**
     * Add an employee to this organization with the given specifics and supervisor.
     * This employee will not be added to the organization if the supervisor cannot be found.
     * @param name name of the employee to be added
     * @param salary the annual salary of this employee
     * @param gender the gender of this employee
     * @param supervisorName the supervisor of this employee. The supervisor should be an existing employee.
     */
    void addEmployee(String name, double salary, Gender gender, String supervisorName);
    // Gender is an enum

    /**
     * Add a contract employee to this organization with the given specifics and supervisor.
     * This employee will not be added to the organization if the supervisor cannot be found.
     * @param name name of the contract employee to be added
     * @param salary the annual salary of this contract employee
     * @param gender the gender of this employee
     * @param endYear the year in which this employee's contract ends
     * @param endMonth the month in which this employee's contract ends
     * @param endDate the date in which this employee's contract ends
     * @param supervisorName the supervisor of this contract employee. The supervisor should be an existing employee.
     */
    void addContractEmployee(String name, double salary, Gender gender, int endYear, int endMonth, int endDate, String supervisorName);

    /**
     * Get the size of this organization, i.e. the total number of employees in this organization.
     * @return the number of employees in this organization
     */
    int getSize();

    /**
     * Get the number of employees of a specified gender in this organization.
     * @param gender the specific gender that must be counted
     * @return the number of employees of that specified gender in this organization
     */
    int getSizeByGender(Gender gender);

    /**
     * Get a list of names if all the employees in this organization.
     * @return a list of names of all employees as a list of {@link String}
     */
    List<String> allEmployees();

    /**
     * Return the number of employees whose annual salary is above the specified amount.
     * @param amount the lower threshold of the annual salary
     * @return the number of employees whose annual salary is above the specified amount
     */
    int countPayAbove(double amount);

    /**
     * Return the number of emplooyees who are scheduled to be terminated before a specific date.
     * @param year the year of termination
     * @param month the month of termination
     * @param date the date of termination
     * @return the number of employees who are scheduled before this specific date
     */
    int terminatedBefore(int year, int month, int date);
}
