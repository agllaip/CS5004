package organization;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import util.Gender;
import util.Organization;

/**
 * This class represents an organization with Employees.
 */
public class OrganizationImpl implements Organization {
    private Employee root;

    public OrganizationImpl(String nameCEO, double salary, Gender gender) {
        root = new InternalEmployee(nameCEO, salary, gender);
    }

    /**
     *
     * @param name
     * @param salary
     * @param gender
     * @param supervisorName
     */
    @Override
    public void addEmployee(String name, double salary, Gender gender, String supervisorName) {
        Employee newEmployee = new NonManagerEmployee(name, salary, gender);
        root = root.addSupervisee(supervisorName, newEmployee);
    }

    /**
     *
     * @param name
     * @param salary
     * @param gender
     * @param endDate
     * @param endMonth
     * @param endYear
     * @param supervisorName
     */
    @Override
    public void addContractEmployee(String name, double salary, Gender gender, int endDate,
                                    int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name, salary, gender, endDate, endMonth, endYear);
        root = root.addSupervisee(supervisorName, newEmployee);
    }

    /**
     *
     * @return
     */
    @Override
    public int getSize() {
        // return this.root.count();
        // Given an employee 'e' I want a predicate to always return true
        return this.root.count(e -> true);
        // Convert from a tree node of employees to a tree node of integers using map
        // Reduce - first value is default value (we start counting at 0), then the bifunction that takes 2 numbers and adds them
        // return this.root.map(e -> new Integer(1)).reduce(0, (a, b) -> a + b);
    }

    /**
     *
     * @param g
     * @return
     */
    @Override
    public int getSizeByGender(Gender g) {
        // Predicate that passes an employee and returns true only if the employees gender matches that g
        return this.root.count(e -> g == e.getGender());
//        this.root.map(e -> {
//            if (e.getGender() == g) {
//                return new Integer(1);
//            } else {
//                return new Integer(0);
//            }
//        }).reduce(0, (a, b) -> a + b);
    }

    /**
     *
     * @param amount
     * @return
     */
    @Override
    public int getCountPayAbove(double amount) {
        return this.root.count(e -> e.getSalary() > amount);
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> allEmployees() {
//        List<Employee> allEmployees = this.root.allEmployees();
//
//        // map List<Employee> to List<String> by doing Employee to name of employee
//        return allEmployees.stream()
//                .map(e -> e.getName())
//                .collect(Collectors.toList());
        // return this.root.map(e -> e.getName()).toList();
        return root.toList().stream().map(e -> e.getName()).collect(Collectors.toList());
    }

    /**
     *
     * @param date
     * @param month
     * @param year
     * @return
     */
    @Override
    public int terminatedBefore(int date, int month, int year) {
        LocalDate threshold;

        try {
            threshold = LocalDate.of(year, month, date);
        }
        catch (DateTimeException e)  {
            return 0;
        }
        return root.count(e ->{
            if (e.getEmployeeEndDate().equals("XXXXXXXX"))
                return false;
            else {
                LocalDate d = LocalDate.parse(e.getEmployeeEndDate(), DateTimeFormatter.ofPattern("MMddyyyy"));
                return e.compareTo(threshold) < 0;
            }
        });
    }
}