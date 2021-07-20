package data.spring.automappingobjects.services.impl;

import data.spring.automappingobjects.models.DTOs.ManagerDTO;
import data.spring.automappingobjects.repositories.EmployeeRepository;
import data.spring.automappingobjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ManagerDTO findOne(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this.employeeRepository.findById(id).orElseThrow(), ManagerDTO.class);


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
