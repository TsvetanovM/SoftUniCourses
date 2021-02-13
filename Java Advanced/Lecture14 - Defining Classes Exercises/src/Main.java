import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Department> companyLog = new HashMap<>();

        while (N-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Employee employee = createEmployee(tokens);
            String department = employee.getDepartment();
            companyLog.putIfAbsent(department, new Department(department));
            companyLog.get(department).addEmployee(employee);
        }

            companyLog.entrySet()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getValue().getAverageSalary(),
                        d1.getValue().getAverageSalary()))
                .limit(1)
                .forEach(e -> {
                    System.out.println("Highest Average Salary: " + e.getKey());
                    for (Employee employee : e.getValue().getEmployees()) {
                        System.out.println(employee.toString());
                    }
                });
    }

    private static Employee createEmployee(String[] tokens) {
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        String position = tokens[2];
        String department = tokens[3];

        int inputLength = tokens.length;

        if (inputLength == 4) {
            return new Employee(name, salary, position, department);
        }
        if (inputLength == 6) {
            String email = tokens[4];
            int age = Integer.parseInt(tokens[5]);
            return new Employee(name, salary, position, department, email, age);
        }
        try {
            int age = Integer.parseInt(tokens[4]);
            return new Employee(name, salary, position, department, age);
        } catch (NumberFormatException e) {
            String email = tokens[4];
            return new Employee(name, salary, position, department, email);
        }
    }
}
