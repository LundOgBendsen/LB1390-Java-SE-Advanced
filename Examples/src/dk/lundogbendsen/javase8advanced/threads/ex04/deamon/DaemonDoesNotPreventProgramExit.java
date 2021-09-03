package dk.lundogbendsen.javase8advanced.threads.ex04.deamon;

import dk.lundogbendsen.javase8advanced.threads.utils.ThreadUtil;

/*
 * Viser at et program stopper, når der ikke er flere aktive tråde tilbage
 * eller hvis der kun er daemon-tråde tilbage. Kort efter tråden
 * NonDaemon har talt til 1.000 stopper programmet, selvom
 * tråden Daemon egentligt gerne ville have talt til 200.000.
 */
public class DaemonDoesNotPreventProgramExit
{
  public static void main(final String[] args)
  {
    ThreadUtil.printThreadNames();
    Counter daemon = new Counter();
    daemon.setName("Daemon");
    daemon.setDaemon(true);
    daemon.setCountTo(200000);
    daemon.start();
    Counter nonDaemon = new Counter();
    nonDaemon.setName("NonDaemon");
    nonDaemon.setCountTo(1000);
    nonDaemon.start();
  }
}