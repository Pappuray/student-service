package com.pk.controller;

import com.pk.dto.Student;
import com.pk.response.ApiResponse;
import com.pk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.RandomAccess;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/std/reg")
    public ResponseEntity<ApiResponse<UUID>> stdReg(@RequestBody Student student){
        ResponseEntity<ApiResponse<UUID>> response = null;
        UUID stdId = service.regStd(student);
        if (stdId !=null){
            ApiResponse<UUID> successResponse = new ApiResponse<>("Student Registration is completed", "Success", stdId);
            response = ResponseEntity.ok(successResponse);
        }else{
            ApiResponse<UUID> errorResponse = new ApiResponse<>("Student Registration is not completed", "Failed", null);
            response =  ResponseEntity.badRequest().body(errorResponse);
        }

        return response;
    }
}