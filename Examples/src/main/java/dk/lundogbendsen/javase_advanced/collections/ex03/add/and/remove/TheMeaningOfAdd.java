package dk.lundogbendsen.javase_advanced.collections.ex03.add.and.remove;

/*
 * Show the difference of semantic for the method add( Object o )
 * for three different implementations of Collection - List, Set and SortedSet
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class TheMeaningOfAdd {
	public static void main(String[] args) throws Exception {
		Person p1 = Person.getRandom();
		Person p2 = Person.getRandom();
		Person p3 = Person.getRandom();
		Person p4 = p1.clone();

		Collection<Person> linkedList = new LinkedList<>();
		Collection<Person> arrayList = new ArrayList<>();
		Collection<Person> hashSet = new HashSet<>();
		Collection<Person> treeSet = new TreeSet<>();

		System.out.println("We will insert the objects in the following order: ");
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		System.out.println("p3=" + p3);
		System.out.println("p4=" + p4);

		linkedList.add(p1);
		linkedList.add(p2);
		linkedList.add(p3);
		linkedList.add(p4);

		arrayList.add(p1);
		arrayList.add(p2);
		arrayList.add(p3);
		arrayList.add(p4);

		hashSet.add(p1);
		hashSet.add(p2);
		hashSet.add(p3);
		hashSet.add(p4);

		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(p3);
		treeSet.add(p4);

		System.out.println("\nExecuting linkedList.toString(): ");
		System.out.println(linkedList.toString());
		System.out.println("'add' is actually appending to the end of the list");

		System.out.println("\nExecuting arrayList.toString(): ");
		System.out.println(arrayList.toString());
		System.out.println("'add' is actually appending to the end of the list");

		System.out.println("\nExecuting hashSet.toString(): ");
		System.out.println(hashSet.toString());
		System.out.println("We cannot predict how 'add' will behave");
		System.out.println("adding the same person twice (p1 & p4) is OK, but only one is maintained in the set");

		System.out.println("\nExecuting treeSet.toString(): ");
		System.out.println(treeSet.toString());
		System.out.println("the elements are sorted, using the implementation of compareTo found in the Person class"); // more on this in later examples
		System.out.println("adding the same person twice (p1 & p4) is OK, but only one is maintained in the set");
	}
}