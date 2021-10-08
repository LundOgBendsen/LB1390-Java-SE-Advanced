package dk.lundogbendsen.javase_advanced.enumerations.ex04.type.safety;

import static dk.lundogbendsen.javase_advanced.enumerations.ex04.type.safety.TrafficSignal.YELLOW;

public class Main {

	public static void main(final String[] args) {
		receiveSignal(YELLOW);
	}

	/*
	 * Enums can be used in a switch statement. This method will not be able to
	 * receive an illegal value (except null which will cause an NPE in the switch
	 * statement) It is possible to expand an enum though, so care must be taken to
	 * handle unknown values.
	 */
	public static void receiveSignal(final TrafficSignal signal) {
		switch (signal) {
		case RED:
			System.out.println("Stop");
			break;
		case YELLOW:
			System.out.println("Start engine");
			break;
		case GREEN:
			System.out.println("Go");
			break;
		default:
			assert false : "Unknown color";
			break;
		}
	}
}
