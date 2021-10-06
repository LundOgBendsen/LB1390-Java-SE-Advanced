/*
 * En parameteriseret type som List<String> er selv en type, og kan bruges
 * som værdien på en typeparameter for en anden type.
 */

package dk.lundogbendsen.javase8advanced.generictypes.ex06.list.of.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(final String[] args) {

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
	}
}
