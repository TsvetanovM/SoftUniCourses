package data.spring.automappingobjects.services;

import data.spring.automappingobjects.models.DTOs.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO findOne(Long id);
}
