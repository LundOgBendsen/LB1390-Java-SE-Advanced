package dk.lundogbendsen.javase_advanced.collections.ex06.polymorphy;

/*
 * Shows how you can use Iterator and polymorphy to handle collections as well as 'wrapped‘ arrays
 * and maps in the same fashion
 */
import java.util.*;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class PolymorphicPrinter {
	public static void main(String[] args) {
		Object[] array = new Object[5];
		for (int n = 0; n < 5; n++) {
			array[n] = Person.getRandom();
		}
		System.out.println("Udskriver array vha. print( Arrays.asList( array ).iterator() )");
		print(Arrays.asList(array).iterator());

		Vector<Person> vector = new Vector<>();
		vector = (Vector<Person>) Person.fillCollection(5, vector);
		System.out.println("\nUdskriver vector vha. print( vector.iterator() )");
		print(vector.iterator());

		LinkedList<Person> linkedList = new LinkedList<>();
		linkedList = (LinkedList<Person>) Person.fillCollection(5, linkedList);
		System.out.println("\nUdskriver linkedList vha. print( linkedList.iterator() )");
		print(linkedList.iterator());

		ArrayList<Person> arrayList = new ArrayList<>();
		arrayList = (ArrayList<Person>) Person.fillCollection(5, arrayList);
		System.out.println("\nUdskriver arrayList vha. print( arrayList.iterator() )");
		print(arrayList.iterator());

		HashSet<Person> hashSet = new HashSet<>();
		hashSet = (HashSet<Person>) Person.fillCollection(5, hashSet);
		System.out.println("\nUdskriver hashSet vha. print( hashSet.iterator() )");
		print(hashSet.iterator());

		TreeSet<Person> treeSet = new TreeSet<>();
		treeSet = (TreeSet<Person>) Person.fillCollection(5, treeSet);
		System.out.println("\nUdskriver treeSet vha. print( treeSet.iterator() )");
		print(treeSet.iterator());

		HashMap<Integer, Person> hashMap = new HashMap<>();
		hashMap = (HashMap<Integer, Person>) Person.fillMap(5, hashMap);
		System.out.println("\nUdskriver hashMap vha. print( hashMap.keySet().iterator() )");
		print(hashMap.keySet().iterator());
		System.out.println("\nUdskriver hashMap vha. print( hashMap.values().iterator() )");
		print(hashMap.values().iterator());
		System.out.println("\nUdskriver hashMap vha. print( hashMap.entrySet().iterator() )");
		print(hashMap.entrySet().iterator());

		TreeMap<Integer, Person> treeMap = new TreeMap<>();
		treeMap = (TreeMap<Integer, Person>) Person.fillMap(5, treeMap);
		System.out.println("\nUdskriver treeMap vha. print( treeMap.keySet().iterator() )");
		print(treeMap.keySet().iterator());
		System.out.println("\nUdskriver treeMap vha. print( treeMap.values().iterator() )");
		print(treeMap.values().iterator());
		System.out.println("\nUdskriver treeMap vha. print( treeMap.entrySet().iterator() )");
		print(treeMap.entrySet().iterator());

	}

	public static void print(Iterator<?> i) {
		while (i.hasNext()) {
			System.out.println("  " + i.next());
		}
	}
}