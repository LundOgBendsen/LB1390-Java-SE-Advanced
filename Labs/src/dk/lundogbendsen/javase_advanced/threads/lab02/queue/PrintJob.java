package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

public class PrintJob {
	String text;

	public PrintJob(final String string) {
		text = string;
	}

	@Override
	public String toString() {
		return text;
	}

}
