package dk.lundogbendsen.javase8advanced.annotations.ex01.example;

import dk.lundogbendsen.javase8advanced.annotations.ex02.persistence.PersistentClass;
import dk.lundogbendsen.javase8advanced.annotations.ex02.persistence.PersistentField;

@PersistentClass(table = "person", primaryKey = "id")
public class Person {

	private Integer id;

	private String firstName;

	private String lastName;

	public Person(Integer id) {
		this.id = id;
	}

	@PersistentField(columnName = "person_id", columnType = "INTEGER")
	public Integer getId() {
		return this.id;
	}

	@PersistentField(columnName = "first_name", columnType = "VARCHAR(40)")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@PersistentField(columnName = "last_name", columnType = "VARCHAR(40)")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
