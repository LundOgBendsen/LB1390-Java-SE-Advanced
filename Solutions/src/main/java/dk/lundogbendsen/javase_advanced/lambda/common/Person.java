package dk.lundogbendsen.javase_advanced.lambda.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
	private final String firstName;
	private final String lastName;
	private final int birthYear;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public Person(final String fornavn, final String efternavn, final int fødselsår) {
		super();
		this.firstName = fornavn;
		this.lastName = efternavn;
		this.birthYear = fødselsår;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + (2014 - birthYear) + ")";
	}

	private static Random r = new Random();

	public static Person getRandomPerson() {
		String[] firstNames = { "Ingrid", "Dorthe", "Finn", "Torben", "Troels", "Gerda", "Ole", "Lena", "Flemming",
				"Anne", "Tessa", "Niels", "Per" };
		String[] lastNames = { "Falk", "Andriansen", "Berg", "Christensen", "Eliasen", "Grøndahl", "Hemdrup", "Larsen",
				"Møller", "Pedersen", "Vilmarsen" };
		String firstName = firstNames[r.nextInt(firstNames.length)];
		String lastName = lastNames[r.nextInt(lastNames.length)];
		int bornIn = r.nextInt(70) + 1940;
		return new Person(firstName, lastName, bornIn);
	}

	public static List<Person> populate(final int howMany) {
		List<Person> list = new ArrayList<>();
		for (int n = 0; n < howMany; n++) {
			Person p = getRandomPerson();
			list.add(p);
		}
		return list;
	}
}
