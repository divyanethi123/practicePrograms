package com.springmicroservises.Employee.Controller;

import com.springmicroservises.Employee.DTO.APIResponseDto;
import com.springmicroservises.Employee.DTO.EmployeeDTO;
import com.springmicroservises.Employee.Servise.impl.EmployeeServise;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeServise employeeServise;
   @PostMapping("/save")
    ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO dto){
      EmployeeDTO employeeDTO=  employeeServise.saveEmployee(dto);
      return  new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<APIResponseDto> byId(@PathVariable int id){
        System.out.println(id);
    APIResponseDto apiResponseDto=  employeeServise.byId(id);
       return  ResponseEntity.ok(apiResponseDto);

    }
}
