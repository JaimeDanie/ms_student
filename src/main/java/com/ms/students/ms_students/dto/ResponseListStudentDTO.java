package com.ms.students.ms_students.dto;

import com.ms.students.ms_students.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListStudentDTO {
    private boolean success;
    private List<Student> students;


}
