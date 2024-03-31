package dk.lundogbendsen.javase_advanced.threads.ex05.threadlocal;

import dk.lundogbendsen.javase_advanced.threads.utils.ThreadUtil;

/*
 * Demonstrates the use of the ThreadLocal class that allows creating
 * a reference to an object (encapsulated as a ThreadLocal object) whose value
 * is specific to each individual thread (where threads are usually share variables).
 */
public class DemonstrateThreadLocal {

	static public void main(final String[] args) {
		ThreadUtil.printThreadNames();

		for (int n = 0; n < 4; n++) {
			new Thread() {
				@Override
				public void run() {
					for (int m = 0; m < 5; m++) {
						DemonstrateThreadLocal.incrementAndPrintCounter();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// Will not happen
						}
					}
				}
			}.start();
		}
	}

	// This counter is shared between all threads
	static private Integer sharedCounter = 1;

	// This is not shared - each threads get it own object
	static private ThreadLocal<Integer> threadSpecificCounter = new ThreadLocal<Integer>() {
		// override the initialValue() method to tell the ThreadLocal class
		// what value ThreadLocal should return the first time a thread arrives
		@Override
		public Integer initialValue() {
			return 1;
		}
	};

	public static synchronized void incrementAndPrintCounter() {

		System.out.println("entered method incrementAndPrintCounter( )");

		int threadSpecific = threadSpecificCounter.get();
		System.out.println("   read values of shared counter and thread specific counter");
		System.out.println("   value of shared counter is: " + sharedCounter);
		System.out.println("   value of thread specific counter is: " + threadSpecific);

		sharedCounter = sharedCounter + 1;
		threadSpecificCounter.set(threadSpecific + 1);
		System.out.println("   incremented values of shared counter and thread specific counter\n");
	}
}
