package dk.lundogbendsen.javase8advanced.threads.ex09.start.only.once;

public class SimpleRunnable implements Runnable {
	boolean keepRunning = true;

	@Override
	public void run() {
		while (keepRunning) {
			System.out.println("SimpleRunnable.run( ) is running");
			System.out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}