package com.indus.training.persist.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//import /*static*/ java.util.stream.Collectors.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.indus.training.persist.IDepartmentDAO;
import com.indus.training.persist.entity.Department;
import com.indus.training.persist.util.HibernateUtil;


public class DepartmentDAO implements IDepartmentDAO {

	public Department findDepartmentById(Integer deptId) {

		Department deptEntity = null;

		Session orclSessionObj = HibernateUtil.getSessionFactory().openSession();

		Transaction orclDeptTrnsObj = orclSessionObj.getTransaction();

		try {
			orclDeptTrnsObj.begin();

			deptEntity = (Department) orclSessionObj.get(Department.class, deptId);

			orclDeptTrnsObj.commit();
			
		} catch (Exception ex) {
			orclDeptTrnsObj.rollback();
		
		}finally{
			
			orclSessionObj.close();
			
		}

		return deptEntity;
	}
public void stringJoining(){
	
	List<String> names=Arrays.asList("Dileep","Anand","Zakir","Vishal");
	System.out.println(names.stream()
							.map(String::toUpperCase)
							.collect(Collectors.joining(",")));
	//collect is a reduce operator in this case and performing mutable reduction
	//import static java.util.stream.Collectors.*;  
	//need to import this class Collectors class has functions like joining
	//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
}
	
	
}

