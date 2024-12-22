package com.arcode.universitystudentlibrarysystem.book.dto;

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
public class BookDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 2L;

    private final long id;

    private final String name;

    private final String writer;

    private final String description;
}
