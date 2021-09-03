package dk.lundogbendsen.javase8advanced.designpatterns.lab01.observer.generic;

import java.util.ArrayList;
import java.util.List;

public class Main
{
  public static void main(final String[] args)
  {
    List<String> myList = new ArrayList<String>();

    ObservableList<String> observableList = new ObservableList<String>(myList);
    Observer observer1 = new Observer("Observer 1 er blevet kaldt");
    Observer observer2 = new Observer("Observer 2 er blevet kaldt");

    observableList.addObserver(observer1);
    observableList.addObserver(observer2);

    System.out.println("Listen ændres 1. gang");
    observableList.add("Hobbitten Bilbo Sækker");

    System.out.println("Listen ændres 2. gang");
    observableList.add("og hans nevø Frodo Sækker");

    //Spørgsmål 2
    ObservableList<String> oList1 = ObservableListFactory.getObservableList(myList);
    ObservableList<String> oList2 = ObservableListFactory.getObservableList(myList);

    //Spørgsmål 3
    System.out.println("\nSpørgsmål 3");
    System.out.println("oList1 == oList2 : " + (oList1 == oList2));

    ObservableList<String> oList3 = ObservableListFactory.getObservableList(new ArrayList<String>());
    System.out.println(oList1 != oList3);
  }

}
