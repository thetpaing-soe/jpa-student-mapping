package com.example.jpastudentmapping.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("employee")
@ToString
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
    }
}
