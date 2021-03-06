package dk.lundogbendsen.javase_advanced.collections.ex03.add.and.remove;

/*
 * Viser den forskellige semantik for metoden remove( Object o )
 * på tre forskellige typer af Collections - List, Set og SortedSet.
 */
import java.util.*;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class TheMeaningOfRemove {
	public static void main(String[] args) throws Exception {
		Person p1 = Person.getRandom();
		Person p2 = Person.getRandom();
		Person p3 = Person.getRandom();
		Person p4 = p1.clone();

		Collection<Person> linkedList = new LinkedList<Person>();
		Collection<Person> arrayList = new ArrayList<Person>();
		Collection<Person> hashSet = new HashSet<Person>();
		Collection<Person> treeSet = new TreeSet<Person>();

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

		System.out.println("Vi indsatte personerne i følgende rækkefølge: ");
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		System.out.println("p3=" + p3);
		System.out.println("p4=" + p4);

		System.out.println("\nVi udskriver linkedList.toString(): ");
		System.out.println(linkedList.toString());
		System.out.println("Vi kalder remove( p1 ) - hvor p1 er: " + p1);
		linkedList.remove(p1);
		System.out.println("Vi udskriver linkedList.toString(): ");
		System.out.println(linkedList.toString());

		System.out.println("\nVi udskriver arrayList.toString(): ");
		System.out.println(arrayList.toString());
		System.out.println("Vi kalder remove( p1 ) - hvor p1 er: " + p1);
		arrayList.remove(p1);
		System.out.println("Vi udskriver arrayList.toString(): ");
		System.out.println(arrayList.toString());

		System.out.println("\nVi udskriver hashSet.toString(): ");
		System.out.println(hashSet.toString());
		System.out.println("Vi kalder remove( p1 ) - hvor p1 er: " + p1);
		hashSet.remove(p1);
		System.out.println("Vi udskriver hashSet.toString(): ");
		System.out.println(hashSet.toString());

		System.out.println("\nVi udskriver treeSet.toString(): ");
		System.out.println(treeSet.toString());
		System.out.println("Vi kalder remove( p1 ) - hvor p1 er: " + p1);
		treeSet.remove(p1);
		System.out.println("Vi udskriver treeSet.toString(): ");
		System.out.println(treeSet.toString());
	}
}