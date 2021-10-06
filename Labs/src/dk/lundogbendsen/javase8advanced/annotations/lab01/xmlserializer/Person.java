package dk.lundogbendsen.javase8advanced.annotations.lab01.xmlserializer;

public class Person {

	private Integer id;

	private String firstName;

	private String lastName;

	public Person() {
	}

	public Person(final Integer id, final String firstName, final String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
}
