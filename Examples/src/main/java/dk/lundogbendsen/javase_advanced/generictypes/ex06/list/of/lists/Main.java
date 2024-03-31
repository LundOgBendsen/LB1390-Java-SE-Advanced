/*
 * A parameterised type, e.g. List<String> is considered a type, hence it can used as a value for another
 * parameterised type.
 */

package dk.lundogbendsen.javase_advanced.generictypes.ex06.list.of.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(final String[] args) {

		// Map<K, V>, here the parameterised type V is set to be a List<String>
		// The List interface is also parameterised List<E>, where E is set to be the type String
		Map<String, List<String>> dkToUk = new HashMap<String, List<String>>();

		List<String> wordList01 = new ArrayList<String>();
		wordList01.add("shout");
		wordList01.add("scream");
		wordList01.add("yell");
		wordList01.add("bellow");
		dkToUk.put("råbe", wordList01);

		List<String> wordList02 = new ArrayList<String>();
		wordList02.add("high");
		wordList02.add("tall");
		wordList02.add("loud");
		dkToUk.put("høj", wordList02);

		System.out.println(dkToUk);

		@SuppressWarnings("unused")
		List<String> translation = dkToUk.get("råbe"); // Notice the return type of the get() method
	}
}
