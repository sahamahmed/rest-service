package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class FirstController {
    private final StudentService service;
    public FirstController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return service.post(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }

    @GetMapping("/students/{Student-id}")
    public Student findbyId(@PathVariable("Student-id") Integer id){
        return service.findById(id);
    }


    @DeleteMapping("/students/{Student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("Student-id") Integer id){
        service.delete(id);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("id") Integer id, @RequestBody Student updatedStudent) {
        return service.updateStudent(id , updatedStudent);
    }


}
