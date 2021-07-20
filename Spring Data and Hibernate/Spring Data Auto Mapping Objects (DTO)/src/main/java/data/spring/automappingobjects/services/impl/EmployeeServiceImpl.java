package data.spring.automappingobjects.services.impl;

import data.spring.automappingobjects.models.DTOs.EmployeeDTO;
import data.spring.automappingobjects.models.entities.Employee;
import data.spring.automappingobjects.repositories.EmployeeRepository;
import data.spring.automappingobjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO findOne(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this.employeeRepository.findById(id).orElseThrow(), EmployeeDTO.class);


//        Employee employee = this.employeeRepository.findById(id).orElseThrow();
//
//        var dto = new EmployeeDTO();
//        dto.setFirstName(employee.getFirstName());
//        dto.setLastName(employee.getLastName());
//        dto.setSalary(employee.getSalary());
//
//        return dto;
    }
}
