package com.example.restservice.subjects;

import com.example.restservice.School_pkg.School;
import com.example.restservice.Student_pkg.Student;
import com.example.restservice.Student_pkg.StudentDto;
import com.example.restservice.Student_pkg.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {
    public Subject toSubject(SubjectDto dto){
        var subject = new Subject();
        subject.setSubject_name(dto.subject_name());
        return subject;
    }

    public SubjectDto tosubjectDto(Subject subject){
        return new SubjectDto(subject.getSubject_name());
    }
}
