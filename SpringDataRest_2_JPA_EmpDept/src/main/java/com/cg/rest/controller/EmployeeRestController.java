package com.cg.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;
import com.cg.rest.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private  EmployeeService eService;
	
	@GetMapping("/getemp")
	public ResponseEntity<List<Employee>> allEmployees(){
		try {
			List<Employee> empList=eService.findAllEmployee();
			if(empList.isEmpty()) {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(empList,HttpStatus.OK);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addemp")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee e1){
		
		try {
			Employee emp=eService.addEmployee(e1);
			return new ResponseEntity<>(emp,HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(path="/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		try {
			Employee emp=eService.findEmployeeById(id);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/modifyemp/{id}")
	public ResponseEntity<Employee> modifyEmployeeById(@PathVariable("id")int id,@RequestBody Employee e1){
		try {
			Employee emp=eService.modifyEmployee(e1, id);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("id") int id){
		try {
		    boolean isDel=eService.deleteEmployee(id);
			return new ResponseEntity<>(isDel,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
	
	
}
	
	
	
	
	
	
	