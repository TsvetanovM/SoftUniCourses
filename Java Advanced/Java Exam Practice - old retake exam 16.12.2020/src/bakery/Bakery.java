package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity){
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.remove(name);
    }

    public Employee getOldestEmployee() {
        List<Employee> list = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList());
        return list.get(0);
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        };
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String getName() {
        return name;
    }

    public String report() {
       String output = String.format("Employees working at Bakery %s:%n", getName());
        for (Employee employee : employees) {
            output += employee.toString();
        }
        return output;
    }
}
