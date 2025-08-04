package com.pk.service;

import com.pk.dto.StudentDto;
import com.pk.dto.StudentDto;
import com.pk.entity.StudentEntity;
import com.pk.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public UUID regStd(StudentDto dto){
        if (dto !=null){
            StudentEntity entity = new StudentEntity();
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setAge(dto.getAge());
            StudentEntity saved = repository.save(entity);
            return saved.getId();
        }
        return null;
    }
}