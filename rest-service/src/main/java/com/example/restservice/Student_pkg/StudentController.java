package com.example.restservice.Student_pkg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public StudentResponseDto updateStudent(@PathVariable("id") Integer id, @RequestBody StudentDto dto) {
        return service.updateStudent(id , dto);
    }

    @PutMapping("/student/{std-Id}/subject/{sub-id}")
            public Student assignSubjectToStudent(
                    @PathVariable("std-Id") Integer student_Id,
                    @PathVariable("sub-id") Integer subject_id
    ){
        return service.assignSubjectToStudent(student_Id , subject_id);
    }
}
