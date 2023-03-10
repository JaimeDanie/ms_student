package com.ms.students.ms_students.controller;

import com.ms.students.ms_students.dto.RequestStudentDTO;
import com.ms.students.ms_students.dto.ResponseListStudentDTO;
import com.ms.students.ms_students.dto.ResponseStudentDTO;
import com.ms.students.ms_students.entities.Student;
import com.ms.students.ms_students.mappers.StudentMapper;
import com.ms.students.ms_students.service.implementation.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("")
    public ResponseListStudentDTO getAll(){
        ResponseListStudentDTO response=  new ResponseListStudentDTO();
        List<Student> students =studentServiceImpl.getAll();
        response.setStudents(students);
        response.setSuccess(true);
       return  response;
    }

    @PostMapping("")
    public ResponseStudentDTO saveStudent(@Valid @RequestBody RequestStudentDTO student){
        ResponseStudentDTO response=  new ResponseStudentDTO();
        try{
            Student studentByDocument=studentServiceImpl.getOneByDocument(student.getDocument());
            if(studentByDocument==null){
                Student studentCreated=studentServiceImpl.saveStudent(studentMapper.StudentDtoToStudent(student));
                response.setSuccess(true);
                response.setStudent(studentCreated);
                return response;
            }
            response.setSuccess(false);
            response.setStudent("Student already exist");
            return  response;


        }catch (Exception e){
            response.setSuccess(false);
            return null;
        }

    }

    @GetMapping("/{id}")
    public ResponseStudentDTO saveStudent(@PathVariable long id){
        ResponseStudentDTO response=  new ResponseStudentDTO();
        Student student=studentServiceImpl.getOne(id);
        if(student!=null){
            response.setSuccess(true);
            response.setStudent(student);
            return response;
        }
        response.setStudent("Student not found");
        response.setSuccess(false);
        return null;

    }

    @GetMapping("/document/{document}")
    public ResponseStudentDTO getStudentByDocument(@PathVariable String document){
        ResponseStudentDTO response=  new ResponseStudentDTO();
        Student student=studentServiceImpl.getOneByDocument(document);
        if(student!=null){
            response.setSuccess(true);
            response.setStudent(student);
            return response;
        }
        response.setSuccess(false);
        response.setStudent("Student no exist");
        return null;
    }

    @PutMapping("/{id}")
    public ResponseStudentDTO updateStudent(@PathVariable Long id,@Valid @RequestBody RequestStudentDTO student){
        ResponseStudentDTO response=  new ResponseStudentDTO();
        log.info("ID==>"+id);
        Student studentFind= studentServiceImpl.getOne(id);
        log.info("ESTUDIANTE ENCONTRADO==>"+studentFind);
        if(studentFind!=null){
            Student studentFindDocument= studentServiceImpl.getOneByDocument(studentFind.getDocument());
            if(studentFindDocument==null || (studentFindDocument.getId()==id)){
                student.setId(id);
                Student studentUpdate=studentServiceImpl.updateStudent(studentMapper.StudentDtoToStudent(student));
                response.setStudent(studentUpdate);
                response.setSuccess(true);
                return  response ;
            }
            response.setSuccess(false);
            response.setStudent("Student no exist");
            return response;
        }
       response.setSuccess(false);
        response.setStudent("Student no exist");
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseStudentDTO deletStudent(@PathVariable long id){
        ResponseStudentDTO response=  new ResponseStudentDTO();
        Student studentFind= studentServiceImpl.getOne(id);
        if(studentFind!= null){
            int deleted=studentServiceImpl.deleteOne(studentFind);
            if(deleted==1){
                response.setSuccess(true);
                response.setStudent("Student deleted");
                return response;
            }
            response.setSuccess(false);
            response.setStudent("Student no deleted");
            return response;
        }
        response.setSuccess(false);
        response.setStudent("Student no exist");
        return response;
    }
}
