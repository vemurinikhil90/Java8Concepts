package com.indus.training.persist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import com.indus.training.persist.entity.Developer;

public class TestSort {
	private static List<Developer> createDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("Nikhil", new BigDecimal("70000"), 40));
		result.add(new Developer("Nikhil", new BigDecimal("60000"), 40));
		result.add(new Developer("Dileep", new BigDecimal("150000"), 45));
		result.add(new Developer("Anand", new BigDecimal("180000"), 31));
		result.add(new Developer("Karthik", new BigDecimal("60000"), 31));

		return result;

	}

	public static void printSorted(List<Developer> developerList, Comparator<Developer> comparator) {

		developerList.stream().sorted(comparator).forEach(System.out::println);
	}

	public static void main(String[] args) {

		List<Developer> developerList = createDevelopers();
		//String joining in Department Dao
		System.out.println("======================Before Sorting==========================================================================");
		System.out.println("====================");

		for (Developer developer : developerList) {
			System.out.println(developer);
		}
System.out.println("======================Now trying sorting thorugh Comparator comparing method-==========================================================================");
		System.out.println("---------------");
		System.out.println("Below code result shows that -- Here we are not executing sort method through collections.sort() but we are \n"
				+ "sorting through comparator we can add multiple ways of sorting through \n"
				+ " then Comparing based on already sorted by age collection");
		System.out.println("====================");
		printSorted(developerList,
				comparing(Developer::getAge)
				.thenComparing(Developer::getSalary)
										 );
System.out.println("==============================Other way to do it is below age sorting using sort and lambda expressions ===========================================================================");
		
		System.out.println("Using lambdas here we are doing sorting by our own hence\n"
				+ " reverse order of age");
		System.out.println("====================");
		developerList.sort((Developer dev1, Developer dev2) -> dev2.getAge() - dev1.getAge());
		developerList.forEach((developer) -> System.out.println(developer));
		
		System.out.println("==========================GroupingBy age and then listing people with that same age in groups===============================================================================");
		System.out.println(
				" Using grouping by ,collect, mapping -->>salaries of Nikhil 1,2 are different\n"
				+ " but we can do grouping by age and get the names into list and map them to age.");
		System.out.println("====================");
		
		System.out.println(
				developerList.stream()
				.collect(groupingBy(Developer::getAge, mapping(Developer::getName, toSet()))));

	}

}
