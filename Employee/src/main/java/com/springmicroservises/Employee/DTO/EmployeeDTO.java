package com.springmicroservises.Employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private  String organizationCode;
}
