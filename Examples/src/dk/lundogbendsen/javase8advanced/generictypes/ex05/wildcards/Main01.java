/*
 * Illustrerer et problem med at definere generelle metoder.
 */
package dk.lundogbendsen.javase8advanced.generictypes.ex05.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main01
{

  @SuppressWarnings("unused")
  public static void main(final String[] args)
  {
    List<Integer> integerList = new ArrayList<Integer>(10);
    // Ulovligt da List<Integer> ikke er subtype af List<Object>
    // printCollection(integerList);

    Collection<String> stringList = new ArrayList<String>();
    // Ulovligt da List<String> ikke er subtype af List<Object>
    // printCollection(stringList);
  }

  // Denne metode kan ikke lade sig gøre...
  static void printCollection(final Collection<Object> c)
  {
    for (Object o : c)
      System.out.println(o);
  }
}
