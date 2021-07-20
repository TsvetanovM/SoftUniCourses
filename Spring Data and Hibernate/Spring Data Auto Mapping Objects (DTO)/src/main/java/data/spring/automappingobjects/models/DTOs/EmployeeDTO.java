package data.spring.automappingobjects.models.DTOs;

import java.math.BigDecimal;

public class EmployeeDTO extends BasicEmployeeDTO{

    private BigDecimal income;

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
