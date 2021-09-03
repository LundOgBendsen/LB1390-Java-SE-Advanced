package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class Worker
{
  private Job job;
  private CompletionListener completionListener;
  private ExceptionListener exceptionListener;

  public Worker(final Job job, final CompletionListener completionListener, final ExceptionListener exceptionListener)
  {

    if (job == null)
    {
      String msg = "Parameter job must not be null";
      throw new IllegalArgumentException(msg);
    }

    this.job = job;
    this.completionListener = completionListener;
    this.exceptionListener = exceptionListener;

    InternalThread internalThread = new InternalThread();
    internalThread.start();
  }

  private class InternalThread extends Thread
  {
    @Override
    public void run()
    {
      try
      {
        executeJob();
      }
      catch (Throwable e)
      {
        handleException(e);
      }
    }

    private void executeJob() throws Exception
    {
      job.execute();
      if (completionListener != null)
      {
        completionListener.onJobCompletion(job);
      }
    }

    private void handleException(final Throwable e)
    {
      if (exceptionListener != null)
      {
        exceptionListener.onJobFailure(job, e);
      }
      else
      {
        e.printStackTrace(System.err);
      }
    }
  }
}
