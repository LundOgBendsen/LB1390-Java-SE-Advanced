package dk.lundogbendsen.javase8advanced.collections.ex03.add.and.remove;

/*
 * Viser den forskellige semantik for metoden add( Object o )
 * på tre forskellige typer af Collections - List, Set og SortedSet.
 */
import java.util.*;

import dk.lundogbendsen.javase8advanced.collections.shared.Person;

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
		System.out.println("add tilføjer til slutningen af listen");

		System.out.println("\nVi udskriver arrayList.toString(): ");
		System.out.println(arrayList.toString());
		System.out.println("add tilføjer til slutningen af listen");

		System.out.println("\nVi udskriver hashSet.toString(): ");
		System.out.println(hashSet.toString());
		System.out.println("add tilføjer på en for computeren meningsfuld måde");
		System.out.println("add på Set kan ikke tilføje samme objekt 2 gange");

		System.out.println("\nVi udskriver treeSet.toString(): ");
		System.out.println(treeSet.toString());
		System.out.println("add tilføjer så elementerne er sorteret logisk");
		System.out.println("(Person sorterer først på efternavn, så fornavn, fødselsår og sidst id)");
		System.out.println("add på Set kan ikke tilføje samme objekt 2 gange");
	}
}