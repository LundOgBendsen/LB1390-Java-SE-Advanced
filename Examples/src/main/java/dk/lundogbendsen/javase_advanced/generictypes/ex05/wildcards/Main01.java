/*
 * Illustrates the problem with having general methods
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main01 {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		List<Integer> integerList = new ArrayList<Integer>(10);
		// NOT valid, List<Integer> it not a subtype of List<Object>
		// printCollection(integerList);

		Collection<String> stringList = new ArrayList<String>();
		// NOT valid, List<String> it not a subtype of List<Object>
		// printCollection(stringList);
	}

	static void printCollection(final Collection<Object> c) {
		for (Object o : c) {
			System.out.println(o);
		}
	}
}
