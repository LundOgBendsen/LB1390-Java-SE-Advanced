package dk.lundogbendsen.javase8advanced.generics.lab01.point;

public class Main {

	public static void main(final String[] args) {

		Point<Integer> p1 = new Point<Integer>(3, 4);
		System.out.println(p1);

		Point<Double> p2 = new Point<Double>(5.5, 6.89);
		System.out.println(p2);

		// Ikke muligt pga. vi har angivet at T skal være subtype af Number:
		// Point<String> p = new Point("Hi", "Ho");

	}
}
