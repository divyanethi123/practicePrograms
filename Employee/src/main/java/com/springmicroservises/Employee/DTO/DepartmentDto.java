package com.springmicroservises.Employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private int departmentId;
    private String departmentName;
    private String description;
    private String departmentCode;

}
