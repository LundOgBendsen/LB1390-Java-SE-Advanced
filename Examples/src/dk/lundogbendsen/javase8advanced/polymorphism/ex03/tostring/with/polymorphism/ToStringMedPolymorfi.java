package dk.lundogbendsen.javase8advanced.polymorphism.ex03.tostring.with.polymorphism;

/*
 * Illustrerer hvor nemt det er at skrive objekter ud,
 * hvis vi bruger polymorfi, og String-metoden må bruges
 */
import java.util.ArrayList;

public class ToStringMedPolymorfi
{
  public static void main(final String[] args)
  {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Car(200));
    vehicles.add(new Truck(120));
    vehicles.add(new Ship(3, 30));

    // Nemt at udskrive disse med polymorfi
    System.out.println("ArrayList skriver selv ud: ");
    System.out.println(vehicles);

    // Eller hvis vi gør det manuelt
    System.out.println("\nManuel udskrivning af ArrayList'en: ");
    for (Vehicle v : vehicles)
    {
      System.out.println(v);
    }

    // Eller med Stream (Java 8)
    System.out.println("\nStream udskrivning af ArrayList'en: ");
    vehicles.stream().forEach(System.out::println);
  }
}

abstract class Vehicle
{
  int speed;

  Vehicle(final int speed)
  {
    this.speed = speed;
  }
}

class Car extends Vehicle
{
  int numberOfWheels = 4;

  Car(final int speed)
  {
    super(speed);
  }

  @Override
  public String toString()
  {
    return "Car[speed=" + speed + ", numberOfWheels=" + numberOfWheels + "]";
  }
}

class Truck extends Car
{
  Truck(final int speed)
  {
    super(speed);
    numberOfWheels = 12;
  }

  @Override
  public String toString()
  {
    return "Truck[speed=" + speed + ", numberOfWheels=" + numberOfWheels + "]";
  }
}

class Ship extends Vehicle
{
  int numberOfSails;

  Ship(final int numberOfSails, final int speed)
  {
    super(speed);
    this.numberOfSails = numberOfSails;
  }

  @Override
  public String toString()
  {
    return "Ship[speed=" + speed + ", numberOfSails=" + numberOfSails + "]";
  }
}