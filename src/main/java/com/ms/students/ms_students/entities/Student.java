package com.ms.students.ms_students.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "document is required.")
    private String document;

    @Column
    @NotBlank(message = "firstName is required.")
    private String firstName;

    @Column
    @NotBlank(message = "secondName is required.")
    private String secondName;

    @Column
    @NotBlank(message = "lastName is required.")
    private String lastName;

    @Column
    @NotBlank(message = "lastNameTwo is required.")
    private String lastNameTwo;

    @Column
    @NotNull(message = "birthdate is required!.")
    private LocalDate birthdate;

    @Column
    private String photoUrl;
}
