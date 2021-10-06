package dk.lundogbendsen.javase8advanced.nestedtypes.ex06.localinnerclass;

import java.util.Iterator;

public class TestLocalInnerClass {

	public static void main(final String[] args) {
		Sentence s = new Sentence(new String[] { "Hej", "med", "dig" });

		System.out.println("==<Traverserer iterate(1)>==");
		Iterator<String> i = s.iterate(1);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println();
		System.out.println("==<Traverserer iterate()>==");
		i = s.iterate();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
