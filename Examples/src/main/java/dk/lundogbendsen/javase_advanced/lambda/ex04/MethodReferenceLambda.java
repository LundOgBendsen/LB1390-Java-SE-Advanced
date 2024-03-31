package dk.lundogbendsen.javase_advanced.lambda.ex04;

import java.util.LinkedList;
import java.util.List;

public class MethodReferenceLambda
{
  public static void main(final String[] args) throws InterruptedException
  {
    List<Car> cars = new LinkedList<Car>();
    cars.add(new Car("Hyundai", "Santa Fe", 2005));
    cars.add(new Car("Audi", "A4", 2008));
    cars.add(new Car("Hyundai", "i10", 2014));
    cars.add(new Car("VW", "Golf", 2005));
    cars.add(new Car("Mazda", "626", 1998));

    System.out.println("Unsorted:");
    System.out.println(cars);

    System.out.println("By make:");
    cars.sort(Car::compareByMake);
    System.out.println(cars);

    System.out.println("By model:");
    cars.sort(Car::compareByModel);
    System.out.println(cars);

    System.out.println("By year:");
    cars.sort(Car::compareByYear);
    System.out.println(cars);

    System.out.println("Done");
  }

}
