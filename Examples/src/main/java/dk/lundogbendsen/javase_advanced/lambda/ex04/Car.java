package dk.lundogbendsen.javase_advanced.lambda.ex04;

public class Car
{
  private final String make;
  private final String model;
  private final int year;
  public Car(final String make, final String model, final int year)
  {
    super();
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public static int compareByMake(final Car c1, final Car c2)
  {
    return c1.make.compareTo(c2.make);
  }
  
  public static int compareByModel(final Car c1, final Car c2)
  {
    return c1.model.compareToIgnoreCase(c2.model);
  }
  
  public static int compareByYear(final Car c1, final Car c2)
  {
    return c1.year - c2.year;
  }

  @Override
  public String toString()
  {
    return make + " " + model + " (" + year + ")";
  }

  
}
