package dk.lundogbendsen.javase_advanced.streams.ex05;

public class City
{
  private final String name;

  public String getName()
  {
    return name;
  }

  private final Country country;

  public Country getCountry()
  {
    return country;
  }

  public City(final String name, final Country country)
  {
    this.name = name;
    this.country = country;
  }

  @Override
  public String toString()
  {
    return "City[name=" + name + ", country=" + country + "]";
  }
}
