package dk.lundogbendsen.javase8advanced.io.lab01.savingpersons;

public class Person
{
  private String name;

  private int bornIn;

  private double height;

  public Person(final String name, final int bornIn, final double height)
  {
    this.name = name;
    this.bornIn = bornIn;
    this.height = height;
  }

  @Override
  public String toString()
  {
    return "Person[name=" + name + ", bornIn=" + bornIn + ", height=" + height + "]";
  }
}