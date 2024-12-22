package com.arcode.universitystudentlibrarysystem.student.controller;

import com.arcode.universitystudentlibrarysystem.student.dto.StudentDTO;
import com.arcode.universitystudentlibrarysystem.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") long studentId) throws Exception {
        return studentService.getStudent(studentId);
    }

    @GetMapping(value = "")
    public List<StudentDTO> getStudentList() {
        return studentService.getStudentList();
    }

    @PostMapping(value = "/add")
    public void addStudent(@RequestBody StudentDTO studentDTO){
        studentService.addStudent(studentDTO);
    }

    @PutMapping(value = "/{studentId}/update")
    public void updateStudent(@PathVariable("studentId") long studentId , @RequestBody StudentDTO studentDTO) throws Exception {
        studentService.updateStudent(studentId , studentDTO);
    }

    @DeleteMapping(value = "/{studentId}/delete")
    public void deleteStudent(@PathVariable("studentId") long studentId) throws Exception {
        studentService.deleteStudent(studentId);
    }
}
