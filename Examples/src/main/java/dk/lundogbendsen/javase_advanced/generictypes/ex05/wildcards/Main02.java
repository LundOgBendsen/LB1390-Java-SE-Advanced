/*
 * Illustrates the problem with having general methods
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main02 {

	public static void main(final String[] args) {
		List<Integer> integerList = new ArrayList<Integer>(10);
		integerList.add(7);
		// Valid, the method now expects a collection of unknown type
		printCollection(integerList);

		Collection<String> stringList = new ArrayList<String>();
		stringList.add("Hi");
		// Valid, the method now expects a collection of unknown type
		printCollection(stringList);
	}

	static void printCollection(final Collection<?> c) {
		// NB: All elements will be upcasted to Object
		for (Object o : c) {
			System.out.println(o);
		}
	}
}
