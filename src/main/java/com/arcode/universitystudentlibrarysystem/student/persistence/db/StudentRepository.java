package com.arcode.universitystudentlibrarysystem.student.persistence.db;
import com.arcode.universitystudentlibrarysystem.student.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository<T extends Student> extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long studentId);

    List<Student> findAll();
}
