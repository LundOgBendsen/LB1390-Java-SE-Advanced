package dk.lundogbendsen.javase8advanced.generictypes.ex05.wildcards;

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
		// Ikke tiladt, da vi ikke ved om c tillader indsættelse af Integers
		// c.add(new Integer(12));

		c.add(null);
	}

	// Betyder, at listen vi får ind skal være en List af Integer-objekter eller
	// en liste indeholdende en supertype af integer-objekter
	static void insertSomeNumbers(List<? super Integer> list) {

		// Ikke tilladt, da list kunne være en List<Number>
		// Integer i = list.get(0);

		// Tilladt
		Object o = list.get(0);

		// Tilladt, da vi ved at list må indeholde Integer-objekter
		list.add(new Integer(12));

		Number n = new Integer(12);
		// Ikke tilladt, da list fx kunne være en List<Integer>
		// list.add(n);
	}
}
