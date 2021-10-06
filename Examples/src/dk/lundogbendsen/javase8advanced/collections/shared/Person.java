package dk.lundogbendsen.javase8advanced.collections.shared;

/*
 * Bruges igennem alle eksemplerne. Er lidt langsom om at
 * generere personer, så en god idé er at lave fx 1000, som
 * du kopierer ud i et array: Object[] o = new Object[1000].
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Det burde ikke være muligt at klone en person, idet det
// giver to personer med ens id... men det er netop hvad
// vi har brug for i nogle af eksemplerne - såhhh.....
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

	// Burde ikke være der... men nødvendig for et par tests vi laver med
	// klassen
	public void setId(final int id) {
		this.id = id;
	}

	public int getBornIn() {
		return this.bornIn;
	}

	public void setBornIn(final int i) {
		this.bornIn = i;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String f) {
		this.firstName = f;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String s) {
		this.lastName = s;
	}

	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	@Override
	public String toString() {
		String s = "Person(" + id + "," + firstName;
		s += "," + lastName + "," + bornIn + ")";
		return s;
	}

	public static Person getRandom() {
		String[] firstNames = { "Ingrid", "Dorthe", "Finn", "Torben", "Troels", "Gerda", "Ole", "Lena", "Flemming",
				"Anne", "Tessa", "Niels", "Per" };
		String[] lastNames = { "Falk", "Andriansen", "Berg", "Christensen", "Eliasen", "Grøndahl", "Hemdrup", "Larsen",
				"Møller", "Pedersen", "Vilmarsen" };
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		Random r = new Random();
		String firstName = firstNames[r.nextInt(firstNames.length)];
		String lastName = lastNames[r.nextInt(lastNames.length)];
		int bornIn = r.nextInt(100) + 1901;
		return new Person(firstName, lastName, bornIn);
	}

	// Returns a negative integer, zero, or a positive integer as this
	// object is less than, equal to, or greater than the specified object.
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

	// Main-metoden viser hvordan man kan unit-teste sin klasse
	public static void main(final String[] args) throws Exception {
		// ////////////////////////////////////////////////////////
		line();
		pl("Tester random konstruktion 10 gange");
		for (int i = 0; i < 10; i++) {
			pl(getRandom());
		}
		// ////////////////////////////////////////////////////////
		line();
		pl("Tester compareTo()- og equals()-metoderne");
		Person p1 = getStandard();
		Person p2 = getStandard();
		pl("p1 = " + p1);
		pl("p2 = " + p2);
		pl("p1.compareTo( p2 ) giver: " + p1.compareTo(p2));
		pl("p2.compareTo( p1 ) giver: " + p2.compareTo(p1));
		pl("p1.equals( p2 ) giver: " + p1.equals(p2));
		pl();
		p1 = getStandard();
		p2 = new Person("Rasmus", "Lund", 1973);
		pl("p1 = " + p1);
		pl("p2 = " + p2);
		pl("p1.compareTo( p2 ) giver: " + p1.compareTo(p2));
		pl("p2.compareTo( p1 ) giver: " + p2.compareTo(p1));
		pl("p1.equals( p2 ) giver: " + p1.equals(p2));
		pl();
		p1 = getStandard();
		p1.setBornIn(1972);
		p2 = getStandard();
		pl("p1 = " + p1);
		pl("p2 = " + p2);
		pl("p1.compareTo( p2 ) giver: " + p1.compareTo(p2));
		pl("p2.compareTo( p1 ) giver: " + p2.compareTo(p1));
		pl("p1.equals( p2 ) giver: " + p1.equals(p2));
		pl();
		p1 = getStandard();
		p1.setFirstName("Anne");
		p2 = getStandard();
		pl("p1 = " + p1);
		pl("p2 = " + p2);
		pl("p1.compareTo( p2 ) giver: " + p1.compareTo(p2));
		pl("p2.compareTo( p1 ) giver: " + p2.compareTo(p1));
		pl("p1.equals( p2 ) giver: " + p1.equals(p2));
		pl();
		p1 = getStandard();
		p1.setLastName("Hansen");
		p2 = getStandard();
		pl("p1 = " + p1);
		pl("p2 = " + p2);
		pl("p1.compareTo( p2 ) giver: " + p1.compareTo(p2));
		pl("p2.compareTo( p1 ) giver: " + p2.compareTo(p1));
		pl("p1.equals( p2 ) giver: " + p1.equals(p2));
		pl();

		// ////////////////////////////////////////////////////////
		line();
		pl("Tester fillMap() og fillCollection() ved at fylde 10 forskellige personer i");
		Person p;
		Map<Integer, Person> map = new HashMap<>();
		List<Person> col = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			p = getRandom();
			map.put(new Integer(p.getId()), p);
			col.add(p);
		}
		pl();
		pl("Udskrivning af map giver: ");
		pl(map);
		pl();
		pl("Udskrivning af col giver: ");
		pl(col);
		pl();
		pl("Udskrivning sorteret col giver: ");
		Collections.sort(col);
		pl(col);
		pl();
		pl("Udskrivning af 2 ens personer i map: ");
		Person pers1 = getStandard();
		Person pers2 = getStandard();
		map.clear();
		map.put(pers1.getId(), pers1);
		map.put(pers2.getId(), pers2);
		pl(map);
		pl();
		pl("Udskrivning af 2 ens personer i col: ");
		col.clear();
		col.add(pers1);
		col.add(pers2);
		pl(col);
		line();
	}

	private static Person getStandard() {
		Person p = new Person("Rasmus", "Lund", 1973);
		p.id = 1;
		return p;
	}

	private static void pl() {
		System.out.println();
	}

	private static void pl(final Object o) {
		System.out.println(o);
	}

	private static void line() {
		System.out.println("=========================");
	}

}