package com.example.restservice.School_pkg;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){
        return service.create(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){

        return service.findAll();
    }
}
