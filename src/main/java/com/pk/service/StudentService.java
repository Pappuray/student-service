package com.pk.service;

import com.pk.dto.StudentDto;
import com.pk.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {

   public static Map<UUID, StudentDto> map = new HashMap<>();
    public UUID regStd(StudentDto student){
        UUID stdId = null;
        if (student !=null){
            stdId = UUID.randomUUID();
            map.put(stdId,student);
        }
        return stdId;
    }
}