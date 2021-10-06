package dk.lundogbendsen.javase8advanced.threads.ex05.threadgroups;

public class MyThread extends Thread {

	public MyThread(final String name) {
		super(name);
	}

	public MyThread(final ThreadGroup group, final String name) {
		super(group, name);
	}

	private boolean keepRunning = true;

	public void makeSafeStop() {
		// sikrer metoden ikke returnerer før denne tråd er stoppet
		while (this.isAlive()) {
			// bed denne tråd stoppe hurtigst muligt
			this.keepRunning = false;
			// giv denne tråd en chance for at stoppe
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void run() {
		while (this.keepRunning) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Never happens
			}
		}
	}
}