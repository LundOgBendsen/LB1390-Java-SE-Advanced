package dk.lundogbendsen.javase8advanced.collections.ex07.collections;

/*
 * Viser ex på brugen af Collections-klassen
 */
import java.util.*;

import dk.lundogbendsen.javase8advanced.collections.shared.Person;

public class TheCollectionsClass
{
  public static void main(String[] args)
  {
    List<Person> list = new ArrayList<>();
    list = (List<Person>) Person.fillCollection(4, list);

    System.out.println("List tildeles 4 nye elementer: ");
    System.out.println("list = " + list);

    System.out.println("\nKaldet Collections.max(list) giver: ");
    System.out.println(Collections.max(list));

    System.out.println("\nKaldet Collections.min(list) giver: ");
    System.out.println(Collections.min(list));

    System.out.println("\nVi kalder Collections.sort(list), hvorefter list er: ");
    Collections.sort(list);
    System.out.println("list = " + list);

    System.out.println("\nVi laver en READ-ONLY wrapper omkring list (kaldet readOnlyList)");
    List<Person> readOnlyList = Collections.unmodifiableList(list);

    System.out.println("\nVi prøver at tilføje (SKRIVE) et nyt Person-objekt til readOnlyList.\n");
    readOnlyList.add(Person.getRandom());
  }
}