/*
 * Viser hvordan man kan lave en hensigtsmæssig udgave af suspend/resume.
 */
package dk.lundogbendsen.javase8advanced.threads.ex09.deactivate;

public class TestDeactivatableThread extends Thread
{
  public static void main(final String[] args) throws Exception
  {
    int SLEEP_LENGTH = 5000;
    DeactivatableThread t = new DeactivatableThread();
    t.start();
    while (true)
    {
      Thread.sleep(SLEEP_LENGTH);
      t.deactivateAsap();
      Thread.sleep(SLEEP_LENGTH);
      t.reactivate();
      Thread.sleep(SLEEP_LENGTH);
      t.deactivateAsap();
      Thread.sleep(SLEEP_LENGTH);
      t.reactivate();
      Thread.sleep(SLEEP_LENGTH);
      t.deactivateAsap();
      Thread.sleep(SLEEP_LENGTH);
      t.reactivate();
    }
  }
}
