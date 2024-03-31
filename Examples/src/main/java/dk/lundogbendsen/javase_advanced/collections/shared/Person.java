package dk.lundogbendsen.javase_advanced.collections.shared;

import java.util.Collection;
import java.util.Map;
import java.util.Random;

public class Person implements Comparable<Person>, Cloneable {
	private static int nextId = 1;

	private int id;

	private String firstName;

	private String lastName;

	private int bornIn;

	public Person(final String firstName, final String lastName, final int bornIn) {
		this.id = nextId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornIn = bornIn;
	}

	public int getId() {
		return this.id;
	}

	public int getBornIn() {
		return this.bornIn;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	@Override
	public String toString() {
		String s = "Person(id: " + id + ", firstName: " + firstName;
		s += ", lastName: " + lastName + ", bornIn: " + bornIn + ")";
		return s;
	}

	public static Person getRandom() {
		String[] firstNames = { "Ingrid", "Dorthe", "Finn", "Torben", "Troels", "Gerda", "Ole", "Lena", "Flemming",
				"Anne", "Tessa", "Niels", "Per" };
		String[] lastNames = { "Falk", "Andriansen", "Berg", "Christensen", "Eliasen", "Grøndahl", "Hemdrup", "Larsen",
				"Møller", "Pedersen", "Vilmarsen" };

		Random r = new Random();
		String firstName = firstNames[r.nextInt(firstNames.length)];
		String lastName = lastNames[r.nextInt(lastNames.length)];
		int bornIn = r.nextInt(100) + 1901;
		return new Person(firstName, lastName, bornIn);
	}

	// Returns a negative integer, zero, or a positive integer as an indicator that this
	// object is less than, equal to, or greater than the supplied (other) object.
	@Override
	public int compareTo(final Person other) {
		int lastNameCompare = this.lastName.compareTo(other.lastName);
		if (lastNameCompare != 0) {
			return lastNameCompare;
		}
		int firstNameCompare = this.firstName.compareTo(other.firstName);
		if (firstNameCompare != 0) {
			return firstNameCompare;
		}
		if (this.bornIn < other.bornIn) {
			return -1;
		}
		if (this.bornIn > other.bornIn) {
			return 1;
		}
		int idCompare = this.id - other.id;
		return idCompare;
	}

	@Override
	public boolean equals(final Object o) {
		if (this.getClass() != o.getClass()) {
			return false;
		}
		return (this.compareTo((Person) o) == 0);
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public static Collection<Person> fillCollection(final int howMany, final Collection<Person> collection) {
		Person p;
		for (int n = 0; n < howMany; n++) {
			p = getRandom();
			collection.add(p);
		}
		return collection;
	}

	public static Map<Integer, Person> fillMap(final int howMany, final Map<Integer, Person> map) {
		Person p;
		for (int n = 0; n < howMany; n++) {
			p = getRandom();
			map.put(p.getId(), p);
		}
		return map;
	}
}