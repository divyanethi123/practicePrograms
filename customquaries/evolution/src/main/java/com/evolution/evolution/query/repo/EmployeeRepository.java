package com.evolution.evolution.query.repo;

import com.evolution.evolution.query.entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:name% OR e.lastName LIKE %:name%")
    List<Employee> findByFirstName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE  e.lastName LIKE %:name%")
    List<Employee> findByLastName(@Param("name") String name);

    @Query(value = "SELECT * FROM Employee WHERE salary >= :minSalary AND salary <= :maxSalary", nativeQuery = true)
    List<Employee> findBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

    @Query(value = "SELECT * FROM Employee WHERE LOWER(firstName) LIKE LOWER(concat(:name, '%'))", nativeQuery = true)
    List<Employee> findByNameStartsWithIgnoreCaseNative(String name);

    @Query(value = "SELECT * FROM Employee WHERE LOWER(firstName) LIKE LOWER(concat('%', :name))", nativeQuery = true)
    List<Employee> findByNameEndsWithIgnoreCaseNative(String name);
}
