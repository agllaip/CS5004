package organization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import util.Gender;

/**
 * This class represents the data and operations of an employee. It defines all the operations
 * that either ought to be common to all implementations, or have a reasonable default to be
 * overridden by them.
 */
public class AbstractEmployee implements Employee{
    protected String name;
    protected double salary;
    protected Gender gender;

    public AbstractEmployee(String name,double salary, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    // How many employees are in this organization?
    // countByGender
    // countPayAbove
    @Override
    public int count(Predicate<Employee> condition) {
        // If this employee passes the test we need to return 1 (returns true)
        // test (predicate object passed). test(function inside it - also called test)
        if (condition.test(this)) {
            return 1;
        }
        // If this employee does not pass the test we need to return 0 (returns false)
        else {
            return 0;
        }
    }

//    public int countByGender(Gender g) {
//        if (this.getGender() == g) {
//            return 1;
//        }
//        else {
//            return 0;
//        }
//    }
//
//    public int countPayAbove(double s) {
//        if (this.getSalary() == s) {
//            return 1;
//        }
//        else {
//            return 0;
//        }
//    }

    @Override
    public List<Employee> allEmployees() {
        // Create an empty list
        List<Employee> result = new ArrayList<Employee>();
        // Add this to the list and return it
        result.add(this);
        return result;
    }
}