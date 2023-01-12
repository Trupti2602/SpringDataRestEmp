package com.cg.rest.service;

import java.util.List;

import com.cg.rest.entity.Department;
import com.cg.rest.exception.NoSuchDepartmentFoundException;

public interface DepartmentService {
	public List<Department> findAllDepartment();
	public Department addDepartment(Department id);
	public Department findDepartmentById(int id)throws NoSuchDepartmentFoundException;
	public Department modifyDepartment(int id,Department d)throws NoSuchDepartmentFoundException;
    public boolean deleteDepartment(int id)throws NoSuchDepartmentFoundException;
}
