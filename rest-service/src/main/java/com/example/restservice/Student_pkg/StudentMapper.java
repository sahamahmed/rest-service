package com.example.restservice.Student_pkg;

import com.example.restservice.School_pkg.School;
import com.example.restservice.subjects.Subject;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto tostudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstname() ,student.getLastname() , student.getEmail());
    }



}
