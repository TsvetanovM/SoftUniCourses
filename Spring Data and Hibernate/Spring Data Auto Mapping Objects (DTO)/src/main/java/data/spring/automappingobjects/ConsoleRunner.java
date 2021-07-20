package data.spring.automappingobjects;

import data.spring.automappingobjects.models.DTOs.EmployeeDTO;
import data.spring.automappingobjects.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        EmployeeDTO dto = this.employeeService.findOne(1L);
        System.out.println(dto.getFirstName() + " " + dto.getLastName() + " " + dto.getSalary() );
    }
}
