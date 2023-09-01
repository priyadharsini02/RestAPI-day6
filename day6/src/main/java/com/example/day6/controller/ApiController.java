package com.example.day6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.model.Child;
import com.example.day6.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	private ApiService service;
	
	@PostMapping("add")
	public Child addChild(@RequestBody Child child) {
		return service.saveChild(child);
	}
	
	@GetMapping
	public ResponseEntity<Page<Child>> getChildbyField(@RequestParam String field,@RequestParam int pageNo,@RequestParam int pageSize){
		Page<Child> child=service.getChildbyField(field, pageNo, pageSize);
		return ResponseEntity.ok(child);
	}
}
