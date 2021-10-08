package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

public class JobProviderBatch implements Runnable {
	PrintQueue queue;
	String user;

	public JobProviderBatch(final PrintQueue queue, final String user) {
		this.queue = queue;
		this.user = user;
	}

	@Override
	public void run() {
		// TODO Implementer denne metode
	}

}
