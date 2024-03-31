package dk.lundogbendsen.javase_advanced.io.lab01.savingpersons;

public class TestPerson {
	public static void main(final String[] args) throws Exception {
		Person p1 = new Person("Hans Jensen", 1968, 1.84);
		System.out.println("Created Person p1 = " + p1);
		System.out.println();

		System.out.println("Saving p1 in serialized form in the file person.ser");
		p1.saveAsSerialized("person.ser");
		System.out.println("Getting Person p2 from serialized form from file person.ser");
		Person p2 = Person.loadFromSerialized("person.ser");
		System.out.println("Person p2 = " + p2);
		System.out.println();

		System.out.println("Saving p1 in data form in the file person.dat");
		p1.saveAsJavaData("person.dat");
		System.out.println("Getting Person p3 from dataform from file person.dat");
		Person p3 = Person.loadFromJavaData("person.dat");
		System.out.println("Person p3 = " + p3);
		System.out.println();

		System.out.println("Saving p1 in text form (UTF-16) in the file person.txt");
		p1.saveAsText("person.txt", "UTF-16");
		System.out.println("Getting Person p4 from text-form from the file person.txt");
		Person p4 = Person.loadFromText("person.txt", "UTF-16");
		System.out.println("Person p4 = " + p4);
		System.out.println();

		System.out.println("Saving p1 in text form (ASCII) in the file person.txt");
		p1.saveAsText("person.txt", "ASCII");
		System.out.println("Getting Person p5 from text-form from the file person.txt");
		Person p5 = Person.loadFromText("person.txt", "ASCII");
		System.out.println("Person p5 = " + p5);
		System.out.println();
	}
}