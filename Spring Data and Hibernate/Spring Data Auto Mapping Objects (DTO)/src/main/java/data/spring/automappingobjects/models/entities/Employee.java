package data.spring.automappingobjects.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private String address;

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthday, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }
}
