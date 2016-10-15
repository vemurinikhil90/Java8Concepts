package com.indus.training.persist;
import java.util.*;

public class WhyLambda {
  public static void main(String[] args) {
    Thread th = new Thread(new Runnable() {    
    
    	/*Lambdas have backward Compatibility and here we are almost using it with java 1.1 code
    	Runnable is an interface and it has a method run() and we are passing Lambda to thread constructor
       	anonymous inner class is used  here for single line of code which is not needed..
    	One line of code wrapped up into a function called run and 
    	then wrapped that function into the anonymous inner class
*/   
      public void run() {
        System.out.println("In another thread");
      }
    }); 
    th.start();
    
 //Other way 
  	//Lambdas have backward Compatibility and here we are almost using it with java 1.1 code
	//it has a method run() and we are passing Lambda to thread constructor
//lambda function has only  parameter list and body of the function and it dont have name and return type 
      Thread threadObj = new Thread(() -> System.out.println("In another thread and Using Lambdas "));
     
      threadObj.start();
  
     
    System.out.println("In main Method");
  }
}