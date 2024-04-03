package com.example.jpastudentmapping;

import com.example.jpastudentmapping.service.EmployeeService;
import com.example.jpastudentmapping.service.StudentService;
import com.example.jpastudentmapping.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
@EnableTransactionManagement
public class JpaStudentMappingApplication implements CommandLineRunner {

    private final StudentService studentService;
    private final EmployeeService employeeService;
    private final TransactionService transactionService;

    public static void main(String[] args) {
        SpringApplication.run(JpaStudentMappingApplication.class, args);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void run(String... args) throws Exception {

//        studentService.createDb();

//        System.out.println("Student By StudentName::");
//        System.out.println(studentService.getStudentByNameCustom("John Doe"));

//        System.out.println("Student by Dynamic Query Example::");
//        Student s = new Student();
//        s.setName("John Doe");
//        s.setEmail("john@gmail.com");
//
//        Example<Student> studentExample = Example.of(s);
//        System.out.println(studentService.studentByExample(studentExample));
//        System.out.println("Highest Mark Student::");
//        System.out.println(studentService.highestMark());
//        studentService.findStudentHighestMarkBySubject("Java").forEach(System.out::println);
//        studentService.findStudentInfo("Java").forEach(System.out::println);
//        System.out.println(studentService.studentHighestMark("Python"));
//        System.out.println("Find Student By Example::");
//        studentService.findStudentByExample("updike@gmail.com").forEach(System.out::println);
//        System.out.println("Find Student By DynamicQuery::");
//        System.out.println(studentService.studentByNameConvention("", "hardy@gmail.com"));

//        employeeService.createEmployee("John", "Doe", "john@gmail.com", 2000);
//        employeeService.createEmployee("Thomas", "Hardy", "hardy@gmail.com", 2500);
//        employeeService.createEmployee("Charles", "Dickens", "charles@gmail.com", 2000);

//        employeeService.listAllEmployee().forEach(System.out::println);
//
//        System.out.println("Find Employee By FirstName And LastName::");
//        System.out.println(employeeService.findEmployeeByFirstNameAndLastName("Thomas", "Hardy"));
//
//        System.out.println("Max Salary Employee::");
//        System.out.println(employeeService.findMaxSalary());

        try {
            transactionService.deleteAllEmployee();
            transactionService.createDB();
        } catch (Exception e) {
            System.err.println(e);
        }

        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from student_subject");

        JPAUtil.checkData("select * from employee");
    }
}
