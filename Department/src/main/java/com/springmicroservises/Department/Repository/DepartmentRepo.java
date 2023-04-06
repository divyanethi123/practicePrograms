package com.springmicroservises.Department.Repository;

import com.springmicroservises.Department.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo  extends JpaRepository<Department,Integer> {
    Department findBydepartmentCode(String departmentCode);
}
