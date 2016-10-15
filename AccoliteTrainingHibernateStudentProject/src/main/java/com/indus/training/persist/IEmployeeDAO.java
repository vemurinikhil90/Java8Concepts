package com.indus.training.persist;

import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistenceException;
//@FunctionalInterface //Only one abstract method allowed
public interface IEmployeeDAO {

	public Employee findEmployeeById(Integer empNo)throws EmployeePersistenceException;
	
	public List<Employee> listEmployees();
	
}
