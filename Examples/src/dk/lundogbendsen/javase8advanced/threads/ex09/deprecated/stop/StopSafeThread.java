package dk.lundogbendsen.javase8advanced.threads.ex09.deprecated.stop;

public class StopSafeThread extends Thread {
	private int[] counter;

	public StopSafeThread(final int[] counter) {
		super();
		this.counter = counter;
	}

	private boolean keepRunning = true;

	public void makeSafeStop() {
		// sikrer metoden ikke returnerer før denne tråd er stoppet
		while (this.isAlive()) {

			// bed denne tråd stoppe hurtigst muligt
			this.keepRunning = false;

			// sæt tråden der kører nu, til at sove for at give 'this' tråd
			// en chance for at komme til et sted den kan stoppe sikkert.
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void run() {
		while (this.keepRunning) {
			// ufarligt sted at stoppe
			notSafeToStopNow(counter);
			if (!this.keepRunning) {
				return;
			} // ufarligt sted at stoppe
			notSafeToStopNow(counter);
			if (!this.keepRunning) {
				return;
			} // ufarligt sted at stoppe
			notSafeToStopNow(counter);
		}
	}

	static void notSafeToStopNow(final int[] counter) {
		// Er ikke farligt at stoppe her i virkeligheden - vi 'leger'
		// bare at vi fx er ved at sætte to personers spouse til
		// hinanden, hvorfor det ikke ville være smart at stoppe når
		// den ene er blevet sat, men ikke den anden (inkonsistens).
		System.out.println("Enters region where stop is dangerous");
		counter[0]++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		counter[1]++;
		System.out.println("Exits region where stop is dangerous");
	}
}