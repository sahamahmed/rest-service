package com.example.restservice.School_pkg;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper mapper;
    public SchoolService(SchoolRepository schoolRepository, SchoolMapper mapper) {
        this.schoolRepository = schoolRepository;
        this.mapper = mapper;
    }

    public SchoolDto create(SchoolDto dto){
        var school = mapper.toSchool(dto);
        var savedSchool= schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(mapper::toschoolDto)
                .collect(Collectors.toList());
    }
}
