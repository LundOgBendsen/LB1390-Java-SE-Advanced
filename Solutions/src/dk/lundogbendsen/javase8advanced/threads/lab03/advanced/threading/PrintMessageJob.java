package dk.lundogbendsen.javase8advanced.threads.lab03.advanced.threading;

public class PrintMessageJob implements Job
{

  private String message;

  public PrintMessageJob(final String message)
  {
    this.message = message;
  }

  @Override
  public void execute() throws Exception
  {
    System.out.println(message);
  }

}
