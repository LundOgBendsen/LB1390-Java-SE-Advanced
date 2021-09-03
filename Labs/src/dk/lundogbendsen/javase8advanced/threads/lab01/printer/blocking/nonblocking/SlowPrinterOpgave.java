package dk.lundogbendsen.javase8advanced.threads.lab01.printer.blocking.nonblocking;

public class SlowPrinterOpgave
{
  public static void main(final String[] args)
  {
    String[] s1 = new String[20];
    for (int n = 0; n < s1.length; n++)
    {
      s1[n] = "A";
    }
    String[] s2 = new String[20];
    for (int n = 0; n < s2.length; n++)
    {
      s2[n] = "B";
    }
    String[] s3 = new String[20];
    for (int n = 0; n < s3.length; n++)
    {
      s3[n] = "C";
    }
    SlowPrinter.blockingPrint(s1);
    SlowPrinter.blockingPrint(s2);
    SlowPrinter.blockingPrint(s3);
    System.out.println();
    System.out.println();
    SlowPrinter.nonBlockingPrint(s1);
    SlowPrinter.nonBlockingPrint(s2);
    SlowPrinter.nonBlockingPrint(s3);

  }
}

class SlowPrinter
{
  public static void blockingPrint(final String[] s)
  {
    for (int n = 0; n < s.length; n++)
    {
      System.out.print(s[n]);
      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public static void nonBlockingPrint(final String[] s)
  {
    String msg = "nonBlockingPrint( String[ ] s ) not yet implemented";
    throw new NotImplementedException(msg);
  }
}

class NotImplementedException extends RuntimeException
{
  NotImplementedException()
  {
    super();
  }

  NotImplementedException(final String s)
  {
    super(s);
  }
}