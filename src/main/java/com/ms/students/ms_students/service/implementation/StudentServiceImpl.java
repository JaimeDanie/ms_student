package com.ms.students.ms_students.service.implementation;

import com.ms.students.ms_students.entities.Student;
import com.ms.students.ms_students.repository.StudentRepository;
import com.ms.students.ms_students.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOne(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getOneByDocument(String document) {
        return studentRepository.findByDocument(document);
    }

    @Override
    public int deleteOne(Student student) {
        try{
            studentRepository.delete(student);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
