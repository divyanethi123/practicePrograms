package com.springmicroservises.Employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDTO employee;
    private DepartmentDto department;
    private OrganizationDto organization;

}
