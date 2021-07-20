package data.spring.automappingobjects.models.DTOs;

import java.math.BigDecimal;

public class EmployeeDTO extends BasicEmployeeDTO{

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
