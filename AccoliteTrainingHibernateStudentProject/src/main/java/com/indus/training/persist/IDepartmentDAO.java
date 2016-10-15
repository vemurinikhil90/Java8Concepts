package com.indus.training.persist;

import com.indus.training.persist.entity.Department;
import com.indus.training.persist.exception.DepartmentPersistenceException;


public interface IDepartmentDAO {

	
	public Department findDepartmentById(Integer deptId)throws DepartmentPersistenceException;
	
	public void stringJoining();	
	
	
	
	
}
