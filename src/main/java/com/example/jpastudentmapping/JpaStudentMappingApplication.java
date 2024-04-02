package com.example.jpastudentmapping;

import com.example.jpastudentmapping.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
