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

	// Det er med kaldet af denne metode den nye tråd starter
	// (svarende til at hovedtråden starter med at kalde main-metoden).
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