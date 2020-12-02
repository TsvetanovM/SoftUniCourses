package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01CompanyRoster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        List<Employee> allEmployees = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] data = scan.nextLine().split(" ");
                Employee employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
            if (data.length==5){
                if (data[4].contains("@")){
                     employee.setEmail(data[4]);
                }
                else {
                    employee.setAge(Integer.parseInt(data[4]));
                }
            }
            if (data.length==6){
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }
            allEmployees.add(employee);
        }
        Department department = new Department(allEmployees);
        department.rosterChecker();
        System.out.printf("Highest Average Salary: %s%n", department.getBestDepartment().get(0).getDepartment());
        department.getBestDepartment().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(System.out::println);
    }
}

class Employee {

    String name, position, department;
    String email = "n/a";
    double salary;
    int age = -1;

    Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", getName(), getSalary(), getEmail(), getAge());
    }
}

class Department {
    List<Employee> roster;
    List<Employee> bestDepartment;
    double bestSalary = 0.0;

    Department(List<Employee> roster) {
        this.roster = roster;
    }

    public List<Employee> getBestDepartment() {
        return bestDepartment;
    }

    public void rosterChecker() {
        while (this.roster.size() > 0) {
            String department = roster.get(0).getDepartment();
            List<Employee> departmentRoster = salaryRoster(roster, department);
            topDepartment(departmentRoster, averageSalary(departmentRoster));
            roster = leftoverRoster(roster, department);
        }
    }

    public List<Employee> salaryRoster(List<Employee> list, String department) {
        return list.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public void topDepartment(List<Employee> list, double averageSalary) {
        if (averageSalary >= bestSalary) {
            bestSalary = averageSalary;
            bestDepartment = list;
        }
    }

    public List<Employee> leftoverRoster(List<Employee> list, String department) {
        return list.stream().filter(employee -> !employee.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public double averageSalary(List<Employee> list) {
        double totalSalary = 0.0;
        for (Employee employee : list) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / list.size();
    }

}
