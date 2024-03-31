package dk.lundogbendsen.javase_advanced.collections.ex01.using;

/*
 * Show the use of the put( K key, V element) method on two implementations of the Map interface
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import dk.lundogbendsen.javase_advanced.collections.shared.Person;

public class UsingMaps {
	public static void main(final String[] args) throws Exception {
		Person p1 = Person.getRandom();
		Person p2 = Person.getRandom();
		Person p3 = Person.getRandom();

		Map<Integer, Person> hashMap = new HashMap<Integer, Person>();
		Map<Integer, Person> treeMap = new TreeMap<Integer, Person>();

		System.out.println("We will insert the objects in the following order: ");

		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);
		System.out.println("p3=" + p3);

		hashMap.put(p1.getId(), p1);
		hashMap.put(p2.getId(), p2);
		hashMap.put(p3.getId(), p3);

		treeMap.put(p1.getId(), p1);
		treeMap.put(p2.getId(), p2);
		treeMap.put(p3.getId(), p3);

		System.out.println("\nExecuting hashMap.toString(): ");
		System.out.println(hashMap.toString());
		System.out.println("Executing remove() using key '2'");
		hashMap.remove(2);
		System.out.println("Executing hashMap.toString(): ");
		System.out.println(hashMap.toString());

		System.out.println("\nExecuting treeMap.toString(): ");
		System.out.println(treeMap.toString());
		System.out.println("Executing remove() using key '2'");
		treeMap.remove(2);
		System.out.println("Executing treeMap.toString(): ");
		System.out.println(treeMap.toString());
	}
}