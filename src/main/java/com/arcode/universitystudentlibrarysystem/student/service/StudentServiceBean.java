package com.arcode.universitystudentlibrarysystem.student.service;

import com.arcode.universitystudentlibrarysystem.student.dto.StudentDTO;
import com.arcode.universitystudentlibrarysystem.student.persistence.db.StudentRepository;
import com.arcode.universitystudentlibrarysystem.student.persistence.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceBean implements StudentService {

    private final StudentRepository<Student> studentRepository;

    @Override
    public StudentDTO getStudent(long studentId) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    student.getPhone(),
                    student.getEpisode());
        } else {
            throw new Exception("Student is not found in the system");
        }
    }

    @Override
    public List<StudentDTO> getStudentList() {
        return studentRepository.findAll().stream()
                .map(
                        student ->
                                new StudentDTO(
                                        student.getId(),
                                        student.getName(),
                                        student.getSurname(),
                                        student.getPhone(),
                                        student.getEpisode()))
                .collect(Collectors.toList());
    }

    @Override
    public void addStudent(StudentDTO studentDTO){
        Student student = Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .phone(studentDTO.getPhone())
                .episode(studentDTO.getEpisode())
                .build();

        studentRepository.save(student);
    }

    @Override
    public void updateStudent(long studentId , StudentDTO studentDTO) throws Exception {
        final Optional<Student> resultStudent = studentRepository.findById(studentId);
        if (resultStudent.isPresent()) {
            resultStudent.get().setName(studentDTO.getName());
            resultStudent.get().setSurname(studentDTO.getSurname());
            resultStudent.get().setPhone(studentDTO.getPhone());
            resultStudent.get().setEpisode(studentDTO.getEpisode());

            studentRepository.save(resultStudent.get());
        }else {
            throw new Exception("Student with id " + studentId + " does not update.");
        }
    }

    @Override
    public void deleteStudent(long studentId) throws Exception{
        final Optional<Student> possibleStudent = studentRepository.findById(studentId);
        if (possibleStudent.isPresent()) {
            final Student student = possibleStudent.get();
            studentRepository.deleteById(studentId);
        }else {
            throw new Exception("Student with id " + studentId + " does not exist.");
        }
    }
}
