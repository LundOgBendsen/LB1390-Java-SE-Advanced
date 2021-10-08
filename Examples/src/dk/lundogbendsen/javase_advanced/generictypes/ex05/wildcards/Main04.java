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
		// Ikke tilladt, da vi ikke ved om c tillader indsættelse af Integers
		// c.add(new Integer(12));

		c.add(null);
	}

	static void insertSomeNumbers(Collection<? extends Number> c) {
		// Ikke tilladt, da vi ikke ved om c tillader indsættelse af Integers
		// c.add(new Integer(12));

		c.add(null);
	}
}
