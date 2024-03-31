package dk.lundogbendsen.javase_advanced.generictypes.ex01.using.generic.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(final String[] args) {

		// We define a list of Strings
		// The type-parameter <String> is set on both the declaration and
		// instantiation/initialisation side
		ArrayList<String> wordList = new ArrayList<String>();

		// It is now perfectly permissible to add a String to the list
		wordList.add("Hi");

		// While below statement will give you compile errors (try it out!)
		// wordList.add(12);

		// When we get an object from the list, there is no need to downcast...
		// The compiler already knows, it is a String
		String firstWord = wordList.get(0);

		System.out.println(firstWord);

		// Other data structures has multiple argument parameterisation
		Map<String, Integer> weekDays = new HashMap<String, Integer>();
		weekDays.put("Monday", 1); // NB: Auto-boxing is in play here, generics cannot handle primitive types
		weekDays.put("Tuesday", 2);
		weekDays.put("Wednesday", 3);
		weekDays.put("Thursday", 4);
		weekDays.put("Friday", 5);
		weekDays.put("Saturday", 6);
		weekDays.put("Sundag", 7);

		int indexForThursday = weekDays.get("Thursday"); // NB: Auto-unboxing is in play here
		System.out.println("Weekday for Thursday: " + indexForThursday);
	}
}
