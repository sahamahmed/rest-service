package com.example.restservice.Student_pkg;

import java.util.Set;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
