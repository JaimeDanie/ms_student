package com.ms.students.ms_students.mappers;

import com.ms.students.ms_students.dto.RequestStudentDTO;
import com.ms.students.ms_students.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Student StudentDtoToStudent(RequestStudentDTO studentDTO){
      return  modelMapper.map(studentDTO,Student.class);
    }

    public RequestStudentDTO StudentToStudentDto(Student student){
        return  modelMapper.map(student,RequestStudentDTO.class);
    }
}
