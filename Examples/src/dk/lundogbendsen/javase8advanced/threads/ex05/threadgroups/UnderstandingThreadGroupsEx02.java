package dk.lundogbendsen.javase8advanced.threads.ex05.threadgroups;

import dk.lundogbendsen.javase8advanced.threads.utils.ThreadUtil;

/*
 * SAMMENHÆNG MELLEM TRÅDE OG TRÅD-GRUPPER
 * Det er irriterende at man ikke umiddelbart kan se hvilke tråde
 * og tråd-grupper der findes, samt deres relationer i forhold til
 * hinanden.
 *
 * Metoden ThreadUtil.showInvestigator( ) frembringer et grafisk
 * vindue, der viser hvilke tråde og tråd-grupper der eksisterer
 * på et givet tidspunkt, samt deres relation i forhold til hinanden.
 *
 * Kald metoden ThreadUtil.makeSnapshot( ) hver gang du ønsker
 * at få et situationsbillede over de eksisterende tråd-grupper og
 * de aktive tråde (dvs. de tråde der stadig kører deres run-metode).
 */
public class UnderstandingThreadGroupsEx02 {
	public static void main(final String[] args) {
		// ***************************************
		// Fremkalder et vindue, der kan vise forskellige snapshots af hvordan
		// situationen af tråde har set ud på forskellige tidspunkter. Man laver
		// nye snapshots ved at kalde makeSnapshot( String snapshotName ).
		ThreadUtil.showInvestigator();
		// ***************************************
		String msg;

		MyThread2 thread01 = new MyThread2("thread-01");
		msg = "Made Thread called thread-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread01.start();
		msg = "Started thread-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		ThreadGroup group01 = new ThreadGroup("group-01");
		msg = "Made ThreadGroup called group-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		MyThread2 thread02 = new MyThread2(group01, "thread-02");
		msg = "Made Thread called thread-02 in group-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread02.start();
		msg = "Started thread-02";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		ThreadGroup group02 = new ThreadGroup(group01, "group-02");
		msg = "Made ThreadGroup called group-02 in group-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		MyThread2 thread03 = new MyThread2(group02, "thread-03");
		msg = "Made Thread called thread-03 in group-02";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread03.start();
		msg = "Started thread-02";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		MyThread2 thread04 = new MyThread2(group01, "thread-04");
		msg = "Made Thread called thread-04 in group-01";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread04.start();
		msg = "Started thread- 04";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread03.makeSafeStop();
		msg = "Asked thread-03 to stop";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread01.makeSafeStop();
		msg = "Asked thread-01 to stop";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread02.makeSafeStop();
		msg = "Asked thread-02 to stop";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);

		thread04.makeSafeStop();
		msg = "Asked thread-04 to stop";
		System.out.println(msg);
		ThreadUtil.makeSnapshot(msg);
	}
}