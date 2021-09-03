package dk.lundogbendsen.javase8advanced.reflection.ex03.inspect;

public abstract class Vehicle
{

  protected Vehicle(String name)
  {
    setName(name);
  }

  private String name;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public abstract int getMaxSpeed();
}
