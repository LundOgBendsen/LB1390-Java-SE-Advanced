package dk.lundogbendsen.javase_advanced.collections.ex01.using;

/*
 * Shows how we can switch the implementation of the specific collection without changing the defined type.
 * Polymorphism in play.
 */

import java.util.Collection;
import java.util.LinkedList;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class UsingCollections {
	public static void main(final String[] args) throws Exception {
		// Feel free to switch the implementation
		Collection<Person> col = new LinkedList<Person>();
		// Collection<Person> col = new ArrayList<Person>();
		// Collection<Person> col = new HashSet<Person>();
		// Collection<Person> col = new TreeSet<Person>();

		System.out.println("Current type of our collection: " + col.getClass().getName());

		System.out.println("\nInserting 3 persons in col");
		col = Person.fillCollection(3, col);
		System.out.println(col);

		Person p1 = Person.getRandom();
		col.add(p1);
		System.out.println("\nAdding a new person p1 = " + p1);
		System.out.println(col);

		Person p2 = p1.clone();
		col.add(p2);
		System.out.println("\nAdding a clone of p1 col");
		System.out.println(col);

		col.remove(p1);
		System.out.println("\nRemoving p1");
		System.out.println(col);
	}
}