package com.arcode.universitystudentlibrarysystem.student.service;

import com.arcode.universitystudentlibrarysystem.student.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    StudentDTO getStudent(long studentId) throws Exception;

    List<StudentDTO> getStudentList();

    void addStudent(StudentDTO studentDTO);

    void updateStudent(long studentId , StudentDTO studentDTO) throws Exception;

    void deleteStudent(long studentId) throws Exception;
}
