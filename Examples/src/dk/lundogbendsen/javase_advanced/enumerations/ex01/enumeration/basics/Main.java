/**
 * Enumerated types (enums) is a category of reference-types. 
 * An enum defines a set of typed, constant values. E.g. a variable of an enum
 * type will only be able to contain an instance of the enum.
 */
package dk.lundogbendsen.javase_advanced.enumerations.ex01.enumeration.basics;

public class Main {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {

		/*
		 * The methods name() and toString() returns a String representation of an enum instance.
		 * The difference is that name() is final and always returns the NAME of the enum
		 * but toString() can be overridden to return a more descriptive String.
		 */
		System.out.println(TrafficSignal.RED.toString());
		System.out.println(TrafficSignal.RED.name());

		/* Enum-values are referenced just like ordinary constants */		
		TrafficSignal trafficLight = TrafficSignal.RED;

		/* Enums can be converted from a String using Enum.valueOf() Note: case sensitive */
		System.out.println(TrafficSignal.RED == TrafficSignal.valueOf("RED"));

		/* Enum.values() returns an array with all values of the enum in the order they were defined */
		TrafficSignal[] signals = TrafficSignal.values();
		System.out.print("|");
		for (TrafficSignal current : signals) {
			System.out.print(current + "|"); // |RED|YELLOW|GREEN|
		}
		System.out.println();

		/* Enum.ordinal() returns the index of an enum in the order the enums were defined */
		System.out.println(TrafficSignal.RED.ordinal()); // 0
		System.out.println(TrafficSignal.YELLOW.ordinal()); // 1
		System.out.println(TrafficSignal.GREEN.ordinal()); // 2

		/* All enums are subtypes of java.lang.Enum (whish cannot be subtyped using "class extends") */
		Object o = TrafficSignal.RED;
		System.out.println(o instanceof Enum<?>); // true
	}
}
