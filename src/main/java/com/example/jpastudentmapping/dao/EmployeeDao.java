package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Employee> findTopByOrderBySalaryDesc();
}
