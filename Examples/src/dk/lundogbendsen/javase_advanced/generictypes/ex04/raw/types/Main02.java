/*
 * Illustrerer løsning på problemet i Main01. Dvs. den der *indsætter* noget
 * ulovligt i listen får fejlen (og *ikke* den der tager de ulovlige ud).
 */
package dk.lundogbendsen.javase_advanced.generictypes.ex04.raw.types;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main02 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Vector<String> words = new Vector<String>();

		words.add("Hej"); // OK
		// Ulovligt - fanges af kompileren
		// words.add(Integer.valueOf(12));

		// Vi mister kompilerchecket på, at der kun puttes Strings i vores
		// Vector, når vi bruger Vector som en raw type. Derfor wrapper vi
		// den i en List-proxy, der under kørsel checker, at der kun puttes
		// de rigtige ting i Vector'en.
		List list = Collections.checkedList(words, String.class);

		oldMethod(list);

		String word0 = words.get(0);
		System.out.println(word0);

		String word1 = words.get(1); // giver ClassCastException
		System.out.println(word1);
	}

	public static void oldMethod(List<Object> list) {
		list.add(Integer.valueOf(12)); // her får vi ClassCastException
	}
}
