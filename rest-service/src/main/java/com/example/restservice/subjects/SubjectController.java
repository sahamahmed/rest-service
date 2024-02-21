package com.example.restservice.subjects;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody SubjectDto dto){
        return service.createSubject(dto);
    }
    @GetMapping("/subjects")
    public List<Subject> getSubjects(Integer subject_id ){
        return service.getSubjects();
    }
    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@PathVariable("id") Integer subject_id){
        service.deleteSubject(subject_id);
    }

}
