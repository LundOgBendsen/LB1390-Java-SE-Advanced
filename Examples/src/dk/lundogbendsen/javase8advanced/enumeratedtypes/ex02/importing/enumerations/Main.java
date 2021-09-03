/*
 * Enums bruges ofte sammen med static imports.
 */
package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex02.importing.enumerations;

// Vi laver static import af alle enumerated types (konstante).
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex02.importing.enumerations.TrafficSignal.GREEN;
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex02.importing.enumerations.TrafficSignal.RED;
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex02.importing.enumerations.TrafficSignal.YELLOW;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		TrafficSignal ts1 = RED;
		TrafficSignal ts2 = YELLOW;
		TrafficSignal ts3 = GREEN;
	}
}
