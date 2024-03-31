package dk.lundogbendsen.javase_advanced.lambda.lab01;

import java.util.Collections;
import java.util.List;

import dk.lundogbendsen.javase_advanced.lambda.common.Person;

public class SortThisAndThat {
	public static void main(final String[] args) {
		List<Person> list = Person.populate(10);

		Collections.sort(list, (o1, o2) -> {
			int c;
			c = o1.getFirstName().compareTo(o2.getFirstName());
			if (c != 0)
				return c;
			c = o1.getLastName().compareTo(o2.getLastName());
			if (c != 0)
				return c;
			c = o1.getBirthYear() - o2.getBirthYear();
			return c;
		});
		System.out.println(list);

		Collections.sort(list, (o1, o2) -> {
			int c;
			c = o1.getLastName().compareTo(o2.getLastName());
			if (c != 0)
				return c;
			c = o1.getFirstName().compareTo(o2.getFirstName());
			if (c != 0)
				return c;
			c = o1.getBirthYear() - o2.getBirthYear();
			return c;
		});
		System.out.println(list);

		Collections.sort(list, (o1, o2) -> {
			int c;
			c = o1.getBirthYear() - o2.getBirthYear();
			if (c != 0)
				return c;
			c = o1.getFirstName().compareTo(o2.getFirstName());
			if (c != 0)
				return c;
			c = o1.getLastName().compareTo(o2.getLastName());
			return c;
		});
		System.out.println(list);

	}
}
