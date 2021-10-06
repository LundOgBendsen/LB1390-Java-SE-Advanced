/*
 * Et driverprogram til ObservableList
 */
package dk.lundogbendsen.javase8advanced.designpatterns.lab01.observer.nongeneric;

import java.util.ArrayList;
import java.util.List;

public class ObservableListClient {

	public static void main(final String[] args) {
		ArrayList<String> al = new ArrayList<>();

		// få en observablelist
		ObservableList<String> ol = ObservableListFactory.getInstanceTheDecoratorWay(al);

		// registrer 2 lyttere
		ol.registerObserver(() -> System.out.println("1: Observer er blevet kaldt!"));
		ol.registerObserver(() -> System.out.println("2: Observer er blevet kaldt!"));

		// Få en proxy for listen. Bemærk, at vi ikke kan
		// se at det reelt er en observablelist, da typen er
		// java.util.List
		List<String> l = ObservableListFactory.getInstanceTheProxyWay(al);

		// manipulér listen, hvorved observers notificeres
		l.add("hej med dig!");
		ol.clear();
	}
}
