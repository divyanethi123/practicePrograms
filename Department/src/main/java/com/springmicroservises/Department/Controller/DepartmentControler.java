package com.springmicroservises.Department.Controller;

import com.springmicroservises.Department.DTO.DepartmentDto;
import com.springmicroservises.Department.Servise.DepartmentServise;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentControler {

    private DepartmentServise departmentServise;

    @PostMapping("/save")
    ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto= departmentServise.saveDepartment(departmentDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);

    }
    @GetMapping("/{byCode}")
    ResponseEntity<DepartmentDto> findByCode(@PathVariable("byCode")   String departmentCode){
        System.out.println(departmentCode);
        DepartmentDto dto=departmentServise.findBycode(departmentCode);
        return   ResponseEntity.ok(dto);
    }
}
