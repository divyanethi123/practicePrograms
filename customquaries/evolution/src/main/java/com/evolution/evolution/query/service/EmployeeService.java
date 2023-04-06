package com.evolution.evolution.query.service;

import com.evolution.evolution.query.entity.Employee;
import com.evolution.evolution.query.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> searchEmployees(String name) {
        return this.employeeRepository.findByName(name);
    }

    public List<Employee> filterEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
        return this.employeeRepository.findBySalaryRange(minSalary, maxSalary);
    }
}
