/*
 * Illustrates the problem when using raw types.
 * Old code (raw typed) will allow any object to be inserted, as the compiler loses its ability to check the types for us.
 * When we later on extract the inserted object, we will get a ClassCastException.
 * See a possible solution in Main02 
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex04.raw.types;

import java.util.ArrayList;
import java.util.List;

public class Main01 {

	public static void main(final String[] args) {

		ArrayList<String> words = new ArrayList<String>();

		words.add("Hi"); // OK
		// NOT valid, compiler will catch it!
		// words.add(Integer.valueOf(12));

		// We lose the compiler check when raw types are used!!
		oldMethod(words);

		String word0 = words.get(0);
		System.out.println(word0);

		String word1 = words.get(1); // sadly, a ClassCastException will be thrown
		System.out.println(word1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void oldMethod(final List list) { // a raw type is used
		list.add(Integer.valueOf(12)); // this is now allowed by the compiler, but we know it is a problem!
	}
}
