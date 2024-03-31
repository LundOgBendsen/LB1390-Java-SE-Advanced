package dk.lundogbendsen.javase_advanced.streams.ex05;

import java.util.ArrayList;
import java.util.List;

public class ForeignKeyExample
{
  public static void main(final String[] args)
  {
    List<City> data = new ArrayList<City>();

    data.add(new City("Skanderborg", new Country("Denmark", new Continent("Europe"))));
    data.add(new City("Beijing", new Country("China", new Continent("Asia"))));
    data.add(new City("Key West", new Country("USA", new Continent("America"))));

    //     data.add(null);

    data.stream().forEach(System.out::println);

    data.stream().map((e) -> e.getCountry()).forEach(System.out::println);

    data.stream().map((e) -> e.getCountry()).map((e) -> e.getContinent()).forEach(System.out::println);

    data.stream().map((e) -> e.getCountry()).map((e) -> e.getContinent()).map((e) -> e.getName()).forEach(System.out::println);

  }
}
