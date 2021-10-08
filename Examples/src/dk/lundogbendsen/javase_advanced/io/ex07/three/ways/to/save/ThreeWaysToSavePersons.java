package dk.lundogbendsen.javase_advanced.io.ex07.three.ways.to.save;

/*
 * Viser hvordan man kan gemme en person på tre vidt forskellige måder i Java.
 * Viser også hvordan man kan hente disse personer ind igen.
 * (Viser faktisk også en fjerde måde at gemme en person på, nemlig som XML).
 */

import java.io.IOException;

public class ThreeWaysToSavePersons {
	public static void main(final String[] args) {
		try {
			Person p1 = new Person("Rasmus", 1973, 1.78);
			System.out.println("Lavet Person p1 = " + p1);
			System.out.println();

			System.out.println("Gemmer p1 i serialiseret form i filen person.ser");
			p1.saveAsSerialized("person.ser");
			System.out.println("Henter Person p2 fra serialiseret form fra filen person.ser");
			Person p2 = Person.loadFromSerialized("person.ser");
			System.out.println("Person p2 = " + p2);
			System.out.println();

			System.out.println("Gemmer p1 på dataform i filen person.dat");
			p1.saveAsJavaData("person.dat");
			System.out.println("Henter Person p3 fra dataform fra filen person.dat");
			Person p3 = Person.loadFromJavaData("person.dat");
			System.out.println("Person p3 = " + p3);
			System.out.println();

			System.out.println("Gemmer p1 i tekst-form i filen person.txt");
			p1.saveAsText("person.txt");
			System.out.println("Henter Person p4 fra tekst-form fra filen person.txt");
			Person p4 = Person.loadFromText("person.txt");
			System.out.println("Person p4 = " + p4);
			System.out.println();

			// XML har intet med pensum at gøre, men for de interesserede:
			System.out.println("Gemmer p1 i XML-form i filen person.xml");
			p1.saveAsXML("person.XML");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}
}