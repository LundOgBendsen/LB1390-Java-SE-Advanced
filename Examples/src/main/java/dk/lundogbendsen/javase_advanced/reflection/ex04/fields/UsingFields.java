package dk.lundogbendsen.javase_advanced.reflection.ex04.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class UsingFields {

	public static void main(final String[] args)
			throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {

		ClassWithFields cwf = new ClassWithFields();
		System.out.println(cwf);

		// UDSKRIVER:
		// a = 12
		// str = Hej med dig
		// PI = 3.14

		System.out.println("****");

		//////////////////////////////////////////////////////////////
		// Getting all public fields (including inherited)

		Field[] publicFields = cwf.getClass().getFields();
		for (int n = 0; n < publicFields.length; n++) {
			System.out.println(publicFields[n]);
		}
		// UDSKRIVER:
		// public static final double ex04.ClassWithFields.PI

		System.out.println("****");

		//////////////////////////////////////////////////////////////
		// Getting all fields declared in class (including non-public)

		Field[] declaredFields = cwf.getClass().getDeclaredFields();
		for (int n = 0; n < declaredFields.length; n++) {
			System.out.println(declaredFields[n]);
		}
		// UDSKRIVER:
		// private int ex04.ClassWithFields.a
		// java.lang.String ex04.ClassWithFields.str
		// public static final double ex04.ClassWithFields.PI

		System.out.println("****");

		//////////////////////////////////////////////////////////////
		// Getting a field by name

		Field a = ClassWithFields.class.getDeclaredField("a");

		//////////////////////////////////////////////////////////////
		// Getting info about a field

		int modifiersOnA = a.getModifiers();

		System.out.println("Is a abstract? " + Modifier.isAbstract(modifiersOnA));
		System.out.println("Is a public? " + Modifier.isPublic(modifiersOnA));
		System.out.println("Is a private? " + Modifier.isPrivate(modifiersOnA));

		System.out.println("Type of a is: " + a.getType().getName());

		System.out.println("****");

		//////////////////////////////////////////////////////////////
		// Getting values of an instance field

		ClassWithFields obj = new ClassWithFields();

		Field fieldA = ClassWithFields.class.getDeclaredField("a");

		int valueOfA = 0;
		try {
			valueOfA = fieldA.getInt(obj);
		} catch (IllegalAccessException e) {
			System.out.println("By default private fields are not accessible");
		}

		// Make the private field accessible for reflection
		fieldA.setAccessible(true);

		// Then try reading the field again
		valueOfA = fieldA.getInt(obj);

		System.out.println("Value of a is: " + valueOfA);

		// Reading a public field is never a problem
		Field fieldStr = ClassWithFields.class.getDeclaredField("str");
		Object fieldStrValueAsObject = fieldStr.get(obj);
		String valueOfStr = (String) fieldStrValueAsObject;
		System.out.println("Value of str is: " + valueOfStr);

		//////////////////////////////////////////////////////////////
		// Setting values of an instance field

		ClassWithFields object = new ClassWithFields();

		Field aField = ClassWithFields.class.getDeclaredField("a");

		// make private field accessible for reflection
		aField.setAccessible(true);

		// an int field can be set using int-wrapper java.lang.Integer:
		Integer integer = Integer.valueOf(1000);
		aField.set(object, integer);
		System.out.println(object); // a = 1000

		// an int field can be set using the setInt-method:
		int i = 999;
		aField.setInt(object, i);
		System.out.println(object); // a = 999

		// ... and both the above can be mixed with auto-boxing and auto-unboxing

		// reading a static field
		Field staticField = ClassWithFields.class.getDeclaredField("PI_APPROX");
		int fieldModifiers = staticField.getModifiers();
		if (Modifier.isStatic(fieldModifiers)) { // true
			System.out.println("The field PI_APPROX is static");
		}
		double valueOfPi = staticField.getDouble(ClassWithFields.class);
		System.out.println("Value of static field PI_APPROX is " + valueOfPi);
		System.out.println("Error in value of static field PI_APPROX is "
				+ Math.abs(valueOfPi - Math.PI) / Math.PI * 100.0 + " %");
	}
}
