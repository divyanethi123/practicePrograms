package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	 @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:name% OR e.lastName LIKE %:name%")
	    List<Employee> findByName(@Param("name") String name);

	    @Query(value = "SELECT * FROM Employee WHERE salary >= :minSalary AND salary <= :maxSalary", nativeQuery = true)
	    List<Employee> findBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

	    @Query(value = "SELECT * FROM Employee WHERE LOWER(firstName) LIKE LOWER(concat(:name, '%'))", nativeQuery = true)
	    List<Employee> findByNameStartsWithIgnoreCaseNative(String name);

	    @Query(value = "SELECT * FROM Employee WHERE LOWER(firstName) LIKE LOWER(concat('%', :name))", nativeQuery = true)
	    List<Employee> findByNameEndsWithIgnoreCaseNative(String name);
	
	

}
