package dk.lundogbendsen.javase_advanced.collections.ex05.iterators;

/*
 * Shows how the Iterator interface can be used
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class UsingIterator {
	public static void main(final String[] args) {
		Collection<Person> col = new LinkedList<>();

		System.out.println("Vi fylder tre personer i col");
		col = Person.fillCollection(3, col);
		System.out.println(col);

		System.out.println("\nVi laver en Iterator kaldet iterator");
		Iterator<Person> iterator = col.iterator();

		System.out.println();
		System.out.print("iterator.hasNext() giver: ");
		System.out.println(iterator.hasNext());

		System.out.println();
		System.out.print("iterator.next() giver: ");
		System.out.println(iterator.next());

		System.out.println();
		System.out.print("Vi kalder iterator.remove()");
		iterator.remove();

		System.out.println();
		System.out.println("col har nu følgende elementer: ");
		System.out.println(col);
	}
}