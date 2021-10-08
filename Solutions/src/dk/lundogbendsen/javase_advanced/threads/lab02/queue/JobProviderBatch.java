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
		synchronized (queue) {
			for (int i = 0; i < 200; i++) {
				PrintJob job = new PrintJob("Job nr. " + i);

				queue.addJob(job);
				System.out.println(user + ": Lagde job nr. " + i + " på køen.");
			}
			queue.notify();
		}
	}
}
