package com.cg.rest.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("prototype")
@Table(name="DeptRestTable")
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	private String deptName;
	
	@OneToMany(mappedBy="dept",cascade =CascadeType.ALL )
	private List<Employee> elist=new ArrayList<>();
	
	
	public Department() {}
	
	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	

	public Department(List<Employee> elist) {
		super();
		this.elist = elist;
		for(Employee e:elist) {
			e.setDept(this);
		}
	}

	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

	
	
	

}
