package dk.lundogbendsen.javase_advanced.polymorphism.ex01;

/*
 * Demonstrates that:
 * (1) the type of the reference determines what methods can be called
 * (2) the method closest to the type of the object determines what method is called
 */
public class DynamicBinding {
	public static void main(final String[] args) {
		A a = new B();

		/* legal according to reference type, uses B's method */
		a.print();

		/* legal according to reference type, uses A's method */
		a.write();

		/* Illegal due to reference type */
//		a.type();
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
