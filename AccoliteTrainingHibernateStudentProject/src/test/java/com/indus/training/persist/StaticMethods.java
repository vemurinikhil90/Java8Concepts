package com.indus.training.persist;
//import java.util.*;

	interface Util {
	  public static int numberOfCores() {
	    return Runtime.getRuntime().availableProcessors();
	    //available processors Returns the number of processors available to the Java virtual machine. 
	    //Even though I have 2 cores it returns 4 because I have 4 threads by default can be created...
	    //even when you see TestParallelStreams you will see 4 values get executed at a time... because of 4 threads..
	 //http://ark.intel.com/products/81015/Intel-Core-i7-4510U-Processor-4M-Cache-up-to-3_10-GHz
	  }
	}

	public class StaticMethods {
	  public static void main(String[] args) {
	    System.out.println(Util.numberOfCores());
	  }
	}
