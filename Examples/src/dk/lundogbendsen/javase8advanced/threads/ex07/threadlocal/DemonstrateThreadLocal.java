package dk.lundogbendsen.javase8advanced.threads.ex07.threadlocal;

import dk.lundogbendsen.javase8advanced.threads.utils.ThreadUtil;

/*
 * Demonstrerer brugen af ThreadLocal-klassen, der gør det muligt at oprette
 * en reference til et objekt (indkapslet som et ThreadLocal-objekt), hvis værdi
 * er specifik for hver enkelt tråd (hvor tråde normalt deles om variable).
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

	// Denne tæller deles mellem alle tråde
	static private Integer sharedCounter = 1;

	// Denne tæller fungerer så alle tråde får hver deres
	static private ThreadLocal<Integer> threadSpecificCounter = new ThreadLocal<Integer>() {
		// override metoden initialValue for at fortælle ThreadLocal-klassen
		// hvilken værdi ThreadLocal skal returnere første gang en tråd kommer
		// forbi
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
