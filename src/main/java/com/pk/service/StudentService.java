package com.pk.service;

import com.pk.dto.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {

   public static Map<UUID,Student> map = new HashMap<>();
    public UUID regStd(Student student){
        UUID stdId = null;
        if (student !=null){
            stdId = UUID.randomUUID();
            map.put(stdId,student);
        }
        return stdId;
    }
}