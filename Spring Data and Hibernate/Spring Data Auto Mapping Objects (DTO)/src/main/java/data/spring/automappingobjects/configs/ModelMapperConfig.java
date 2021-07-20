package data.spring.automappingobjects.configs;

import data.spring.automappingobjects.models.DTOs.EmployeeDTO;
import data.spring.automappingobjects.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapperEmployee() {

        ModelMapper mapper = new ModelMapper();
        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(mapping -> mapping.map(Employee::getSalary, EmployeeDTO::setIncome));

        return mapper;
    }
}
