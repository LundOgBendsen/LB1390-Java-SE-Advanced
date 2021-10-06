package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex04.common.methods;

// Vi laver static import af alle enumerated types (konstante)
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex04.common.methods.TrafficSignal.GREEN;
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex04.common.methods.TrafficSignal.RED;
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex04.common.methods.TrafficSignal.YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.System.out;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {

		TrafficSignal signal01 = RED;
		TrafficSignal signal02 = YELLOW;
		TrafficSignal signal03 = GREEN;

		// Deserialisering håndterer enums specielt, så der aldrig bliver lavet
		// dubletter af en enum-værdi. Desuden kan man ikke clone en enum-værdi.
		out.println(signal01 == RED); // true (ALTID)

		// equals: er final i enums, og er baseret på ==
		out.println(signal02.equals(YELLOW)); // true (ALTID)
		out.println(signal02.equals(GREEN)); // false (ALTID)

		// hashCode: er final i enums, og er baseret på objekt-identitet
		out.println(identityHashCode(RED) == RED.hashCode()); // true (ALTID)

		// toString: kan overrides, men returnerer som default navnet på
		// værdien (fx "RED" for TrafficLight.RED)
		out.println(RED); // "RED"
		out.println(signal03); // "GREEN"

		// compareTo: enums implementerer Comparable og bruger en sortering
		// svarende til den rækkefølge, som værdierne i enum'en er skrevet på.
		SortedSet<TrafficSignal> set = new TreeSet<>();
		set.add(YELLOW);
		set.add(GREEN);
		set.add(RED);
		out.println(set);
	}
}
