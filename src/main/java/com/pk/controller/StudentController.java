package com.pk.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.dto.StudentDto;
import com.pk.response.ApiResponse;
import com.pk.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/std/reg")
	public ResponseEntity<ApiResponse<UUID>> stdReg(@RequestBody StudentDto student) {
		UUID stdId = service.regStd(student);
		if (stdId != null) {
			ApiResponse<UUID> successResponse = new ApiResponse<>("Student Registration is completed", "Success",
					stdId);
			return ResponseEntity.ok(successResponse);
		} else {
			ApiResponse<UUID> errorResponse = new ApiResponse<>("Student Registration is not completed", "Failed",
					null);
			return ResponseEntity.badRequest().body(errorResponse);
		}
	}
}