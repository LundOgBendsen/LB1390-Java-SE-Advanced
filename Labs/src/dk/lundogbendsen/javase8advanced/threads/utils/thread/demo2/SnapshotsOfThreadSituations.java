/*
 * SAMMENHÆNG MELLEM TRÅDE OG TRÅD-GRUPPER
 *
 * Det er irriterende, at man ikke umiddelbart kan se, hvilke tråde og
 * tråd-grupper der findes, samt deres relationer i forhold til hinanden.
 *
 * Metoden ThreadUtil.showInvestigator() frembringer et grafisk vindue, der
 * viser hvilke tråde og tråd-grupper, der eksisterede på et givet tidspunkt,
 * samt deres relation i forhold til hinanden.
 *
 * Kald metoden ThreadUtil.makeSnapshot(String snapShotName) hver gang du
 * ønsker at få et situationsbillede over de eksisterende tråd-grupper og de
 * aktive tråde (dvs. de tråde der stadig kører deres run-metode).
 */
package dk.lundogbendsen.javase8advanced.threads.utils.thread.demo2;

import dk.lundogbendsen.javase8advanced.threads.utils.thread.ThreadUtil;

public class SnapshotsOfThreadSituations {
	public static void main(final String[] args) {

		// Fremkalder et vindue, der kan vise forskellige snapshots af hvordan
		// situationen af tråde har set ud på forskellige tidspunkter. Man
		// laver nye snapshots ved at kalde makeSnapshot(String snapshotName).
		ThreadUtil.showInvestigator();

		String msg;

		MyThread thread01 = new MyThread("thread-01");
		msg = "Made Thread called thread01";
		ThreadUtil.makeSnapshot(msg);

		thread01.start();
		msg = "Started thread01";
		ThreadUtil.makeSnapshot(msg);

		ThreadGroup group01 = new ThreadGroup("group-01");
		msg = "Made ThreadGroup called group01";
		ThreadUtil.makeSnapshot(msg);

		MyThread thread02 = new MyThread(group01, "thread-02");
		msg = "Made Thread called thread02 in group01";
		ThreadUtil.makeSnapshot(msg);

		thread02.start();
		msg = "Started thread02";
		ThreadUtil.makeSnapshot(msg);

		ThreadGroup group02 = new ThreadGroup(group01, "group-02");
		msg = "Made ThreadGroup called group02 in group01";
		ThreadUtil.makeSnapshot(msg);

		MyThread thread03 = new MyThread(group02, "thread-03");
		msg = "Made Thread called thread03 in group02";
		ThreadUtil.makeSnapshot(msg);

		thread03.start();
		msg = "Started thread03";
		ThreadUtil.makeSnapshot(msg);

		MyThread thread04 = new MyThread(group01, "thread-04");
		msg = "Made Thread called thread04 in group01";
		ThreadUtil.makeSnapshot(msg);

		thread04.start();
		msg = "Started thread04";
		ThreadUtil.makeSnapshot(msg);

		thread03.stopAsap();
		msg = "Asked thread-03 to stop";
		ThreadUtil.makeSnapshot(msg);

		thread01.stopAsap();
		msg = "Asked thread-01 to stop";
		ThreadUtil.makeSnapshot(msg);

		thread02.stopAsap();
		msg = "Asked thread-02 to stop";
		ThreadUtil.makeSnapshot(msg);

		thread04.stopAsap();
		msg = "Asked thread-04 to stop";
		ThreadUtil.makeSnapshot(msg);
	}
}

class MyThread extends Thread {

	private boolean keepRunning = true;

	public MyThread(final String name) {
		super(name);
	}

	public MyThread(final ThreadGroup group, final String name) {
		super(group, name);
	}

	public void stopAsap() {
		keepRunning = false;
		try {
			// Tving tråden til at vågne hvis den sover...
			this.interrupt();
			// Få kaldet af stopAsap() til at blokere indtil tråden er stoppet.
			this.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (keepRunning) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Det er ok hvis tråden interruptes her...
			}
		}
	}
}