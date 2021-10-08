package dk.lundogbendsen.javase_advanced.polymorphism.ex02;

import java.util.ArrayList;

@SuppressWarnings("all")
public class ToStringWithoutPolymorphy {
	public static void main(final String[] args) {
		ArrayList a = new ArrayList();
		a.add(new Car(200));
		a.add(new Truck(120));
		a.add(new Ship(3, 30));
		/* printing objects without using toString() */
		for (int n = 0; n < a.size(); n++) {
			Object o = a.get(n);
			if (o instanceof Car) {
				if (o instanceof Truck) {
					Truck t = (Truck) o;
					System.out.print("Truck[numberOfWheels=" + t.numberOfWheels);
					System.out.println(", speed=" + t.speed + "]");
				} else {
					Car c = (Car) o;
					System.out.print("Car[numberOfWheels=" + c.numberOfWheels);
					System.out.println(", speed=" + c.speed + "]");
				}
			} else if (o instanceof Ship) {
				Ship s = (Ship) o;
				System.out.print("Ship[numberOfSails=" + s.numberOfSails);
				System.out.println(", speed=" + s.speed + "]");
			}
		}
	}
}

abstract class Vehicle {
	int speed;

	Vehicle(final int speed) {
		this.speed = speed;
	}
}

class Car extends Vehicle {
	int numberOfWheels = 4;

	Car(final int speed) {
		super(speed);
	}
}

class Truck extends Car {
	Truck(final int speed) {
		super(speed);
		numberOfWheels = 12;
	}
}

class Ship extends Vehicle {
	int numberOfSails;

	Ship(final int numberOfSails, final int speed) {
		super(speed);
		this.numberOfSails = numberOfSails;
	}
}
