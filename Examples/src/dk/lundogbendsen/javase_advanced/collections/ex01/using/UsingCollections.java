package dk.lundogbendsen.javase_advanced.collections.ex01.using;

/*
 * Viser vi kan bruge forskellige implementationer af interfacet
 * Collection - uden at skulle ændre i koden mere end lige netop
 * det sted, hvor vi laver den konkrete Collection.
 *
 * Collections kan altså bruges polymorfisk.
 */

import java.util.Collection;
import java.util.TreeSet;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class UsingCollections {
	public static void main(final String[] args) throws Exception {
		// Vi kan frit vælge een af nedenstående linier
		// og pga. polymorfi (vi bruger kun supertypen Collection)
		// behøver vi ikke ændre andre steder.

		// Collection<Person> col = new LinkedList<Person>();
		// Collection<Person> col = new ArrayList<Person>();
		// Collection<Person> col = new HashSet<Person>();
		Collection<Person> col = new TreeSet<Person>();
		// Collection<Person> col = new Vector<Person>(); // bør ikke bruges længere

		System.out.println("Ved denne kørsel er col af typen: " + col.getClass().getName());

		System.out.println("\nFylder tre tilfældige personer i col");
		col = Person.fillCollection(3, col);
		System.out.println(col);

		Person p1 = Person.getRandom();
		col.add(p1);
		System.out.println("\nTilføjer en ny person p1 = " + p1);
		System.out.println(col);

		Person p2 = p1.clone();
		col.add(p2);
		System.out.println("\nTilføjer en klon af p1 kaldet p2 til col");
		System.out.println(col);

		col.remove(p1);
		System.out.println("\nFjerner personen p1 = " + p1);
		System.out.println(col);
	}
}