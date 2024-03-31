package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main04 {

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>(10);
		insertSomeObjects(integerList);
		insertSomeNumbers(integerList);
	}

	static void insertSomeObjects(Collection<?> c) {
		// NOT valid, as we can not safely insert an Integer, as the collection could be a collection of ANY type
		// c.add(new Integer(12));

		c.add(null);
	}

	static void insertSomeNumbers(Collection<? extends Number> c) {
		// NOT valid, as we can not safely insert an Integer, as the collection could be a collection of ANY type that extends Number, e.g. List<Double)
		// c.add(new Integer(12));

		for (Number n : c) {
			System.out.println(n); // Perfectly valid, as we know that all elements are of type Number or a subtype of Number
		}

		c.add(null);
	}
}
