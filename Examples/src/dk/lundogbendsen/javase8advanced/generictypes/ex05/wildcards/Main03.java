package dk.lundogbendsen.javase8advanced.generictypes.ex05.wildcards;

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
		// Vi ønsker netop, at nedenstående *ikke* er lovligt
		// printCollection(cs);
	}

	static void printCollection(final Collection<? extends Number> c) {
		for (Number n : c)
			System.out.println(n);
	}
}
