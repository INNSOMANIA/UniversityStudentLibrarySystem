package com.arcode.universitystudentlibrarysystem.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class StudentDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    private final long id;

    private final String name;

    private final String surname;

    private final int phone;

    private final String episode;
}
