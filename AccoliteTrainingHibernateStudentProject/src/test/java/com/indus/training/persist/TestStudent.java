package com.indus.training.persist;

import com.indus.training.persist.exception.StudentPersistenceException;

import com.indus.training.persist.impl.StudentDAOImpl;

import junit.framework.TestCase;

public class TestStudent extends TestCase {
	
	private StudentDAOImpl stdDao = null;


	protected void setUp() throws Exception {
		stdDao = new StudentDAOImpl();
	}

	protected void tearDown() throws Exception {
		stdDao = null;
	}

	public void testFindEmployeeById() {
				
		try {
			System.out.println(stdDao.getStudentDetailsById(1));
		} catch (StudentPersistenceException e) {
			e.printStackTrace();
		}
		
		
	}

}
