package dk.lundogbendsen.javase8advanced.reflection.ex03.inspect;

public class Car extends Vehicle implements CanCrossLand
{
  private int maxLandSpeed;

  public Car(final String name, final int maxLandSpeed)
  {
    super(name);
    this.maxLandSpeed = maxLandSpeed;
  }

  @Override
  public int getMaxSpeed()
  {
    return getLandSpeed();
  }

  @Override
  public int getLandSpeed()
  {
    return this.maxLandSpeed;
  }

}
