package com.indus.training.persist.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.indus.training.persist.IEmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.util.HibernateUtil;

public class EmployeeDAO implements IEmployeeDAO {

	public Employee findEmployeeById(Integer empId) {

		Employee empEntity = null;

		Session orclSessionObj = HibernateUtil.getSessionFactory().openSession();

		Transaction orclEmpTrnsObj = orclSessionObj.getTransaction();

		try {
			orclEmpTrnsObj.begin();

			empEntity = (Employee) orclSessionObj.get(Employee.class, empId);

			orclEmpTrnsObj.commit();

		} catch (Exception ex) {
			orclEmpTrnsObj.rollback();
		} finally {
			orclSessionObj.close();
		}

		return empEntity;
	}

	public List<Employee> listEmployees() {
		List<Employee> listEmpObj = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listEmpObj = session.createQuery("FROM Employee").list();
			listEmpObj.forEach(i -> System.out.println(i.toString()));
			System.out.println("-----Printed  list of employeesSuccessfully -----");
			System.out.println("-----Before using streams on list of employees");
			listEmpObj.stream().filter(e -> e.getSalary() >= 5000);
			System.out.println("-----After using streams on list of employees");
			System.out.println(listEmpObj.toString());
			
			System.out.println("Parameter as a target");
			
			//passing parameter as a target ..became a target on which you are calling a method..
			listEmpObj.stream().map(e->e.toString());

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listEmpObj;
	}

	public void toShowTrywithResources() {
		try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/TryWithResources.txt"));
				FileWriter file = new FileWriter("./src/main/resources/EmptyFile.txt", true);
				BufferedWriter bw = new BufferedWriter(file);) 
		 {
			// Resource leak: 'br' is never closed if not using jdk 7 try with resources
//java.io.autoclosable interface is being implemented by  
//all io  like file writer,reader buffer reader etc and thus  resources will be treated auto closable.
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				builder.append(line);
				bw.append(builder);
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void testMethodReferences(){
	
		System.out.println("Recieved a value and simply passing value through lambda expressions.");
		List<Integer> numbersListObj=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		numbersListObj.forEach((value) ->System.out.println(value));
		//we are receiving an argument we just want to pass through without altering it.
		//passing an argument to the function not invoking the function
		numbersListObj.forEach(System.out::println);
		
		System.out.println("Passing Parameters as an argument to static method");
		numbersListObj.stream()
				.map(e->String.valueOf(e)) //valueOf is a static Method
				.forEach(System.out::println);
		
		//passing parameter as a target can be seen in list employees method..
		
		
		
		System.out.println("--------using streams,filter,maptoDouble-------");
	System.out.println(
			numbersListObj.stream()
					.filter(e-> e%2==0) //filter takes predicate functional interface and predicate.test()
					.mapToDouble(e->e*2.0) 		
		//map transform values  no of output =number of inputs  no of ppl no of names example
		//getting input values of even numbers in integers and transforming them into double values after doubling them...
					.sum());  //sum,average,count are some of the reduction methods
	 
	/* System.out.println(
			 numbersListObj.stream()
		             .filter(e -> e % 2 == 0)
		             .map(e -> e * 2.0)
		             .reduce(0.0, (carry, e) -> carry + e));*/
    //0.0 is intial value taken by reduce  and what ever element comes 
	//in the stream first it takes and does addition operation and the result is going to be input of the  next operation  
		
		System.out.println("earlier");
		int result=0;
		for (int e:numbersListObj){
			if(e%2==0){
				result+=e*2;
			}
			System.out.println(result);
		}
		
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");
			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
	
	}
	
	
}