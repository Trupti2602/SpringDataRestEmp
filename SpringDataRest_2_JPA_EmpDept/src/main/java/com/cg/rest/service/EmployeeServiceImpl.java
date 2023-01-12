package com.cg.rest.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.EmployeeRepo;
import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	@Transactional
	public Employee addEmployee(Employee e) {
		
		return empRepo.save(e);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) throws NoSuchEmployeeFoundException {
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent()) {
		return emp.get();
	}else {
		
		
		throw new NoSuchEmployeeFoundException("Employee not found");
	}

}
	@Override
	@Transactional
	public Employee modifyEmployee(Employee e, int id) throws NoSuchEmployeeFoundException {
		Employee findEmp=findEmployeeById(id);
		findEmp.setEmpName(e.getEmpName());
		findEmp.setDept(e.getDept());
		findEmp.setEmpRole(e.getEmpRole());
		findEmp.setEmpSalary(e.getEmpSalary());
		return empRepo.save(findEmp);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) throws NoSuchEmployeeFoundException {
		//empRepo.deleteById(id);
		Optional<Employee>emp=empRepo.findById(id);
		if(emp.isPresent()) {
			empRepo.delete(emp.get());
		return true;
		}
		else {
			throw new NoSuchEmployeeFoundException("Employee Not Found"); 
			
	}
}

	@Override
	public List<Employee> findEmployeeByDept(String deptName) {
		
		return empRepo.findEmpByDeptId(deptName);
	}

	

	
}
