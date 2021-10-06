package dk.lundogbendsen.javase8advanced.generictypes.ex01.using.generic.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(final String[] args) {

		// Vi erklærer en liste af Strings (type-parameteren <String> gives til
		// både referencevariablen og til objektet).
		ArrayList<String> wordList = new ArrayList<String>();

		// Der er nu lovligt at tilføje Strings til listen
		wordList.add("Hej");

		// Det giver *kompilefejl* at tilføje andet end Strings til listen
		// wordList.add(12);

		// Når vi piller elementer ud af listen slipper vi for at downcaste
		String firstWord = wordList.get(0);

		System.out.println(firstWord);

		// Nogle generiske typer forventer flere type-parametre.
		// Listen adskilles af komma.
		Map<String, Integer> weekDays = new HashMap<String, Integer>();
		weekDays.put("mandag", 1); // Vi bruger autoboxing
		weekDays.put("tirsdag", 2);
		weekDays.put("onsdag", 3);
		weekDays.put("torsdag", 4);
		weekDays.put("fredag", 5);
		weekDays.put("lørdag", 6);
		weekDays.put("søndag", 7);

		int indexForTorsdag = weekDays.get("torsdag"); // Auto-unboxing
		System.out.println("Torsdag er dag nr: " + indexForTorsdag);
	}
}
