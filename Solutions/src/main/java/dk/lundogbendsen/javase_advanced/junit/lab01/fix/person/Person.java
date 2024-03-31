package dk.lundogbendsen.javase_advanced.junit.lab01.fix.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

	public String firstName = "Unknown";

	public String lastName = "Unknown";

	public final LocalDate birthDay;

	public Person(LocalDate birthDay) {
		super();
		this.birthDay = birthDay;
	}
	
	public long getAgeAt(LocalDate date) {
		return ChronoUnit.YEARS.between(birthDay, date);
	}
	
	public void setFullName(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
