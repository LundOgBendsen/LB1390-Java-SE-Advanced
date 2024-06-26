package dk.lundogbendsen.javase_advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main03 {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		List<Integer> li = new ArrayList<Integer>(10);
		printCollection(li);

		List<Long> ll = new ArrayList<Long>();
		printCollection(ll);

		Collection<String> cs = new ArrayList<String>();
		// NOT valid, a collection of strings is not a collection of Number or subtype of Number
		// printCollection(cs);
	}

	static void printCollection(final Collection<? extends Number> c) {
		// NB: this ensure that all elements in the list are of type Number or a subtype of Number
		for (Number n : c) {
			System.out.println(n);
		}
	}
}
