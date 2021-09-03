package dk.lundogbendsen.javase8advanced.polymorphism.ex02.tostring.without.polymorphism;

/*
 * Illustrerer hvor besværligt det er at skrive objekter ud,
 * hvis vi ikke har polymorfi (og derfor ikke kan brug toString-metoden)
 */
import java.util.ArrayList;

public class ToStringUdenPolymorfi
{
  public static void main(final String[] args)
  {
    ArrayList<Vehicle> v = new ArrayList<>();
    v.add(new Car(200));
    v.add(new Truck(120));
    v.add(new Ship(3, 30));

    // Besværligt at udskrive disse uden polymorfi
    for (int n = 0; n < v.size(); n++)
    {
      Object o = v.get(n);
      if (o instanceof Car)
      {
        if (o instanceof Truck)
        {
          Truck t = (Truck) o;
          System.out.print("Truck[numberOfWheels=" + t.numberOfWheels);
          System.out.println(", speed=" + t.speed + "]");
        }
        else
        {
          Car c = (Car) o;
          System.out.print("Car[numberOfWheels=" + c.numberOfWheels);
          System.out.println(", speed=" + c.speed + "]");
        }
      }
      else
        if (o instanceof Ship)
        {
          Ship s = (Ship) o;
          System.out.print("Ship[numberOfSails=" + s.numberOfSails);
          System.out.println(", speed=" + s.speed + "]");
        }
    }
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
}

class Truck extends Car
{
  Truck(final int speed)
  {
    super(speed);
    numberOfWheels = 12;
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
}