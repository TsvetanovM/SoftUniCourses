package data.spring.automappingobjects.services.impl;

import data.spring.automappingobjects.models.DTOs.ManagerDTO;
import data.spring.automappingobjects.repositories.EmployeeRepository;
import data.spring.automappingobjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDTO findOne(Long id) {
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
