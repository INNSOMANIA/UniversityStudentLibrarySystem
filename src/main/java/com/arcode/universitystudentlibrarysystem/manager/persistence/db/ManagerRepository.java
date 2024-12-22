package com.arcode.universitystudentlibrarysystem.manager.persistence.db;

import com.arcode.universitystudentlibrarysystem.manager.persistence.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository<T extends Manager> extends JpaRepository<Manager , Long> {

    Optional<Manager> findById(Long managerId);

    List<Manager> findAll();
}
