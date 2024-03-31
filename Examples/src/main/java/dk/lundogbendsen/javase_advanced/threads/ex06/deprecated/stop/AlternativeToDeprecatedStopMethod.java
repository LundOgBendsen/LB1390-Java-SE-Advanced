package dk.lundogbendsen.javase_advanced.threads.ex06.deprecated.stop;

import java.util.Random;

/*
 * Illustrates a safe way to stop a thread
 * another thread on. The problem with the now deprecated
 * method stop( ) is that you don't know when it stops.
 * Maybe it is right in the middle of a thread changing
 * an object's state so the state is left null!!!
 */
public class AlternativeToDeprecatedStopMethod {
	public static void main(final String[] args) {
		Random ran = new Random();

		int[] counter = new int[2];

		for (int n = 0; n < 100; n++) {
			StopSafeThread thread = new StopSafeThread(counter);
			thread.start();
			try {
				int w = ran.nextInt(30) - 20;
				if (w > 0)
					Thread.sleep(w);
			} catch (InterruptedException e) {
			}
			Thread.yield();
			thread.makeSafeStop();
			System.out.println("n = " + n);
		}

		System.out.println("counter: " + counter[0] + " " + counter[1]);
	}
}