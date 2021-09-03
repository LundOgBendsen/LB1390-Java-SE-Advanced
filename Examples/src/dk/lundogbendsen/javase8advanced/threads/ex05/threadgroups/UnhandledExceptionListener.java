package dk.lundogbendsen.javase8advanced.threads.ex05.threadgroups;

public interface UnhandledExceptionListener
{
  public void unhandledException(Thread t, Throwable e);
}