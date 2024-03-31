package dk.lundogbendsen.javase_advanced.threads.ex06.deactivate;

public class DeactivatableThread extends Thread {
	private volatile boolean deactivated = false;

	private volatile Object lock = new Object();

	@Override
	public void run() {
		while (true) {
			slowPrint("The first unsafe place to pause…");
			waitIfDeactivated();// safe place to pause
			slowPrint("The second unsafe place to pause…");
			waitIfDeactivated();// safe place to pause
			slowPrint("The third unsafe place to pause…");
			waitIfDeactivated();// safe place to pause
			slowPrint("The forth unsafe place to pause…");
			waitIfDeactivated();// safe place to pause
		}
	}

	private void waitIfDeactivated() {
		if (deactivated) {
			try {
				synchronized (lock) {
					System.out.println();
					System.out.print("<<DEACTIVATED>>");
					lock.wait();
					System.out.println("<<REACTIVATED>>");
					System.out.println();
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public void deactivateAsap() {
		synchronized (lock) {
			System.out.print("<<deactivateAsap>>");
			deactivated = true;
		}
	}

	public void reactivate() {
		synchronized (lock) {
			System.out.print("<<reactivate>>");
			deactivated = false;
			lock.notify();
		}
	}

	public void slowPrint(final String msg) {
		for (int n = 0; n < msg.length(); n++) {
			try {
				Thread.sleep((int) (200 * Math.random()));
			} catch (InterruptedException e) {
			}
			System.out.print(msg.charAt(n));
			if (n == (msg.length() - 1)) {
				System.out.println();
			}
		}
	}
}