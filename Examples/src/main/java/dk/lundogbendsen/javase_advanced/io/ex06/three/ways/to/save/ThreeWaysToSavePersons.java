package dk.lundogbendsen.javase_advanced.io.ex06.three.ways.to.save;

/*
 * Shows how to save a person in three very different ways in Java.
 * Also shows how to bring these people back in.
 * (Actually also shows a fourth way to save a person, namely as XML).
 */

import java.io.IOException;

public class ThreeWaysToSavePersons {
	public static void main(final String[] args) {
		try {
			Person p1 = new Person("Rasmus", 1973, 1.78);
			System.out.println("created Person p1 = " + p1);
			System.out.println();

			System.out.println("Stores p1 in serialized form in the file person.ser");
			p1.saveAsSerialized("person.ser");
			System.out.println("Gets Person p2 from serialized form from the file person.ser");
			Person p2 = Person.loadFromSerialized("person.ser");
			System.out.println("Person p2 = " + p2);
			System.out.println();

			System.out.println("Stores p1 in data form in the file person.dat");
			p1.saveAsJavaData("person.dat");
			System.out.println("Gets Person p2 from data form from the file person.dat");
			Person p3 = Person.loadFromJavaData("person.dat");
			System.out.println("Person p3 = " + p3);
			System.out.println();

			System.out.println("Saves p1 in text form in the file person.txt");
			p1.saveAsText("person.txt");
			System.out.println("Get Person p4 from text form from the file person.txt");
			Person p4 = Person.loadFromText("person.txt");
			System.out.println("Person p4 = " + p4);
			System.out.println();

			// XML has nothing to do with the curriculum, but for those interested:
			System.out.println("Stores p1 in XML form in the file person.xml");
			p1.saveAsXML("person.XML");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}
}