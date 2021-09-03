package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class DivideAndRememberResultJob implements Job
{

  private int a;
  private int b;
  private int result;

  public DivideAndRememberResultJob(final int a, final int b)
  {
    this.a = a;
    this.b = b;
  }

  @Override
  public void execute() throws Exception
  {
    // simulate long running task
    try
    {
      Thread.sleep(500);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    // do the actual job
    result = a / b;
  }

  public int getResult()
  {
    return result;
  }

  @Override
  public String toString()
  {
    String s = "DivideAndRememberJob";
    s += "[a=" + a + ", b=" + b + ", result=" + result + "]";
    return s;
  }
}
