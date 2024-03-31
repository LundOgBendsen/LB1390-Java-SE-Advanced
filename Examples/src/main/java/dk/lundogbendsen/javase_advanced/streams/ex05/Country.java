package dk.lundogbendsen.javase_advanced.streams.ex05;


public class Country
{
  private final String name;

  public String getName()
  {
    return name;
  }
  
  private final Continent continent;

  public Continent getContinent()
  {
    return continent;
  }

  public Country(final String name, final Continent continent)
  {
    this.name = name;
    this.continent = continent;
  }

  @Override
  public String toString()
  {
    return "Country[continent=" + continent + "]";
  }
}
