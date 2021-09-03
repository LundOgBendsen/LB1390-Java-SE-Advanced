package dk.lundogbendsen.javase8advanced.threads.ex09.account;

public class TestProviders
{
  public static void main(String[] args)
  {
    //Vi opretter et Account objekt, der default har 500 kr. på kontoen (se Account klassen)
    Account account = new Account();
    AccountProvider t1 = new AccountProvider(account, 100, "AccountProvider-tråden");
    AccountConsumer t2 = new AccountConsumer(account, 500, "AccountConsumer-tråden");
    t1.start();
    t2.start();
  }
}
