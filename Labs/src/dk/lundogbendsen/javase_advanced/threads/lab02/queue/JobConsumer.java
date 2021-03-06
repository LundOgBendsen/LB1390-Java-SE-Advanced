package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

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
			// TODO Implementer denne metode
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
