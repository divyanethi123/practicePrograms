package com.exam.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.model.Employee;
import com.exam.repository.EmployeeRepository;

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
