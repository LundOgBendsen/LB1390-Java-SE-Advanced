package dk.lundogbendsen.javase_advanced.threads.ex09.deprecated.stop;

import java.util.Random;

/*
 * Illustrerer en sikker måde at lade en tråd stoppe
 * en anden tråd på. Problemet ved den nu deprecated'e
 * metode stop( ) er, at man ikke ved hvornår den stopper.
 * Måske er det lige midt i at en tråd er ved at ændre på
 * et objekts tilstand, så tilstanden efterlades ugyldig!!!
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