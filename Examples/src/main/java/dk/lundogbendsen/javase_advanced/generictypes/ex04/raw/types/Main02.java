package dk.lundogbendsen.javase_advanced.generictypes.ex04.raw.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main02 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List words = new ArrayList();

		words.add("Hi"); // OK
		// NOT valid. Compiler will catch it
		// words.add(Integer.valueOf(12));

		// We wrap our List in a type safe proxy, that will enforce the type check.
		// Now, we get an exception on the insertion of the erroneous element
		// NB: it is still done at runtime, and not at compile time!
		List list = Collections.checkedList(words, String.class);

		oldMethod(list); // Execution will stop after this statement

		String word0 = (String) words.get(0);
		System.out.println(word0);
	}

	public static void oldMethod(List<Object> list) {
		list.add(Integer.valueOf(12)); // the proxy will throw a ClassCastException
	}
}
