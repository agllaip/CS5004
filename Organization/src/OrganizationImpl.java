import java.util.List;
import java.util.stream.Collectors;

public class OrganizationImpl {


    public void addEmployee(String name, double salary, Gender gender, String supervisorName) {
        Employee newEmployee = new NonManagerEmployee(name, salary, gender);
        root = root.addSupervisee(supervisorName, newEmployee);
    }


    public void addContractEmployee(String name, double salary, Gender gender, int endDate,
                                    int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name, salary, gender, endDate, endMonth, endYear);
        root = root.addSupervisee(supervisorName, newEmployee);
    }

    public int getSize() {
        // return this.root.count();
        // Given an employee 'e' I want a predicate to always return true
        return this.root.count(e -> true);
    }

    public int getSizeByGender(Gender g) {
        // Predicate that passes an employee and returns true only if the employees gender matches that g
        return this.root.count(e -> g == e.getGender());
    }

    public int getCountPayAbove(double s) {
        return this.root.count(e -> s == e.getSalary());
    }

    public List<String> allEmployees() {
        List<Employee> allEmployees = this.root.allEmployees();

        // map List<Employee> to List<String> by doing Employee to name of employee
        return allEmployees.stream()
                           .map(e -> e.getName())
                           .collect(Collectors.toList());
    }

}
