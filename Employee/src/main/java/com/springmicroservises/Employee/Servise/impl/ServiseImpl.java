package com.springmicroservises.Employee.Servise.impl;

import com.springmicroservises.Employee.DTO.APIResponseDto;
import com.springmicroservises.Employee.DTO.DepartmentDto;
import com.springmicroservises.Employee.DTO.EmployeeDTO;
import com.springmicroservises.Employee.DTO.OrganizationDto;
import com.springmicroservises.Employee.Entity.Employee;
import com.springmicroservises.Employee.Mapping.EmployeeMapper;
import com.springmicroservises.Employee.Repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiseImpl  implements  EmployeeServise{
    @Autowired
    private EmployeeRepo employeeRepo;

//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//        Employee emp=new Employee(
//                employeeDTO.getEmployeeId(),
//                employeeDTO.getFirstName(),
//                employeeDTO.getLastName(),
//                employeeDTO.getEmail(),
//                employeeDTO.getDepartmentCode()
//        );
        Employee emp=EmployeeMapper.mapToEmployee(employeeDTO);

        Employee emp2= employeeRepo.save(emp);

//         EmployeeDTO dto=new EmployeeDTO(
//                 emp2.getEmployeeId(),
//                 emp2.getFirstName(),
//                 emp2.getLastName(),
//                 emp2.getEmail(),
//                 emp2.getDepartmentCode()
//         );
        EmployeeDTO dto=EmployeeMapper.mapToEmployeeDto(emp2);
         return dto;
    }

    public APIResponseDto byId(int id){
        Employee emp=employeeRepo.findById(id).get();

//     ResponseEntity<DepartmentDto>  responseEntity=restTemplate.getForEntity("http://localhost:9001/api/department/" +emp.getDepartmentCode(),
//                DepartmentDto.class);
//    http://DEPARTMENT/api/department/
//        http://localhost:9001/api/department/
//     DepartmentDto departmentDto=responseEntity.getBody();

//        http://DEPARTMENT/api/department/

//   .uri("http://localhost:9001/api/department/" + emp.getDepartmentCode())


   DepartmentDto departmentDto= webClient.get()
                .uri("http://localhost:9001/api/department/" + emp.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
//        http://localhost:9001/api/department/IT001
//        EmployeeDTO dto=new EmployeeDTO(
//                emp.getEmployeeId(),
//                emp.getFirstName(),
//                emp.getLastName(),
//                emp.getEmail(),
//                emp.getDepartmentCode()
//        );

        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:9003/organization/"+emp.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();


        EmployeeDTO employeedto= EmployeeMapper.mapToEmployeeDto(emp);

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeedto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return  apiResponseDto;
    }


}
