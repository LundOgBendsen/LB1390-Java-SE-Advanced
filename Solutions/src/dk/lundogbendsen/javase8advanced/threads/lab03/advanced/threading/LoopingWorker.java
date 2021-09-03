package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class LoopingWorker
{
  private Job job;
  private CompletionListener completionListener;
  private ExceptionListener exceptionListener;
  private long sleepTime;
  private boolean keepRunning = true;
  private InternalThread internalThread;
  private boolean deactivated = false;
  private Object lock = new Object();

  public LoopingWorker(final Job job, final CompletionListener completionListener, final ExceptionListener exceptionListener, final long sleepTime)
  {

    if (job == null)
    {
      String msg = "Parameter job must not be null";
      throw new IllegalArgumentException(msg);
    }
    else
      if (sleepTime < 0)
      {
        String msg = "Parameter sleepTime must not be less than 0";
        throw new IllegalArgumentException(msg);
      }

    this.job = job;
    this.completionListener = completionListener;
    this.exceptionListener = exceptionListener;
    this.sleepTime = sleepTime;

    internalThread = new InternalThread();
    internalThread.start();
  }

  private class InternalThread extends Thread
  {
    @Override
    public void run()
    {
      while (keepRunning)
      {
        try
        {
          waitIfDeactivated();
          executeJob();
          Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {

        }
        catch (Throwable e)
        {
          handleException(e);
        }
      }
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

  public void stopAsap() throws InterruptedException
  {
    keepRunning = false;
    internalThread.join();
  }

  public void deactivateAsap() throws InterruptedException
  {
    synchronized (lock)
    {
      deactivated = true;
      internalThread.interrupt();
      lock.wait();
    }

  }

  public void reactivate()
  {
    synchronized (lock)
    {
      deactivated = false;
      lock.notify();
    }
  }

  private void waitIfDeactivated()
  {
    if (deactivated)
    {
      try
      {
        synchronized (lock)
        {
          lock.notifyAll();
          lock.wait();
        }
      }
      catch (InterruptedException e)
      {
      }
    }
  }
}
