package dk.lundogbendsen.javase_advanced.threads.ex04.deamon;

import dk.lundogbendsen.javase_advanced.threads.utils.ThreadUtil;

/*
 * Indicates that a program stops when there are no more active threads left
 * or if only daemon threads remain. Shortly after the thread
 * NonDaemon has counted to 1,000 the program stops, even though
 * the thread Daemon would really like to have counted to 200,000.
 */
public class DaemonDoesNotPreventProgramExit {
	public static void main(final String[] args) {
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