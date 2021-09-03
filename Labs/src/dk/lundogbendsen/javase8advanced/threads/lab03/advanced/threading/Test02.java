package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class Test02
{

  public static void main(final String[] args)
  {

    ExceptionListener exceptionListener = new ExceptionListener()
    {
      @Override
      public void onJobFailure(final Job job, final Throwable reason)
      {
        System.err.println("The job: " + job);
        System.err.println("Failed because of: " + reason);
      }
    };

    Job job = new DivideAndPrintResultJob(4, 0);
    new Worker(job, null, exceptionListener);
  }
}
