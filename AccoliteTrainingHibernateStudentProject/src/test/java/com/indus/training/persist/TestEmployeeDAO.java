package com.indus.training.persist;

import java.util.List;
import java.util.stream.Collectors;

import com.indus.training.persist.entity.Employee;
//import com.indus.training.persist.entity.Department;
//import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.impl.EmployeeDAO;

import junit.framework.TestCase;

public class TestEmployeeDAO extends TestCase {
	
	private EmployeeDAO empDao = null;


	protected void setUp() throws Exception {
		empDao = new EmployeeDAO();
	}

	protected void tearDown() throws Exception {
		empDao = null;
	}

	public void testFindEmployeeById() {
		
		
		System.out.println(empDao.findEmployeeById(100));
		
		List<Employee> empListObj=empDao.listEmployees();
		System.out.println("-----Using method reference feature of Java 8-----");
		empListObj.forEach(System.out::println);
		
		empDao.toShowTrywithResources();
		
		empDao.testMethodReferences();
		
	
	}

}
