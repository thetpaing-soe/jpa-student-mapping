package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
}
