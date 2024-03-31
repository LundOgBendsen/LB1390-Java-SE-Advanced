package dk.lundogbendsen.javase_advanced.threads.ex06.deprecated.stop;

public class StopSafeThread extends Thread {
	private int[] counter;

	public StopSafeThread(final int[] counter) {
		super();
		this.counter = counter;
	}

	private boolean keepRunning = true;

	public void makeSafeStop() {
		// ensures the method does not return until this thread is stopped
		while (this.isAlive()) {

			// tell this thread to stop as soon as possible
			this.keepRunning = false;

			// put the currently running thread to sleep to give 'this' thread
			// a chance to get to a place it can stop safely.
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void run() {
		while (this.keepRunning) {
			// safe place to stop
			notSafeToStopNow(counter);
			if (!this.keepRunning) {
				return;
			} // safe place to stop
			notSafeToStopNow(counter);
			if (!this.keepRunning) {
				return;
			} // safe place to stop
			notSafeToStopNow(counter);
		}
	}

	static void notSafeToStopNow(final int[] counter) {
		// simulates a block of code where it is essential to completed as an atomic operation
		System.out.println("Enters region where stop is unsafe");
		counter[0]++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		counter[1]++;
		System.out.println("Exits region where stop is unsafe");
	}
}