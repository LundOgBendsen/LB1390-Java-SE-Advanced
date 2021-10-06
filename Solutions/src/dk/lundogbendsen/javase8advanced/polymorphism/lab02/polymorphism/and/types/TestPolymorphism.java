package dk.lundogbendsen.javase8advanced.polymorphism.lab02.polymorphism.and.types;

public class TestPolymorphism {

	public static void main(final String[] args) {
		////////////////////////////////////
		// (a) Udskriver c( ) i E

		// E x = new E();
		// x.c();

		////////////////////////////////////
		// (b) Kompilefejl. F er ikke subtype af A.

		// A x = new F();
		// x.a();

		////////////////////////////////////
		// (c) Udskriver 3.14 (omend ikke pæn kode).

		// F x = new F();
		// System.out.println(x.PI);

		////////////////////////////////////
		// (d) Kompilefejl. Referencetypen D kender ikke PI.

		// D x = new E();
		// System.out.println(x.PI);

		////////////////////////////////////
		// (e) Køretids-fejl. En E-instans kan ikke castes til F.

		// B x = new E();
		// F y = (F) x;
		// y.a();

		////////////////////////////////////
		// (f) Udskriver: c( ) i E

		// B x = new E();
		// D y = (D) x;
		// y.c();

		////////////////////////////////////
		// (g) Udskriver: c( ) i D

		// C x = new D();
		// x.c();

		////////////////////////////////////
		// (h) Kompilefejl. C er abstrakt, og kan derfor ikke instantieres.

		// A x = new C();
		// x.a();

		////////////////////////////////////
		// (i) Kompilefejl. Object kender ikke metoden c.

		// Object x = new D();
		// x.c();

		////////////////////////////////////
		// (j) Udskriver: a( ) i C

		// D x = new D();
		// x.a();
	}
}
