package com.springmicroservises.Department.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private int departmentId;
    private String departmentName;
    private String description;
    private String departmentCode;
}
