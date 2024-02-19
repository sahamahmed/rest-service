package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    List<Student> findByStatus(Status status);
    List<Student> findAllByFirstnameContaining(String p);


    Optional<Student> findByIdAndStatus(Integer id, Status status);
}
