package dk.lundogbendsen.javase8advanced.annotations.lab01.xmlserializer;

public class Main {
	public static void main(final String[] args) throws Exception {
		Person p1 = new Person(1, "Hans", "Jensen");
		Person p2 = new Person(2, "Niels", null);
		Person p3 = new Person();

		System.out.println(XmlSerializer.toXml(p1));
		System.out.println();
		System.out.println(XmlSerializer.toXml(p2));
		System.out.println();
		System.out.println(XmlSerializer.toXml(p3));
	}
}
