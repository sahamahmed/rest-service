package com.example.restservice.Student_pkg;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
