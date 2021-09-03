package dk.lundogbendsen.javase8advanced.collections.ex01.using;

/*
 * Viser brugen af put( K key, V element) på to forskellige
 * implementationer af Map, nemlig HashMap og TreeMap.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import dk.lundogbendsen.javase8advanced.collections.shared.Person;

public class UsingMaps
{
  public static void main(final String[] args) throws Exception
  {
    Person p1 = Person.getRandom();
    Person p2 = Person.getRandom();
    Person p3 = Person.getRandom();
    Person p4 = p1.clone();

    Map<Integer, Person> hashMap = new HashMap<Integer, Person>();
    Map<Integer, Person> treeMap = new TreeMap<Integer, Person>();

    hashMap.put(p1.getId(), p1);
    hashMap.put(p2.getId(), p2);
    hashMap.put(p3.getId(), p3);
    hashMap.put(p4.getId(), p4);

    treeMap.put(p1.getId(), p1);
    treeMap.put(p2.getId(), p2);
    treeMap.put(p3.getId(), p3);
    treeMap.put(p4.getId(), p4);

    System.out.println("Vi indsatte personerne i følgende rækkefølge: ");

    System.out.println("p1=" + p1);
    System.out.println("p2=" + p2);
    System.out.println("p3=" + p3);
    System.out.println("p4=" + p4);

    System.out.println("\nVi udskriver hashMap.toString(): ");
    System.out.println(hashMap.toString());
    System.out.println("Vi kalder remove(  2 ) )");
    hashMap.remove(2);
    System.out.println("Vi udskriver hashMap.toString(): ");
    System.out.println(hashMap.toString());

    System.out.println("\nVi udskriver treeMap.toString(): ");
    System.out.println(treeMap.toString());
    System.out.println("Vi kalder remove(  2 )");
    treeMap.remove(2);
    System.out.println("Vi udskriver treeMap.toString(): ");
    System.out.println(treeMap.toString());
  }
}