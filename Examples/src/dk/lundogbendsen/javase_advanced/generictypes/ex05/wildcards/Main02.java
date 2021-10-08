/*
 * Illustrerer et problem med at definere generelle metoder.
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main02 {

	public static void main(final String[] args) {
		List<Integer> integerList = new ArrayList<Integer>(10);
		integerList.add(7);
		// Lovligt, da metoden forventer en samling af ukendt type
		printCollection(integerList);

		Collection<String> stringList = new ArrayList<String>();
		stringList.add("ha");
		// Lovligt, da metoden forventer en samling af ukendt type
		printCollection(stringList);
	}

	static void printCollection(final Collection<?> c) {
		// Bemærk at de ting vi tager ud af listen er upcastet til Object-typen.
		for (Object o : c)
			System.out.println(o);
	}
}
