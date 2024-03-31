package dk.lundogbendsen.javase_advanced.lambda.ex03;

public class MoreThanOneStatementLambda
{
  public static void main(final String[] args) throws InterruptedException
  {
    System.out.println("T1:");

    MyRun r1 = new MyRun();
    Thread t1 = new Thread(r1);
    t1.start();
    t1.join();

    System.out.println("T2:");

    Thread t2 = new Thread(() -> System.out.println("  Ran too"));
    t2.start();
    t2.join();

    System.out.println("T3:");

    Thread t3 = new Thread(() ->
    {
      for (int i = 0; i < 3; i++)
        System.out.println("  Ran too");
      System.out.println("  Out of breath...");
    });
    t3.start();
    t3.join();

    System.out.println("Done");
  }

}
