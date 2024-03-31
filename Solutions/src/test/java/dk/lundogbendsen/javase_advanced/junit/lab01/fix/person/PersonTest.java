package dk.lundogbendsen.javase_advanced.junit.lab01.fix.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testGetAgeAt() {
		LocalDate birthDay = LocalDate.of(1970, 5, 13);
		LocalDate testDay = LocalDate.of(2021, 4, 13);
		Person p = new Person(birthDay);
		assertEquals(50, p.getAgeAt(testDay), "Before birthday");
		testDay = LocalDate.of(2021, 5, 13);
		assertEquals(51, p.getAgeAt(testDay), "On birthday");
		testDay = LocalDate.of(2021, 6, 13);
		assertEquals(51, p.getAgeAt(testDay), "After birthday");
	}

}
