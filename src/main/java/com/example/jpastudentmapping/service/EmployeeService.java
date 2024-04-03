package com.example.jpastudentmapping.service;

import com.example.jpastudentmapping.dao.EmployeeDao;
import com.example.jpastudentmapping.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public void createEmployee(String firstName, String lastName, String email, double salary) {

        Employee employee = new Employee(firstName, lastName, email, salary);
        employeeDao.save(employee);
    }

    public Iterable<Employee> listAllEmployee() {
        return employeeDao.findAll();
    }

    public Employee findEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return employeeDao.findByFirstNameAndLastName(firstName, lastName).orElse(null);
    }

    public Employee findMaxSalary() {
        return employeeDao.findTopByOrderBySalaryDesc().get();
    }
}
