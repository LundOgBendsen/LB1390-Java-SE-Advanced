package dk.lundogbendsen.javase8advanced.designpatterns.ex07.singleton.eager;

public class Counter
{
  // ***** SINGLETON PATTERN CODE *****

  // prevent other from instantiating the class
  private Counter()
  {
  }

  // eagerly instantiate the singleton-instance
  private static Counter singleton = new Counter();

  // enable clients to get a hold on the singleton
  public static Counter getSingleton()
  {
    return Counter.singleton;
  }

  // ***** ORDINARY CODE *****
  private int count;

  public void increment()
  {
    count++;
  }

  public int getCurrentCount()
  {
    return count;
  }
}