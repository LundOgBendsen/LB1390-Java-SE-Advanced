package dk.lundogbendsen.javase_advanced.polymorphism.ex04;

/*
 * Demonstrates different types of type checking
 */
public class TypeCheck {
	public static void main(final String[] args) {
		A a1 = new A();
		A a2 = new B();
		A a3 = new B();

		/* x instanceof Y determines if the type ofobject x is Y or a subclass of Y */
		System.out.println("a1 instanceof A: " + (a1 instanceof A)); // true
		System.out.println("a2 instanceof A: " + (a2 instanceof A)); // true
		System.out.println("a1 instanceof B: " + (a1 instanceof B)); // false
		System.out.println("a2 instanceof B: " + (a2 instanceof B)); // true

		/* 
		 * x.getClass() returns the instance of Class that represents x's class
		 * Y.getClass() returns the instance of Class that represents Y
		 * Using getClass() we can ignore the class hierarchy and ask about a specific class
		 */
		System.out.println("a1.getClass() == A.class: " + (a1.getClass() == A.class)); // true
		System.out.println("a2.getClass() == A.class: " + (a2.getClass() == A.class)); // false
		System.out.println("a1.getClass() == B.class: " + (a1.getClass() == B.class)); // false
		System.out.println("a2.getClass() == B.class: " + (a2.getClass() == B.class)); // true

		/* Similarly we can ask if two objects are of the exact same type */
		System.out.println("a1.getClass() == a2.getClass(): " + (a1.getClass() == a2.getClass())); // false
		System.out.println("a2.getClass() == a3.getClass(): " + (a2.getClass() == a3.getClass())); // true

	}
}

class A {
}

class B extends A {
}
