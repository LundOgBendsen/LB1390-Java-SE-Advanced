package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

/**
 * This class is implemented as a singleton, since we only need one consumer thread
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
			// TODO Implement this method
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PrintQueue getQueue() {
		return queue;
	}

}
