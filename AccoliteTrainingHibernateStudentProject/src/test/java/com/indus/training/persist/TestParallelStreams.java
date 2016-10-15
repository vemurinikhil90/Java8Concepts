package com.indus.training.persist;

import java.util.*;
import java.util.concurrent.*;

public class TestParallelStreams {
	public static int doubleIt(int number) {
		try {
			Thread.sleep(1000);
			//Taking time for 1 second indicates not only sleep time but also the number of numbers being processed indicates number of cores in your system and no of threads in your system /n. "
			//we can also change the number of threads that are to be created
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("doubleIt called for " + number);
		return number * 2;
	}



	public static void main(String[] args) throws InterruptedException {
		boolean useForkJoin = true;      //True;

		if (useForkJoin) {
			ForkJoinPool pool = new ForkJoinPool(50);
			pool.submit(TestParallelStreams::run);
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.MINUTES);
		} else {
			run();
		}
	}

	public static void run() {
		List<Integer> numbersListObj = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		System.out.println(numbersListObj.parallelStream().map(TestParallelStreams::doubleIt).reduce(0, Integer::sum));
	}
}
