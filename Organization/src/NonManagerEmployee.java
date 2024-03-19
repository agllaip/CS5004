// Declaring a new class named NonManagerEmployee that extends (inherits from) AbstractEmployee
// NonManagerEmployee inherits all the properties and behaviors defined in AbstractEmployee
public class NonManagerEmployee extends AbstractEmployee{

    // Declare constructor for the NonManagerEmployee which takes 3 parameters
    // When a NonManagerEmployee is created this constructor is used to initialize its state
    public NonManagerEmployee(String name, double salary, Gender gender) {
        // 'super' keyword is used to call the constructor of the superclass AbstractEmployee
        // This initializes the name, salary, and gender attributes of the NonManagerEmployee ...
        // object using the constructor of AbstractEmployee
        super(name, salary, gender);
    }

    @Override
    public Employee addSupervisee(String supervisorName, Employee newEmployee) {
        // This condition checks if the name of the current employee (this) matches the supervisorName ...
        // if they match that means this employee should be promoted to a supervisor and given the ...
        // responsibility of supervising newEmployee
        if (this.getName().equals(supervisorName)) {
            // this employee must be promoted to a supervisor
            // A new instance of Supervisor is created
            // This Supervisor object is initialized with the same name, salary, and gender as the current ...
            // employee (this). This creates a new supervisor with the same attributes as the employee being promoted
            Supervisor newSelf = new Supervisor(this.getName(), this.getSalary(), this.getGender());
            // addSupervisee method is called recursively on the newly created supervisor 'm' to add ...
            // newEmployee under this supervisor
            newSelf = newSelf.addSupervisee(supervisorName, newEmployee);
            // Reference to the modified supervisor is returned
            return newSelf;
        }
        // If the name of the current employee does not match the supervisorName it means this employee is not ...
        // the supervisor being searched for
        else {
            // this is the end of the road in this part of the organization
            // Return the reference to the current employee (this). This indicates the search for the supervisor ...
            // should continue down the hierarchy.
            return this;
        }
    }
}
