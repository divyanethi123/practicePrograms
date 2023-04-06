package com.springmicroservises.Department.Servise.Impl;

import com.springmicroservises.Department.DTO.DepartmentDto;
import com.springmicroservises.Department.Entity.Department;
import com.springmicroservises.Department.Mapper.DepartmentMapper;
import com.springmicroservises.Department.Repository.DepartmentRepo;
import com.springmicroservises.Department.Servise.DepartmentServise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiseImpl implements DepartmentServise {

    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

//        Department department=new Department(
//                departmentDto.getDepartmentId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDescription(),
//                departmentDto.getDepartmentCode()
//        );
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
      Department department1=  departmentRepo.save(department);

//        DepartmentDto departmentDto1=new DepartmentDto(
//                department1.getDepartmentId(),
//                department1.getDepartmentName(),
//                department1.getDescription(),
//                department1.getDepartmentCode()
//        );
        DepartmentDto departmentDto1=DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto1;
    }

    @Override
    public DepartmentDto findBycode(String departmentCode) {

      Department department=  departmentRepo.findBydepartmentCode(departmentCode);

//      DepartmentDto dto=new DepartmentDto(
//              department.getDepartmentId(),
//              department.getDepartmentName(),
//              department.getDescription(),
//              department.getDepartmentCode()
//
//      );
        DepartmentDto dto=DepartmentMapper.mapToDepartmentDto(department);
        return dto;
    }
}




