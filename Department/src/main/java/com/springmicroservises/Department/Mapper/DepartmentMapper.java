package com.springmicroservises.Department.Mapper;

import com.springmicroservises.Department.DTO.DepartmentDto;
import com.springmicroservises.Department.Entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto dto=new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getDepartmentCode()
        );
        return  dto;
    }

    public static  Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDescription(),
                departmentDto.getDepartmentCode()
        );
        return  department;
    }
}
