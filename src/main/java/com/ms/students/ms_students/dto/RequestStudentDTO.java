package com.ms.students.ms_students.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestStudentDTO {

    private long id;

    @NotBlank(message = "document is required.")
    private String document;

    @NotBlank(message = "firstName is required.")
    private String firstName;

    @NotBlank(message = "secondName is required.")
    private String secondName;

    @NotBlank(message = "lastName is required.")
    private String lastName;

    @NotBlank(message = "lastNameTwo is required.")
    private String lastNameTwo;

    @NotNull(message = "birthdate is required!.")
    private LocalDate birthdate;

    private String photoUrl;
}
