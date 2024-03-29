package com.example.restservice.Student_pkg;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    List<Student> findByStatus(Status status);
    Optional<Student> findByIdAndStatus(Integer id, Status status);
}
