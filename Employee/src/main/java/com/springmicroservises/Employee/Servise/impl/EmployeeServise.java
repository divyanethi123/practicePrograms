package com.springmicroservises.Employee.Servise.impl;

import com.springmicroservises.Employee.DTO.APIResponseDto;
import com.springmicroservises.Employee.DTO.EmployeeDTO;

public interface EmployeeServise {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    APIResponseDto byId(int id);


}
