package dk.lundogbendsen.javase_advanced.threads.ex02.by.extension;

public class Printer extends Thread {
	String name;

	int timeBetweenPrints;

	int numberOfPrints;

	Printer(final String name, final int timeBetweenPrints, final int numberOfPrints) {
		this.name = name;
		this.timeBetweenPrints = timeBetweenPrints;
		this.numberOfPrints = numberOfPrints;
		this.start();
	}

	// The start() method call will execute this method
	// (equivalent to the main thread starting by calling the main method).
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