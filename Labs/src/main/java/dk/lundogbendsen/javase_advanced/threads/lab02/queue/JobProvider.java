package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

public class JobProvider implements Runnable {
	PrintQueue queue;
	String user;

	public JobProvider(final PrintQueue queue, final String user) {
		this.queue = queue;
		this.user = user;
	}

	@Override
	public void run() {
		// TODO Implement this method
	}

}
