public interface Employee {
    String getName();
    Gender getGender();
    double getSalary();

    /**
     * Add the given employee as the supervisee of the employee with the given name.
     * This method has no effect on the hierarchy if the supervisor cannot be found.
     * @param supervisorName the name of the supervisor
     * @param newEmployee the employee that will be supervised by this supervisor
     * @return the resulting hierarchy of this employee
     */
    Employee addSupervisee(String supervisorName, Employee newEmployee);
    List<Employee> allEmployees();

//    int count();
//    int countByGender(Gender g);
//    int countPayAbove(double s);

    /**
     * Count the number of employees in this hierarchy who fulfill the given predicate.
     * @param test
     * @return the number of employees in the hierarchy that fulfill the given predicate.
     */
    int count(Predicate<Employee> test);
}
