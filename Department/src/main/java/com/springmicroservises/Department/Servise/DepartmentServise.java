package com.springmicroservises.Department.Servise;

import com.springmicroservises.Department.DTO.DepartmentDto;

public interface DepartmentServise {
    public DepartmentDto saveDepartment(DepartmentDto departmentDto);
    public DepartmentDto findBycode(String departmentCode);
}
