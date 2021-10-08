package dk.lundogbendsen.javase_advanced.threads.lab02.queue;

import java.util.LinkedList;
import java.util.List;

public class PrintQueue {

	private List<PrintJob> jobs = new LinkedList<PrintJob>();

	public void addJob(final PrintJob pj) {
		jobs.add(pj);
	}

	public synchronized PrintJob removeJob() {
		return jobs.remove(0);
	}

	public int size() {
		return jobs.size();
	}
}
