package dk.lundogbendsen.javase8advanced.polymorphism.ex01.dynamic.binding;

/*
 * Viser
 * (1) at referencens type bestemmer hvilke
 * metoder og felter vi kan tilgå ved hjælp af
 * referencen, og
 * (2) at det er den metode tættest
 * på objektets type, der bestemmer hvilken
 * implementation af metoden, der bruges.
 */
public class DynamicBinding {
	public static void main(final String[] args) {
		A a = new B();

		// Er legalt jf. 1
		// Bruger B's print jf. 2
		a.print();

		// Er legalt jf. 1
		// Bruger A's print jf. 2
		a.write();

		// Er ulovligt jf. 1
		// a.type();
	}
}

class A {
	void print() {
		System.out.println("A.print()");
	}

	void write() {
		System.out.println("A.write()");
	}
}

class B extends A {
	@Override
	void print() {
		System.out.println("B.print()");
	}

	void type() {
		System.out.println("B.type() ");
	}
}
