package dk.lundogbendsen.javase_advanced.lambda.lab02;

import java.util.Collections;
import java.util.List;

import dk.lundogbendsen.javase_advanced.lambda.common.Person;

public class FluentCompareTo {
	public static void main(final String[] args) {

		List<Person> list = Person.populate(10);

		System.out.println("With lambda-expression:");

		Collections.sort(list,
				(o1, o2) -> CompareUtil.commence().compare(o1.getFirstName(), o2.getFirstName())
						.compare(o1.getLastName(), o2.getLastName()).compare(o1.getBirthYear(), o2.getBirthYear())
						.conclude());
		System.out.println(list);

		Collections.sort(list, (o1, o2) -> CompareUtil.commence().compare(o1.getLastName(), o2.getLastName())
				.compare(o1.getFirstName(), o2.getFirstName()).compare(o1.getBirthYear(), o2.getBirthYear()).conclude());
		System.out.println(list);

		Collections.sort(list, (o1, o2) -> CompareUtil.commence().compare(o2.getBirthYear(), o1.getBirthYear())
				.compare(o1.getFirstName(), o2.getFirstName()).compare(o1.getLastName(), o2.getLastName()).conclude());
		System.out.println(list);

	}
}
