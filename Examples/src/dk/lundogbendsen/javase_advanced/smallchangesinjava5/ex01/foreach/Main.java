/*
 * Kan iterere over alle elementer i:
 * - et array
 * - en Collection (subtype af Iterable)
 * - en subtype af java.lang.Iterable (signallerer man har en metode kaldet
 * iterator(), der returnerer en subtype af Iterator-interfacet).
 *
 * Arrayets type eller den generiske type af Iterable skal være
 * tildelingskompatibel med loop-variablen, der erklæres i løkken.
 * Hvis man bruger "gamle" raw types skal variablens type være java.lang.Object.
 *
 * Loop-variablen *må* erklæres final (dvs. den ikke kan ændres i løkkens body).
 *
 * Loop-variablen *skal* erklæres som en del af foreach-løkken (og ikke før),
 * hvorfor variablens slutværdi ikke er tilgængelig.
 *
 * Man kan ikke vide, om man er ved første og/eller sidste loop (hvilket fx gør
 * det umuligt at udskrive en kommasepareret liste).
 *
 * Den Iterator, der bruges af foreach-løkken kan man ikke få fat i en reference
 * til, hvorfor det fx ikke er muligt at kalde Iterator.remove() på den.
 */
package dk.lundogbendsen.javase_advanced.smallchangesinjava5.ex01.foreach;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

	public static void main(final String[] args) {

		// *********************************************************************
		// * Iterer over array
		// *********************************************************************

		int[] intArray = new int[] { 2, 4, 6, 8, 10 };

		System.out.print("Iterate intArray: ");
		for (int currentInt : intArray) {
			System.out.print(currentInt + " ");
		}
		System.out.println();

		// *********************************************************************
		// * Iterer over collection
		// *********************************************************************

		Collection<String> collection = new ArrayList<>();
		collection.add("hej");
		collection.add("med");
		collection.add("dig");

		System.out.print("Iterate collection: ");

		for (String o : collection) {
			System.out.print(o + " ");
		}
		System.out.println();

		// *********************************************************************
		// * Iterer over egen Iterable type
		// *********************************************************************

		RandomNumberGenerator iterable = new RandomNumberGenerator(6);

		System.out.print("Iterate iteratable: ");
		for (int o : iterable) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
}
