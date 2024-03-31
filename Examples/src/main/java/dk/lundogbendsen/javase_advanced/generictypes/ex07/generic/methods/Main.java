/*
 * Illustrates the use of generic methods
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex07.generic.methods;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Integer i = 12;
		Double d = 12.2;

		// The compiler will guess the type using "type inference", as the two arguments have different types
		System.out.println(max(i, d));

		// You can also explicitly set the type using the dot notation
		System.out.println(Main.<Number>max(i, d));

		// This is useful if we want the emptyList() method to return a list of a specific type
		// The returned list will be List<String>
		System.out.println(Collections.<String>emptyList());
	}

	// This is an example of a generic method
	public static <N extends Number> N max(N first, N second) {
		// NB: The class Number defines a method doubleValue(), hence it is safe to use here
		if (first.doubleValue() > second.doubleValue()) {
			return first;
		} else {
			return second;
		}
	}

}
