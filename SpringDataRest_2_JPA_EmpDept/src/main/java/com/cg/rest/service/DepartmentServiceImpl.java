package com.cg.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.DepartmentRepo;
import com.cg.rest.entity.Department;
import com.cg.rest.exception.NoSuchDepartmentFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepo deptRepo;
    
	@Override
	public List<Department> findAllDepartment() {
		return deptRepo.findAll();
	}

	@Override
	public Department addDepartment(Department d) {
		return deptRepo.save(d);
	}

	@Override
	public Department findDepartmentById(int id) throws NoSuchDepartmentFoundException {
		Optional<Department> dept=deptRepo.findById(id);
		if(dept.isPresent()) {
			return dept.get();
		}else {
			throw new NoSuchDepartmentFoundException("Department Not Found");
		}
	}

	@Override
	public Department modifyDepartment(int id, Department d) throws NoSuchDepartmentFoundException {
		Department findDept=findDepartmentById(id);
		findDept.setDeptName(d.getDeptName());
		findDept.setDeptId(d.getDeptId());
		//findDept.setelist(d.getelist);
		return deptRepo.save(findDept);
	}

	@Override
	public boolean deleteDepartment(int id) throws NoSuchDepartmentFoundException {
		Optional<Department> emp=deptRepo.findById(id);
		if(emp.isPresent()) {
			deptRepo.delete(emp.get());
			return true;
		}else {
			throw new NoSuchDepartmentFoundException("Department is Not Found");
		}
	}

}
