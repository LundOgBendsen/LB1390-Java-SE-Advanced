package dk.lundogbendsen.javase_advanced.reflection.ex06.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UsingConstructors {

	public static void main(final String[] args) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<Person> personClass = Person.class;

		/////////////////////////////////////////////////////////
		// Obtain the no-args constructor
		Class<?>[] noArgs = new Class[0];
		Constructor<Person> noArgsConstructor = personClass.getDeclaredConstructor(noArgs);

		/////////////////////////////////////////////////////////
		// Obtain the 2-strings constructor
		Class<?>[] twoStrings = new Class<?>[] { String.class, String.class };
		Constructor<Person> twoStringsConstructor = personClass.getDeclaredConstructor(twoStrings);

		/////////////////////////////////////////////////////////
		// Invoke the constructors

		Object[] noValues = new Object[] {};
		Person p = noArgsConstructor.newInstance(noValues);
		System.out.println(p); // Person[firstName=null, lastName=null]

		Object[] twoStringValues = new Object[] { "Nanna", "Lund" };
		Person p2 = twoStringsConstructor.newInstance(twoStringValues);
		System.out.println(p2); // Person[firstName=Nanna, lastName=Lund]

	}
}
