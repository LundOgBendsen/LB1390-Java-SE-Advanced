/*
 * Enumerated types (enums) er en ny kategori af reference-typer.
 * En enum definerer en endelig mængde af værdier på en typestærk måde, dvs. at
 * en variabel med enum'en som type *kun* vil kunne referere til en af de
 * enum-instanser, der er i en opstillede mængde af instanser (eller null).
 */
package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex01.enumeration.basics;

public class Main {

	public static void main(String[] args) {

		// Metoderne name() og toString() returnerer navnet på en enum-konstant.
		// Forskellen på name() og toString() er, at name() er final, og derfor
		// altid returnerer netop navnet på enum-konstanten. Metoden toString
		// derimod kan overrides, så den returnerer en mere sigende streng.
		System.out.println(TrafficSignal.RED.toString());
		System.out.println(TrafficSignal.RED.name());

		// Enum-værdier tilgås som almindelige konstante i en klasse.
		TrafficSignal trafficLight = TrafficSignal.RED;

		// Man kan lave switch på en enum type (virkede tidligere kun på ints).
		switch (trafficLight) {
		case RED:
			System.out.println("Stop");
			break;
		case YELLOW:
			System.out.println("Gas op");
			break;
		case GREEN:
			System.out.println("Kør");
			break;
		default:
			assert false : "Unknown color";
			break;
		}

		// Man kan vha. Enum.valueOf() få fat i en Enum-værdi udfra en String!
		// NB: Er case-sensitive (kaster evt. IllegalArgumentException).
		System.out.println(TrafficSignal.RED == TrafficSignal.valueOf("RED"));

		// Man kan få fat i et array med alle enum-værdier i en enum.
		// Kommer ud i den rækkefølge, hvor de er defineret.
		TrafficSignal[] signals = TrafficSignal.values();
		System.out.print("|");
		for (TrafficSignal current : signals) {
			System.out.print(current + "|"); // |RED|YELLOW|GREEN|
		}
		System.out.println();

		// Man kan få fat i index-pladsen for en Enum-værdi (startende fra 0).
		// Index-tallene svarer til rækkefølgen enum-konstantene er defineret i.
		// Ordinal betyder i øvrigt ordenstal på dansk.
		System.out.println(TrafficSignal.RED.ordinal()); // 0
		System.out.println(TrafficSignal.YELLOW.ordinal()); // 1
		System.out.println(TrafficSignal.GREEN.ordinal()); // 2

		// Alle enums er subtyper af klassen java.lang.Enum (som ikke kan
		// subtypes vha. almindelige klasser).
		System.out.println(TrafficSignal.RED instanceof Enum); // true
	}
}
