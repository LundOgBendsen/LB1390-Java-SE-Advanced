package dk.lundogbendsen.javase_advanced.enumerations.ex05.common.methods;

import static dk.lundogbendsen.javase_advanced.enumerations.ex05.common.methods.TrafficSignal.GREEN;
import static dk.lundogbendsen.javase_advanced.enumerations.ex05.common.methods.TrafficSignal.RED;
import static dk.lundogbendsen.javase_advanced.enumerations.ex05.common.methods.TrafficSignal.YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.System.out;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(final String[] args) throws Exception {

		TrafficSignal signal01 = RED;
		TrafficSignal signal02 = YELLOW;
		TrafficSignal signal03 = GREEN;

		/*
		 * Java ensures that there is only one instance of each enum value - even during
		 * deserialization so the following will always be true:
		 */
		out.println(signal01 == RED);

		/* equals() still works and is final */
		out.println(signal02.equals(YELLOW)); // true
		out.println(signal02.equals(GREEN)); // false

		/* hashCode() is final and based on object identity */
		out.println(identityHashCode(RED) == RED.hashCode()); // true

		/* toString() can be overridden but returns the name of the enum as default */
		out.println(RED); // "RED"
		out.println(signal03); // "GREEN"

		/*
		 * compareTo: enums implement Comparable using the ordinal (definition order)
		 * value of the enums
		 */
		SortedSet<TrafficSignal> set = new TreeSet<>();
		set.add(YELLOW);
		set.add(GREEN);
		set.add(RED);
		out.println(set);
	}
}
