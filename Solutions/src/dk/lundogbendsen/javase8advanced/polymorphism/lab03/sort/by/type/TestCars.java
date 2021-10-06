package dk.lundogbendsen.javase8advanced.polymorphism.lab03.sort.by.type;

import java.util.ArrayList;
import java.util.Random;

public class TestCars {
	public static void main(final String[] args) {
		ArrayList<Car> cars = new ArrayList<Car>();
		Random r = new Random();
		for (int n = 0; n < 50; n++) {
			switch (r.nextInt(5)) {
			case 0:
				cars.add(new Car());
				break;
			case 1:
				cars.add(new Opel());
				break;
			case 2:
				cars.add(new Toyota());
				break;
			case 3:
				cars.add(new Corolla());
				break;
			default:
				cars.add(new Avensis());
			}
		}
		System.out.println("All cars:");
		System.out.println(cars);

		System.out.println();
		System.out.println("Toyotas and subtypes:");
		System.out.println(getAllToyotasAndToyotaSubtypes(cars));

		System.out.println();
		System.out.println("Toyotas and no subtypes:");
		System.out.println(getAllToyotasAndNoSubtypes(cars));
	}

	private static ArrayList<Car> getAllToyotasAndToyotaSubtypes(final ArrayList<Car> cars) {
		ArrayList<Car> v = new ArrayList<Car>();
		for (int n = 0; n < cars.size(); n++) {
			if (cars.get(n) instanceof Toyota) {
				v.add(cars.get(n));
			}
		}
		return v;
	}

	private static ArrayList<Car> getAllToyotasAndNoSubtypes(final ArrayList<Car> cars) {
		ArrayList<Car> v = new ArrayList<Car>();
		for (int n = 0; n < cars.size(); n++) {
			if (cars.get(n).getClass() == Toyota.class) {
				v.add(cars.get(n));
			}
		}
		return v;
	}
}

class Car {
	@Override
	public String toString() {
		return "Car";
	}
}

class Opel extends Car {
	@Override
	public String toString() {
		return "Opel";
	}
}

class Toyota extends Car {
	@Override
	public String toString() {
		return "Toyota";
	}
}

class Corolla extends Toyota {
	@Override
	public String toString() {
		return "Corolla";
	}
}

class Avensis extends Toyota {
	@Override
	public String toString() {
		return "Avensis";
	}
}