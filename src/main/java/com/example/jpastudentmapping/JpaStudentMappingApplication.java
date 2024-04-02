package com.example.jpastudentmapping;

import com.example.jpastudentmapping.entity.Student;
import com.example.jpastudentmapping.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaStudentMappingApplication implements CommandLineRunner {

    private final StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(JpaStudentMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        service.createDb();

//        System.out.println("Student By StudentName::");
//        System.out.println(service.getStudentByNameCustom("John Doe"));

//        System.out.println("Student by Dynamic Query Example::");
//        Student s = new Student();
//        s.setName("John Doe");
//        s.setEmail("john@gmail.com");
//
//        Example<Student> studentExample = Example.of(s);
//        System.out.println(service.studentByExample(studentExample));
        System.out.println("Highest Mark::");
        System.out.println(service.highestMark());
//        service.findStudentHighestMarkBySubject("Java").forEach(System.out::println);
        service.findStudentInfo("Java").forEach(System.out::println);

        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from student_subject");
    }
}
