package dk.lundogbendsen.javase_advanced.threads.ex03.by.composition;

public class Printer implements Runnable {
	String name;

	int timeBetweenPrints;

	int numberOfPrints;

	private Thread thread;

	Printer(final String name, final int timeBetweenPrints, final int numberOfPrints) {
		this.name = name;
		this.timeBetweenPrints = timeBetweenPrints;
		this.numberOfPrints = numberOfPrints;
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public void run() {
		for (int n = 0; n < numberOfPrints; n++) {
			System.out.println(name);
			try {
				Thread.sleep(this.timeBetweenPrints);
			} catch (InterruptedException e) {
				// Never happens
			}
		}
	}
}