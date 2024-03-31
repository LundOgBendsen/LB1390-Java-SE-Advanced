package dk.lundogbendsen.javase_advanced.collections.ex04.how.to.sort;

/*
 * Illustrates two different approaches for how to configure the sorting strategy
 * In this case, we are using a TreeSet, but methodology is applicable for other collections
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class TellingJavaHowToSort {
	public static void main(String[] args) {
		// First we create the list of persons we would use for our example
		Collection<Person> somePersons = Person.fillCollection(4, new ArrayList<Person>());

		// We create a TreeSet that will use the compareTo-method on the Person class
		// The TreeSet object can 'see' that the Person class implements the Comparable interface.
		Collection<Person> comparableSortingFromPerson = new TreeSet<Person>();
		comparableSortingFromPerson.addAll(somePersons);
		System.out.println("We print the set. The set should be sorted by lastName: ");
		System.out.println(comparableSortingFromPerson);

		// We create a new TreeSet
		// This time we supply a Comparator, that will dictate how the elements should be sorted
		// This syntax is using an anonymous inner class
		Collection<Person> comparatorSorting = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int firstNameCompare = p1.getFirstName().compareTo(p2.getFirstName());
				if (firstNameCompare != 0) {
					return firstNameCompare;
				}
				int lastNameCompare = p1.getLastName().compareTo(p2.getLastName());
				if (lastNameCompare != 0) {
					return lastNameCompare;
				}
				int bornInCompare = p1.getBornIn() - p2.getBornIn();
				if (bornInCompare != 0) {
					return bornInCompare;
				}
				int idCompare = p1.getId() - p2.getId();
				return idCompare;
			}
		});
		comparatorSorting.addAll(somePersons);
		System.out.println("\nWe print the new set. The set should be sorted by firstName: ");
		System.out.println(comparatorSorting);
	}
}