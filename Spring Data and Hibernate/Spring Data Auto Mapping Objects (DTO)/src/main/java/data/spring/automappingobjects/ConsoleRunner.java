package data.spring.automappingobjects;

import data.spring.automappingobjects.dto.EmployeeDTO;
import data.spring.automappingobjects.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        var employee = new Employee("Martin", "Tsvetanov", new BigDecimal(3500),
                LocalDate.of(1994, 1, 11), "Manastirski Livadi");

        ModelMapper modelMapper = new ModelMapper();
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);

        System.out.println();
    }
}
