package com.example.restservice.subjects;

import com.example.restservice.Student_pkg.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Integer subject_id;
    private String subject_name;


    @ManyToMany(mappedBy = "subjectsSelected")
    @JsonManagedReference
    private Set<Student> studentset;

    public Subject() {
    }

    public Subject(String subject_name) {
        subject_name = subject_name;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Set<Student> getStudentset() {
        return studentset;
    }

    public void setStudentset(Set<Student> studentset) {
        this.studentset = studentset;
    }
}
