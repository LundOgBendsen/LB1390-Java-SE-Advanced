package dk.lundogbendsen.javase8advanced.threads.ex05.threadgroups;

/*
 * SAMMENHÆNG MELLEM TRÅDE OG TRÅD-GRUPPER
 * Bemærk det er svært at forstå hvad der sker...
 */
public class UnderstandingThreadGroupsEx01
{
  public static void main(final String[] args)
  {

    String msg;

    MyThread thread01 = new MyThread("thread-01");
    msg = "Made Thread called thread-01";
    System.out.println(msg);

    thread01.start();
    msg = "Started thread-01";
    System.out.println(msg);

    ThreadGroup group01 = new ThreadGroup("group-01");
    msg = "Made ThreadGroup called group-01";
    System.out.println(msg);

    MyThread thread02 = new MyThread(group01, "thread-02");
    msg = "Made Thread called thread-02 in group-01";
    System.out.println(msg);

    thread02.start();
    msg = "Started thread-02";
    System.out.println(msg);

    ThreadGroup group02 = new ThreadGroup(group01, "group-02");
    msg = "Made ThreadGroup called group-02 in group-01";
    System.out.println(msg);

    MyThread thread03 = new MyThread(group02, "thread-03");
    msg = "Made Thread called thread-03 in group-02";
    System.out.println(msg);

    thread03.start();
    msg = "Started thread02";
    System.out.println(msg);

    MyThread thread04 = new MyThread(group01, "thread-04");
    msg = "Made Thread called thread-04 in group-01";
    System.out.println(msg);

    thread04.start();
    msg = "Started thread-04";
    System.out.println(msg);

    thread03.makeSafeStop();
    msg = "Asked thread-03 to stop";
    System.out.println(msg);

    thread01.makeSafeStop();
    msg = "Asked thread-01 to stop";
    System.out.println(msg);

    thread02.makeSafeStop();
    msg = "Asked thread-02 to stop";
    System.out.println(msg);

    thread04.makeSafeStop();
    msg = "Asked thread-04 to stop";
    System.out.println(msg);
  }
}