package com.example.restservice.Student_pkg;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;
    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public StudentResponseDto findById(Integer id) {
        Student student = repository.findByIdAndStatus(id, Status.ACTIVE)
                .orElse(new Student());
        return mapper.tostudentResponseDto(student);
    }


    public List<StudentResponseDto> findAllStudents(){
        return repository.findByStatus(Status.ACTIVE)
                .stream()
                .map(mapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        Optional<Student> Student = repository.findById(id);
        Student.ifPresent(student -> {
            student.setStatus(Status.DELETED);
            repository.save(student);
        });
    }


    public StudentResponseDto post(StudentDto dto){
        var student = mapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return mapper.tostudentResponseDto(savedStudent);
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
