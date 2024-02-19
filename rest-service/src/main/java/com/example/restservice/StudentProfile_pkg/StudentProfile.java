package com.example.restservice.StudentProfile_pkg;

import com.example.restservice.Student_pkg.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    public StudentProfile(){

    }

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
