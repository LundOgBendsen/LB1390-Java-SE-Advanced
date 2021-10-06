package dk.lundogbendsen.javase8advanced.polymorphism.lab01.using.hierachies;

@SuppressWarnings("unused")
public class TestTypeSystem {

	public static void main(final String[] args) {
		// (a) At en Object-reference kan pege på alle typer instanser
		Object[] objects = new Object[6];
		objects[0] = new Animal();
		objects[1] = new Reptile();
		objects[2] = new Mammal();
		objects[3] = new Snake();
		objects[4] = new Cat();
		objects[5] = new Dog();

		// (b) At en reference kan pege på objekter af sin egen type
		Animal a01 = new Animal();
		Reptile a02 = new Reptile();
		Dog a03 = new Dog();

		// (c) At en reference kan pege på instanser af sine subtyper
		Animal a04 = new Reptile();
		Animal a05 = new Dog();
		Mammal a06 = new Cat();

		// (d) At en reference ikke kan pege på et objekt, som hverken
		// er af samme type som referencens type, eller en subtype af
		// referencens type (burde give kompileringsfejl)

		// Dog a07 = new Animal();
		// Snake a08 = new Dog();
		// Cat a08 = new Dog();
		// Mammal a09 = new Object();

		// (e) At metoder nedarves
		Mammal a10 = new Dog();
		a10.run(); // udskriver: Mammal is running

		// (f) At det er objektets type (og ikke referencens type) der
		// bestemmer hvilken metode der bliver kørt (overriding, polymorfi og
		// dynamic binding)
		Mammal a11 = new Cat();
		a11.run(); // udskriver: Cat is running (og ikke Mammal is running)

		// (g) At man ikke kan kalde en metode via en reference, hvis
		// referencen ikke kender metoden (burde give kompileringsfejl –
		// udkommentér linien)
		Animal a12 = new Dog();
		// a12.bark(); //Animal kender ikke bark()-metoden
		Object a13 = new Cat();
		// a13.run(); //Object kender ikke run()-metoden

		// (h) Lav et eksempel på et eksplicit upcast (selvom det er
		// unødvendigt)
		Animal a14 = new Dog();
		Object a15 = new Snake();
		Dog a16 = new Dog();
		Animal a17 = a16;
		Object a18 = a17;

		// (i) Lav et eksempel på et implicit/automatisk upcast
		Animal a19 = new Dog(); // Dog-instansen upcastes til Animal
		Object a20 = new Snake(); // Snake-instansen upcastes til Object
		Dog a21 = new Dog();
		Animal a22 = a21; // Dog-instansen upcastes fra Dog til Animal
		Object a23 = a22; // Dog-instansen upcastes fra Animal til Object

		// (j) Lav et eksempel på et ekslicit downcast
		Animal a24 = new Snake(); // Snake-objekt upcastes til typen Animal
		Reptile a25 = (Reptile) a24; // Snake-objekt downcastes fra Animal til Reptile
		Snake a26 = (Snake) a25; // Snake-objekt downcastes fra Reptile til Snake

		// (k) Lav et eksempel, der viser, at downcasts skal være eksplicitte
		Animal a27 = new Snake(); // Snake-objekt upcastes til typen Animal
		// Snake a28 = a27; //Downcast fra Animal til Snake skal være eksplicit

		// (l) Lav et eksempel, der viser et downcast, som går galt
		// (bør give en køretidsfejl i form af en ClassCastException)
		Mammal a28 = new Cat();
		try {
			Dog a29 = (Dog) a28; // Smider ClassCastException under kørsel
		} catch (ClassCastException e) {
			System.out.println("Greb en forventet ClassCastException");
		}
	}
}
