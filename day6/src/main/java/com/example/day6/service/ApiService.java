package com.example.day6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6.model.Child;
import com.example.day6.repository.ChildRepo;

@Service
public class ApiService {
@Autowired
private ChildRepo childRepo;

public Child saveChild(Child child) {
	return childRepo.save(child);
}

public Page<Child> getChildbyField(String field,int pageNo,int pageSize){
	Sort sort=Sort.by(field);
	Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
	return childRepo.findAll(pageable);
}
}
