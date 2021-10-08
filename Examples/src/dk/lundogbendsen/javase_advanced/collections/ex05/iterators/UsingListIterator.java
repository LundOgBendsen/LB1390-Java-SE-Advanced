package dk.lundogbendsen.javase_advanced.collections.ex05.iterators;

/*
 * Viser hvordan ListIterator-interfacet kan bruges
 */
import java.util.*;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class UsingListIterator {
	public static void main(String[] args) {
		Collection<Person> col = new LinkedList<>();

		System.out.println("Vi fylder tre personer i col");
		col = Person.fillCollection(3, col);
		System.out.println(col);

		System.out.println("\nVi laver en ListIterator kaldet iterator");
		ListIterator<Person> iterator = ((List<Person>) col).listIterator();

		System.out.println();
		System.out.print("iterator.hasNext() giver: ");
		System.out.println(iterator.hasNext());

		System.out.print("iterator.hasPrevious() giver: ");
		System.out.println(iterator.hasPrevious());

		System.out.print("iterator.next() giver: ");
		System.out.println(iterator.next());

		System.out.println();
		System.out.print("iterator.hasNext() giver: ");
		System.out.println(iterator.hasNext());

		System.out.print("iterator.hasPrevious() giver: ");
		System.out.println(iterator.hasPrevious());

		System.out.print("iterator.next() giver: ");
		System.out.println(iterator.next());

		System.out.println();
		System.out.print("iterator.hasNext() giver: ");
		System.out.println(iterator.hasNext());

		System.out.print("iterator.hasPrevious() giver: ");
		System.out.println(iterator.hasPrevious());

		System.out.print("iterator.previous() giver: ");
		System.out.println(iterator.previous());

		System.out.println();
		System.out.print("iterator.hasNext() giver: ");
		System.out.println(iterator.hasNext());

		System.out.print("iterator.hasPrevious() giver: ");
		System.out.println(iterator.hasPrevious());

		System.out.print("iterator.previous() giver: ");
		System.out.println(iterator.previous());

		System.out.println();
		System.out.print("Vi kalder iterator.remove()");
		iterator.remove();

		System.out.println();
		System.out.println("col har nu følgende elementer: ");
		System.out.println(col);
	}
}