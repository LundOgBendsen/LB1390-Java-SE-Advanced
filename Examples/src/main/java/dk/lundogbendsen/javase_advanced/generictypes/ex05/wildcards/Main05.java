package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public class Main05 {

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

	static void insertSomeNumbers(List<? super Integer> list) {

		// NOT valid, the list could be a list of Number... or a list of Object
		// Integer i = list.get(0);

		// Safe
		Object o = list.get(0);

		// Also safe. It is perfectly fine to insert an Integer object
		// as it is a subtype to Object, Number or is of type Integer. In all cases, we satisfy the restrictions
		list.add(Integer.valueOf(12));

		Number n = Integer.valueOf(12);
		// NOT valid, as the list could be a list of Integer
		// list.add(n);
	}
}
