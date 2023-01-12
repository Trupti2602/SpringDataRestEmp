package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Department;
import com.cg.rest.service.DepartmentService;

@RestController
public class DepartmentRestController {
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/all-dept")
	public ResponseEntity<List<Department>> allDepartments(){
		try {
			List<Department> deptList=service.findAllDepartment();
			if(deptList.isEmpty()) {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(deptList,HttpStatus.OK);
			}
		}catch(Exception e) {
				System.out.println(e.getMessage());
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
				
	}
	@PostMapping("/new-dept")
	public ResponseEntity<Department> createDepartment(@RequestBody Department d){
		try {
			Department dept=service.addDepartment(d);
			return new ResponseEntity<>(dept,HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(path="department/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id){
		try {
			Department emp=service.findDepartmentById(id);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(path="/modifyDepartment/{id}")
	public ResponseEntity<Department> modifyDepartmentById(@PathVariable("id") int id,@RequestBody Department d){
		try {
			Department dept=service.modifyDepartment(id,d);
			return new ResponseEntity<>(dept,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
    @DeleteMapping(path="/deleteDept/{id}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable("id") int id){
		try {
			boolean isDel=service.deleteDepartment(id);
			return new ResponseEntity<>(isDel,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

}
