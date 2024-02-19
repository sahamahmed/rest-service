package com.example.restservice.Student_pkg;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/students")
    public StudentResponseDto createStudent(
            @RequestBody StudentDto dto ){

        return service.post(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return service.findAllStudents();
    }

    @GetMapping("/students/{Student-id}")
    public StudentResponseDto findbyId(@PathVariable("Student-id") Integer id){
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
