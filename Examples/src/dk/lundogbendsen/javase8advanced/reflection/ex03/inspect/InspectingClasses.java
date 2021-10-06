package dk.lundogbendsen.javase8advanced.reflection.ex03.inspect;

public class InspectingClasses {

	@SuppressWarnings("deprecation")
	public static void main(final String[] args) {
		try {
			////////////////////////////////////////////////////
			// How to get a Class instance
			////////////////////////////////////////////////////

			String packageName = InspectingClasses.class.getPackage().getName();

			// Getting a Class instance by full name as string
			Class<?> vehicleClass = Class.forName(packageName + ".Vehicle");

			// Getting a Class instance by class literal
			Class<CanCrossLand> canCrossLandInterface = CanCrossLand.class;

			// Getting a Class instance by asking an object for its class
			Car car = new Car("Toyota Corolla", 180);
			Class<? extends Car> carClass = car.getClass();

			////////////////////////////////////////////////////
			// Getting info on type hieararchies
			////////////////////////////////////////////////////

			// Getting a supertype of a class
			if (carClass.getSuperclass() == vehicleClass) { // true
				System.out.println("Car extends Vehicle");
			}
			if (vehicleClass.getSuperclass() == Object.class) { // true
				System.out.println("Vehicle extends Object");
			}
			if (Object.class.getSuperclass() == null) { // true
				System.out.println("Object doesn't extend anything");
			}
			System.out.println("****");

			// Getting all interfaces implemented by a class
			Class<?>[] supertypesOfCar = carClass.getInterfaces();
			System.out.println("Car implements " + supertypesOfCar.length + " interface(s)"); // 1
			if (supertypesOfCar[0] == canCrossLandInterface) { // true
				System.out.println("Car implements CanCrossLand");
			}

			// Is an object of same type or a subtype of a class
			Car c = new Car("Opel", 190);
			Object o = new Object();

			if (Car.class.isInstance(c)) { // true
											// same as (c instanceof Car)
				System.out.println("c is of type Car");
			}
			if (Vehicle.class.isInstance(c)) { // true
				System.out.println("c is of type Vehicle");
			}
			if (CanCrossLand.class.isInstance(c)) { // true
				System.out.println("c is of type CanCrossLand");
			}
			if (Object.class.isInstance(c)) { // true
				System.out.println("c is of type Object");
			}
			if (!Car.class.isInstance(o)) { // true
				System.out.println("o is NOT is of type Car");
			}

			// Is a type a subtype of another type?
			if (Object.class.isAssignableFrom(Car.class)) { // true
				System.out.println("Car is subtype of Object");
			}
			if (Car.class.isAssignableFrom(CanCrossLand.class)) { // true
				System.out.println("Car is subtype of CanCrossLand");
			}
			if (!Vehicle.class.isAssignableFrom(Object.class)) { // true
				System.out.println("Object is NOT a subtype of Vehicle");
			}

			System.out.println("****");

			////////////////////////////////////////////////////
			// Getting information about a class
			////////////////////////////////////////////////////
			System.out.println("Car.class.isArray() = " + Car.class.isArray());
			System.out.println("Car.class.isInterface() = " + Car.class.isInterface());
			System.out.println("Car.class.isPrimitive() = " + Car.class.isPrimitive());
			System.out.println("Car.class.getName() = " + Car.class.getName());

			System.out.println("Car[].class.isArray() = " + Car[].class.isArray());
			System.out.println("new Car[4].getClass().isArray() = " + new Car[4].getClass().isArray());
			System.out.println(
					"Car[].class.getComponentType() == Car.class = " + (Car[].class.getComponentType() == Car.class));

			System.out.println("CanCrossLand.class.isInterface() = " + CanCrossLand.class.isInterface());

			System.out.println("int.class.isPrimitive() = " + int.class.isPrimitive());

			System.out.println("****");

			////////////////////////////////////////////////////
			// Trying to instantiating a class using no-arg constructor
			////////////////////////////////////////////////////

			Class<?> theCarClass = Class.forName(packageName + ".Car");
			Object carAsObject = theCarClass.newInstance();
			@SuppressWarnings("unused")
			Car aCar = (Car) carAsObject;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
