package com.springmicroservises.Employee.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private String departmentCode;
    private  String organizationCode;
}
