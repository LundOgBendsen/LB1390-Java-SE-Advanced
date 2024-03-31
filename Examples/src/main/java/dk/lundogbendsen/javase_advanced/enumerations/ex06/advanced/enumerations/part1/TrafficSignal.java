package dk.lundogbendsen.javase_advanced.enumerations.ex06.advanced.enumerations.part1;

import static java.lang.Math.abs;

public enum TrafficSignal {

	/* Enum values must be defined in the beginning of the enum body
	 * in this example each instance uses the constructor that takes a String argument
	 */
	RED("Stop"), YELLOW("Start engine"), GREEN("Go");

	/* Enums can have fields */
	String description;

	/* Enums can have constructors (that are automatically private) */
	TrafficSignal(final String description) {
		this.description = description;
	}

	/* Enums can even have methods */
	public boolean isNextTo(final TrafficSignal signal) {
		return abs(this.ordinal() - signal.ordinal()) == 1;
	}
}

class Main {
	public static void main(final String[] args) {
		System.out.println(TrafficSignal.RED.description);
		System.out.println(TrafficSignal.RED.isNextTo(TrafficSignal.YELLOW));
	}
}
