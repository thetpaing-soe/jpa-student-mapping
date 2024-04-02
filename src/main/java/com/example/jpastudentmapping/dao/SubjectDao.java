package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Student;
import com.example.jpastudentmapping.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubjectDao extends JpaRepository<Subject, Integer> {

//    @Query("""
//select s from Student s join s.studentSubjects stsub order by stsub.marks desc limit 1
//""")
    @Query("""
select s from Student s join s.studentSubjects stusub join stusub.subject sb
where sb.subjectName = :name and stusub.marks = (select max(sb.marks) from StudentSubject sb join sb.subject subj where subj.subjectName = :name)
""")
    Optional<Student> findStudentHighestMark(String name);
}
