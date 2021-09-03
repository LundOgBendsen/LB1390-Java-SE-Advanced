package dk.lundogbendsen.javase8advanced.designpatterns.ex07.singleton.eager;

public class EagerlyCreatedSingleton
{
  public static void main(final String[] args)
  {
    Counter c1 = Counter.getSingleton();
    Counter c2 = Counter.getSingleton();

    System.out.println("Calls c1.increment()");
    c1.increment();
    System.out.println("c1.getCurrentCount(): " + c1.getCurrentCount());
    System.out.println("c2.getCurrentCount(): " + c2.getCurrentCount());

    System.out.println();

    System.out.println("Calls c2.increment()");
    c2.increment();
    System.out.println("c1.getCurrentCount(): " + c1.getCurrentCount());
    System.out.println("c2.getCurrentCount(): " + c2.getCurrentCount());
  }
}