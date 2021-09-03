package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public interface ExceptionListener
{
  public void onJobFailure(Job job, Throwable reason);
}
