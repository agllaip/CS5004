import java.util.function.Predicate;

// New class named Supervisor
// Supervisor extends (inherits from) AbstractEmployee
public class Supervisor extends AbstractEmployee{

    // Declares a private instance variable (supervisees) of type List<Employee>
    // This will hold the employees supervised by this supervisor
    private List<Employee> supervisees;

    // Declaring constructor for Supervisor that takes 3 parameters
    public Supervisor(String name, double salary, Gender gender) {
        // Calling AbstractEmployee constructor with the 3 parameters
        super(name, salary, gender);
        // Initializing the supervisees list as an empty ArrayList
        this.supervisees = new ArrayList<Employee>();
    }

    // Declaring method called addSupervisee that takes 2 parameters
    // Returns an Employee object
    @Override
    public Employee addSupervisee(String supervisorName, Employee newEmployee) {
        // Case 1: this is the supervisor we are looking for
        // Checking if the name of the current supervisor object (this.getName()) is equal to supervisorName ...
        // if equal this is the supervisor we are looking for
        if(this.getName().equals(supervisorName)) {
            // If supervisors name match then add employee to the list of supervisees
            this.supervisees.add(newEmployee);
            return this;
        }
        else {
            // Case 2: recurse down each supervisee to see if this employee can be added
            // If the supervisors name doesn't match ... we need to search further down the hierarchy
            // Starts loop that iterates over each element in the supervisees list
            for (int i = 0; i < this.supervisees.size(); i++) {
                // This line recursively traverses down the hierarchy of supervisors, updating the ...
                // supervisees list with any changes made to the hierarchy during the recursive traversal
                this.supervisees.set(i, this.supervisees.get(i).addSupervisee(supervisorName, newEmployee));
            }
            return this;
        }
    }

    @Override
    public int count () {
        int numEmployees;
        // The number of employees in this organization is 1 (for this employee) plus the number of employees ...
        // in the organization rooted in the first supervisee, plus the number of employees in the organization ...
        // rooted in the second supervisee, and so on..

        // 1 for this employee (get from the count method in AbstractEmployee)
        numEmployees = super.count();

        // Now we need to go through every supervisee and collect the number of people
        // foreach loop (it iterates over each element in the collection this.supervisees)
        // Employee e (this ppart declares a new variable e of type Employee)
        // this.supervisees (indicates the ccollection over which we are iterating, the list 'this.supervisees')
        for (Employee e: this.supervisees) {
            numEmployees += e.count();
        }

        return numEmployees;
    }

    public int countByGender(Gender g) {
        int numEmployees;
        numEmployees = super.countByGender(g);
        for (Employee e: this.supervisees) {
            numEmployees += e.countByGender(g);
        }
        return numEmployees;
    }

    public int countPayAbove(double s) {
        int numEmployees;
        numEmployees = super.countPayAbove(s);
        for (Employee e: this.supervisees) {
            numEmployees += e.countPayAbove(s);
        }
        return numEmployees;
    }

    @Override
    public int count(Predicate<Employee> test) {
        int numEmployees;
        numEmployees = super.count(test);
        for (Employee e: this.supervisees) {
            numEmployees += e.count(test);
        }
        return numEmployees;
    }

    // Create a list
    public List<Employee> allEmployees() {
        // Create a list and add myself
        List<Employee> list = super.allEmployees();

        // Go through all employees that are my supervisees
        for (Employee e: this.supervisees) {
            // Get one by one the list of all employees in their hierarchy and append to existing list
            list.addAll(e.allEmployees());
        }
        // List of employee objects
        // We want this to be a list of strings so we convert with map function
        return list;
    }


}