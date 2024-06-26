package dk.lundogbendsen.javase_advanced.reflection.ex07.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericsAndReflection {

	public static void main(final String[] args) throws Exception {
		PersonRegister pr = new PersonRegister();

		Field field = pr.getClass().getDeclaredField("persons");

		System.out.print("Field type");
		Class<?> c = field.getType();
		System.out.println(c.getSimpleName());

		// Type is supertype for Class and ParameterizedType
		ParameterizedType t = (ParameterizedType) field.getGenericType();
		Type[] typeParameters = t.getActualTypeArguments();
		System.out.println("Feltets typeparametre: ");
		for (Type type : typeParameters) {
			Class<?> typeParameter = (Class<?>) type;
			System.out.println("  " + typeParameter.getSimpleName());
		}
	}
}

class PersonRegister {
	private List<Person> persons = new ArrayList<Person>();

	public void addPerson(final Person person) {
		persons.add(person);
	}
}

class Person {

}