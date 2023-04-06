package com.springmicroservises.Employee.Mapping;

import com.springmicroservises.Employee.DTO.EmployeeDTO;
import com.springmicroservises.Employee.Entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDto(Employee employee){
        EmployeeDTO dto=new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );
        return  dto;
    }
    public static  Employee mapToEmployee(EmployeeDTO employeeDTO){
        Employee employee=new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );
        return  employee;
    }
}
