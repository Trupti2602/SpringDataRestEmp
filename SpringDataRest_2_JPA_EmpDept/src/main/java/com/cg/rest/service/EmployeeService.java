package com.cg.rest.service;

import java.util.List;

import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
	
    public List<Employee> findAllEmployee();
    
    Employee findEmployeeById(int id)throws NoSuchEmployeeFoundException;
    
    Employee modifyEmployee(Employee e,int id)throws NoSuchEmployeeFoundException;
    
    //boolean removeEmployee(int id)throws NoSuchEmployeeFoundException;
    
    //public List<Employee> findEmpByDept(String deptName);

	public boolean deleteEmployee(int id)throws NoSuchEmployeeFoundException;

	public List<Employee> findEmployeeByDept(String deptName)throws NoSuchEmployeeFoundException;
	
    
    
}
