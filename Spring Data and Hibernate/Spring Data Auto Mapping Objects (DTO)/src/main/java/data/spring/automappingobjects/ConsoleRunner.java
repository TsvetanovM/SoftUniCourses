package data.spring.automappingobjects;

import data.spring.automappingobjects.models.DTOs.EmployeeDTO;
import data.spring.automappingobjects.models.DTOs.ManagerDTO;
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

        ManagerDTO dto = this.employeeService.findOne(4L);
        System.out.printf("%s %s | Employees: %d%n", dto.getFirstName(), dto.getLastName(), dto.getSubordinates().size());

                dto.getSubordinates().forEach(EmployeeDTO -> System.out.printf("\t - " +
                        "%s %s %.2f%n", EmployeeDTO.getFirstName(), EmployeeDTO.getLastName(), EmployeeDTO.getSalary()));
    }
}
