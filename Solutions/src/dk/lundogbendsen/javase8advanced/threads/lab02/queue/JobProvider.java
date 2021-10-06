package dk.lundogbendsen.javase8advanced.threads.lab02.queue;

public class JobProvider implements Runnable {
	private PrintQueue queue;
	private String user;
	private static int counter = 1;

	public JobProvider(final PrintQueue queue, final String user) {
		this.queue = queue;
		this.user = user;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (queue) {
				PrintJob job = new PrintJob("job nr. " + counter);
				queue.addJob(job);
				System.out.println(user + ": Lagde job nr. " + counter + " på køen");
				counter++;
				queue.notify();
			}
		}
	}

}
