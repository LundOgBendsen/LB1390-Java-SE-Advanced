/*
 * Illustrerer problemet ved at bruge raw types, nemligt at "gammel" kode
 * kan indsætte ulovlige ting i en typestærk liste, hvorfor det bliver den kode,
 * der tager den ulovlige ting ud af listen, der får fejlen.
 * Se løsningen i Main02.
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex04.raw.types;

import java.util.ArrayList;
import java.util.List;

public class Main01 {

	public static void main(final String[] args) {

		ArrayList<String> words = new ArrayList<String>();

		words.add("Hej"); // OK
		// Ulovligt - fanges af kompileren
		// words.add(Integer.valueOf(12));

		// Vi mister kompilerchecket på, at der kun puttes Strings i vores
		// ArrayList, når vi bruger ArrayList som en raw type
		oldMethod(words);

		String word0 = words.get(0);
		System.out.println(word0);

		String word1 = words.get(1); // giver ClassCastException
		System.out.println(word1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void oldMethod(final List list) {
		list.add(Integer.valueOf(12)); // her er der ingen problemer!!!
	}
}
