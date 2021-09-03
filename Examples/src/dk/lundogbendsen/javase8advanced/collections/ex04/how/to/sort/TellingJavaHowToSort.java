package dk.lundogbendsen.javase8advanced.collections.ex04.how.to.sort;

/*
 * Viser at TreeSet (implementerer SortedSet) bruger
 * enten en klasses egen compareTo-metode (hvis den
 * implementerer Comparable) eller en Comparator, som
 * TreeSet får sendt ind med sin constructor.
 */
import java.util.*;

import dk.lundogbendsen.javase8advanced.collections.shared.Person;

public class TellingJavaHowToSort
{
  public static void main(String[] args)
  {
    // Vi laver først en collection, som vi kan putte i 
    // to forskellige udgaver af TreeSet
    Collection<Person> somePersons = new ArrayList<Person>();
    somePersons = Person.fillCollection(4, somePersons);

    // Vi laver et TreeSet som bruger Person-klassens compareTo-metode 
    // (TreeSet kan 'se', at Person implementerer Comparable.
    Collection<Person> standardSortering = new TreeSet<Person>();
    standardSortering.addAll(somePersons);
    System.out.println("Udskrivning af TreeSet'et standardSortering (efternavn): ");
    System.out.println(standardSortering);

    // Vi laver et TreeSet som bruger en Comparator til at sortere
    // person-objekterne udfra (laves som anonym klasse)
    // Sammenligner først på fornavn, så efternavn, bornIn og sidst id.
    // (Person.compareTo har først efternavn - så fornavn)
    Collection<Person> nySortering = new TreeSet<>(new Comparator<Person>()
    {
      @Override
      public int compare(Person p1, Person p2)
      {
        int firstNameCompare = p1.getFirstName().compareTo(p2.getFirstName());
        if (firstNameCompare != 0) { return firstNameCompare; }
        int lastNameCompare = p1.getLastName().compareTo(p2.getLastName());
        if (lastNameCompare != 0) { return lastNameCompare; }
        int bornInCompare = p1.getBornIn() - p2.getBornIn();
        if (bornInCompare != 0) { return bornInCompare; }
        int idCompare = p1.getId() - p2.getId();
        return idCompare;
      }
    });
    nySortering.addAll(somePersons);
    System.out.println("\nUdskrivning af TreeSet'et nySortering (fornavn): ");
    System.out.println(nySortering);
  }
}