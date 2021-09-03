package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class Test04
{

  public static void main(final String[] args) throws Exception
  {

    Job job = new PrintMessageJob("Hi");
    LoopingWorker worker = new LoopingWorker(job, null, null, 200);

    Thread.sleep(3000);

    worker.stopAsap();
    System.out.println("Stopped the looping worker");
  }
}
