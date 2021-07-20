package data.spring.automappingobjects.services;

import data.spring.automappingobjects.models.DTOs.ManagerDTO;

public interface EmployeeService {

    ManagerDTO findOne(Long id);
}
