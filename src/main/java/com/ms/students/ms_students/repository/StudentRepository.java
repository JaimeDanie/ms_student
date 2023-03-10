package com.ms.students.ms_students.repository;

import com.ms.students.ms_students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends  JpaRepository<Student, Long>{

    Student findByDocument(String document);
}
