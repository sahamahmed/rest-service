package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FirstController {
    private final StudentRepository repository;
    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ){
        return repository.save(student);

    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return repository.findByStatus(Status.ACTIVE);
    }

    @GetMapping("/students/{Student-id}")
    public Student findbyId(
            @PathVariable("Student-id") Integer id){
        return repository.findByIdAndStatus(id , Status.ACTIVE)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{Student-name}")
    public List<Student> findbyName(
            @PathVariable("Student-name") String name){
        return repository.findAllByFirstnameContaining(name);

    }
    @DeleteMapping("/students/{Student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("Student-id") Integer id){
        Optional<Student> Student = repository.findById(id);
        Student.ifPresent(student -> {
            student.setStatus(Status.DELETED);
            repository.save(student);
        });
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(
            @PathVariable("id") Integer id,
            @RequestBody Student updatedStudent) {
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
