import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {

        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }

    public double getAverageSalary() {
        double salary = 0;
        for (Employee employee : employees) {
            salary += employee.getSalary();
        }
        return salary / employees.size();
    }

    public String getName() {
        return name;
    }
}
