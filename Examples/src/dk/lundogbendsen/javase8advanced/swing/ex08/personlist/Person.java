package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fullName;

	private int birthYear;

	private int id;

	private static ArrayList<Person> allPersons = new ArrayList<>();

	public static List<Person> getAllPersons() {
		List<Person> listClone = (List<Person>) allPersons.clone();
		return Collections.unmodifiableList(listClone);
	}

	private static void addPerson(final Person person) {
		allPersons.add(person);
	}

	public static void setAllPersons(final ArrayList<Person> allPersons) {
		Person.allPersons = allPersons;
	}

	private static int nextId() {
		// da allPersons starter med index 0
		// er det IKKE size( )+1 vi skal returnere
		return allPersons.size();
	}

	public static Person getPersonWithId(final int id) {
		return allPersons.get(id);
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	Person(final String fullName, final int birthYear) {
		this.fullName = fullName;
		this.birthYear = birthYear;
		this.id = nextId();
		if (!isValidPerson(fullName, birthYear)) {
			String msg = "Tried to create illegal person";
			throw new IllegalArgumentException(msg);
		}
		addPerson(this);
	}

	public static boolean isValidPerson(final String fullName, final int birthYear) {
		if (fullName == null) {
			return false;
		} else if (fullName.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		String s = "Person[";
		s += "named " + fullName;
		s += " born in " + birthYear;
		s += "]";
		return s;
	}
}
