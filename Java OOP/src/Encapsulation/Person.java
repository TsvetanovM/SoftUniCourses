package Encapsulation;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name must be at least 3 characters long");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name must be at least 3 characters long");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Please enter valid age");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be below the minimum wage");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                " gets " + this.salary + " leva";
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() >= 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        }
    }
}
