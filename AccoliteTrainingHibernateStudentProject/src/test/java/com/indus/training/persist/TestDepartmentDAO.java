package com.indus.training.persist;

//import java.util.HashSet;
//import java.util.Set;

import com.indus.training.persist.IDepartmentDAO;
//import com.indus.training.persist.entity.Department;
//import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.DepartmentPersistenceException;
import com.indus.training.persist.impl.DepartmentDAO;

import junit.framework.TestCase;

public class TestDepartmentDAO extends TestCase {

	private IDepartmentDAO deptObj=null;
	
	protected void setUp() throws Exception {
		deptObj=new DepartmentDAO();
	}

	protected void tearDown() throws Exception {
		deptObj=null;
		
	}

	public void testDepartmentTestCase(){
		
		
		try {
			
			
			System.out.println(deptObj.findDepartmentById(10));
			
			//String joining java 8
			deptObj.stringJoining();
			
			
			
			/*Department deprtmnt=deptObj.findDepartmentById(10);
			
			System.out.println(deprtmnt);
			
			Set<Employee> employees = deprtmnt.getEmployees() ;
			for(Employee employee :employees ){
				//System.out.println(employee);
			}*/
		
		} catch (DepartmentPersistenceException e) {
			e.printStackTrace();
		}
		
		
	}
}
