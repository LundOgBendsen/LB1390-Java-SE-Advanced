package dk.lundogbendsen.javase8advanced.threads.lab02.queue;

/**
 * Denne klasse er implementeret som en singleton, da vi kun skal have én
 * consumer-tråd
 *
 * @author Kenneth
 *
 */
public class JobConsumer implements Runnable {

	private PrintQueue queue;
	private String name = "Consumer";
	private static JobConsumer consumer = new JobConsumer();

	private JobConsumer() {
	}

	public static JobConsumer getInstance() {
		return consumer;
	}

	public void setQueue(final PrintQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				if (queue.size() > 0) {
					PrintJob job = queue.removeJob();
					System.out.println(name + ": Fjernede " + job + " fra køen.");
				} else {
					try {
						queue.wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
