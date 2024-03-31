package dk.lundogbendsen.javase_advanced.junit.lab02.mokito;

public class Person {

	private final String firstName;

	private final String lastName;

	private final int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Person: %s, %s (%d years)", firstName, lastName, age);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
}
