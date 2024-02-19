package com.example.restservice;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public Student findById(Integer id) {
        return repository.findByIdAndStatus(id, Status.ACTIVE)
                .orElse(new Student());
    }

    public List<Student> findAllStudents(){
        return repository.findByStatus(Status.ACTIVE);
    }

    public void delete(Integer id){
        Optional<Student> Student = repository.findById(id);
        Student.ifPresent(student -> {
            student.setStatus(Status.DELETED);
            repository.save(student);
        });
    }

    public Student post(Student student){
        return repository.save(student);
    }

    public Student updateStudent(
            Integer id,
            Student updatedStudent) {
        Optional<Student> targetStudent = repository.findByIdAndStatus(id , Status.ACTIVE);
        if (targetStudent.isPresent()) {
            Student existingStudent = targetStudent.get();
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAge(updatedStudent.getAge());

            return repository.save(existingStudent);
        }
        else {return new Student();}
    }
}
