package dk.lundogbendsen.javase_advanced.enumerations.ex01.enumeration.basics;

/*
 * In a enum the values are defined in a comma separated list of all the legal values of the enum
 * 
 * A reference variable af the type TrafficSignal can only contain one of RED, GREEN or YELLOW
 */
public enum TrafficSignal {
	RED, 
	YELLOW,
	GREEN;
}

/*
 * In principle this is equivalent to code like this:
 * 
 * public enum TrafficSignal { public static final TrafficSignal RED = new
 * TrafficSignal(); public static final TrafficSignal YELLOW = new
 * TrafficSignal(); public static final TrafficSignal GREEN = new
 * TrafficSignal(); }
 * 
 */
