package dk.lundogbendsen.javase_advanced.threads.ex04.deamon;

public class Counter extends Thread {
	private int counter = 0;

	private int countTo = 0;

	public void setCountTo(final int countTo) {
		this.countTo = countTo;
	}

	@Override
	public void run() {
		while (counter <= countTo) {
			System.out.println(counter++);
		}
	}
}