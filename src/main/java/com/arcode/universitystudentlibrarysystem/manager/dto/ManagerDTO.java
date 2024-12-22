package com.arcode.universitystudentlibrarysystem.manager.dto;

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
public class ManagerDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 3L;

    private final long id;

    private final String name;

    private final String surname;

    private final String birthDay;
}
