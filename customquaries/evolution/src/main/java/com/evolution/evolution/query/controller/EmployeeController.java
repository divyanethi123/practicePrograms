package com.evolution.evolution.query.controller;

import com.evolution.evolution.query.entity.Employee;
import com.evolution.evolution.query.repo.EmployeeRepository;
import com.evolution.evolution.query.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;


    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee )
    {
       return repository.save(employee);


    }
        @GetMapping("/search")
        public List<Employee> searchEmployees(@RequestParam("name") String name) {
            return this.employeeService.searchEmployees(name);
        }
    @GetMapping("/startwith")
    public List<Employee> startWithEmployees(@RequestParam("name") String name) {
        return repository.findByName(name);
    }
    @GetMapping("/endswith")
    public List<Employee> endWithEmployees(@RequestParam("name") String name) {
        return repository.findByName(name);
    }

        @GetMapping("/filter")
        public List<Employee> filterEmployeesBySalaryRange(@RequestParam("minSalary") Double minSalary, @RequestParam("maxSalary") Double maxSalary) {
            return this.employeeService.filterEmployeesBySalaryRange(minSalary, maxSalary);
        }

}
