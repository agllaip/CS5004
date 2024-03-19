import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AbstractEmployee implements Employee{
    protected String name;
    protected double salary;
    protected Gender gender;

    protected AbstractEmployee(String name,double salary, Gender gender) {
        this.name = name;
        this.salary = salary;
        this. gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }

    // How many employees are in this organization?
    public int count() {
        // The organization rooted here has just this employee. So return 1.
        return 1;
    }

    public int countByGender(Gender g) {
        if (this.getGender() == g) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int countPayAbove(double s) {
        if (this.getSalary() == s) {
            return 1;
        }
        else {
            return 0;
        }
    }


    public int count(Predicate<Employee> test) {
        // If this employee passes the test we need to return 1 (returns true)
        // test (predicate object passed). test(function inside it - also called test)
        if (test.test(this)) {
            return 1;
        }
        // If this employee does not pass the test we need to return 0 (returns false)
        else {
            return 0;
        }
    }

    public List<Employee> allEmployees() {
        // Create an empty list
        List<Employee> list = new ArrayList<Employee>();
        // Add this to the list and return it
        list.add(this);
        return list;
    }


}