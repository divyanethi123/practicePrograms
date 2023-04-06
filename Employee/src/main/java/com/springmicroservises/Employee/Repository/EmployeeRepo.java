package com.springmicroservises.Employee.Repository;

import com.springmicroservises.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee,Integer> {
}
