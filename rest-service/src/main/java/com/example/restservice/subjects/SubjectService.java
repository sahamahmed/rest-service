package com.example.restservice.subjects;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    public SubjectService(SubjectRepository repository, SubjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Subject> getSubjects(){
        return repository.findAll();
    }

    public Subject createSubject(SubjectDto dto){
        Subject subject = mapper.toSubject(dto);
        repository.save(subject);
        return subject;
    }

    public void deleteSubject(Integer subject_id){
        repository.deleteById(subject_id);
    }


}
