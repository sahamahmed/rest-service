package com.example.restservice.Student_pkg;

import com.example.restservice.School_pkg.SchoolRepository;
import com.example.restservice.subjects.Subject;
import com.example.restservice.subjects.SubjectRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final SubjectRepository subjectRepository;
    private final StudentMapper mapper;
    public StudentService(StudentRepository repository, SubjectRepository subjectRepository, StudentMapper mapper) {
        this.repository = repository;
        this.subjectRepository = subjectRepository;
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



    public StudentResponseDto updateStudent(
            Integer id,
            StudentDto dto) {
        Optional<Student> targetStudent = repository.findByIdAndStatus(id , Status.ACTIVE);
        if (targetStudent.isPresent()) {
            Student existingStudent = targetStudent.get();
            var updatedStudent = mapper.toStudent(dto);
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setSchool(updatedStudent.getSchool());

            var savedstudent = repository.save(existingStudent);
            return mapper.tostudentResponseDto(savedstudent);
        }
        else {return null;}
    }

    public Student assignSubjectToStudent(Integer studentId, Integer subjectId) {
        Set<Subject> SubjectSet = null;
        Student student = repository.findById(studentId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        SubjectSet = student.getSubjectsSelected();
        SubjectSet.add(subject);
        student.setSubjectsSelected(SubjectSet);
        return repository.save(student);
    }
}
