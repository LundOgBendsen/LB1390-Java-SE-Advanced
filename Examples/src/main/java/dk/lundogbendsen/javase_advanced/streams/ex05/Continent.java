package dk.lundogbendsen.javase_advanced.streams.ex05;

public class Continent
{
  private final String name;

  public String getName()
  {
    return name;
  }
  
  public Continent(final String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Continent[name=" + name + "]";
  }
}
